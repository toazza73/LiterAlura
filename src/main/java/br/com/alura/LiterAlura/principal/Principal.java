package br.com.alura.LiterAlura.principal;

import br.com.alura.LiterAlura.model.*;
import br.com.alura.LiterAlura.repository.AuthorRepository;
import br.com.alura.LiterAlura.service.ConsumoApi;
import br.com.alura.LiterAlura.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    protected static AuthorRepository repositorio;

    public Principal(AuthorRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu(){

        Scanner leitura = new Scanner(System.in);
        var consumoApi = new ConsumoApi();
        List<DadosResponse> dadosResponse = new ArrayList<>();
        ConverteDados conversor = new ConverteDados();

        var opcao = -1;
        while (opcao != 0) {
            var menu = """
					
					****** Escolha o número de sua Opção *****
					
					1 - Busca livro por título
					2 - Lista livros registrados
					3 - Lista autores registrados
					4 - Lista autores vivos em determinado ano
					5 - Lista livros em determinado idioma
					
					0 - SAIR DO PROGRAMA

					Digite a opção escolhida: """;
            System.out.print(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            if (opcao == 1) {
                System.out.println("Digite o nome do livro");
                var nomeLivro = leitura.nextLine();

                var json = consumoApi.obterDados("https://gutendex.com/books/?search=" + nomeLivro.replace(" ", "%20"));

                DadosResponse dadosApi = conversor.obterDados(json, DadosResponse.class);
                dadosResponse.add(dadosApi);

                String primeiroElemento = extrairPrimeiroElemento(dadosApi);
                System.out.println(primeiroElemento);
                System.out.println("\n");
            }

            if (opcao == 2) {
                List<Book> livrosBuscados = repositorio.buscaLivros();
                System.out.println( "\n---------- LIVROS REGISTRADOS ----------");
                livrosBuscados.forEach(System.out::println);
                if (livrosBuscados.isEmpty()) {
                    System.out.println("\nNenhum livro foi registrado ainda !");
                }
            }

            if (opcao == 3) {
                List<Author> autores = repositorio.findAll();
                System.out.println("\n---------- AUTORES REGISTRADOS ----------");
                autores.forEach(System.out::println);
                if (autores.isEmpty()) {
                    System.out.println("\nNenhum autor foi registrado ainda !");
                }
            }

            if (opcao == 4) {
                System.out.println("Digite o ano escolhido");
                int ano = leitura.nextInt();
                System.out.println("\n------- AUTORES VIVOS EM " + ano + " -------");
                List<Author> autores = repositorio.findAll();
                List<Author> autoresVivos = autores.stream()
                        .filter(a -> a.getBirth_year() <= ano && a.getDeath_year()>= ano)
                        .collect(Collectors.toList());

                autoresVivos.forEach(a -> System.out.println("\nNome: " + a.getName() +
                        "\n* " + a.getBirth_year() +
                        "  + " + a.getDeath_year()));

                if (autoresVivos.isEmpty()) {
                    System.out.println("\nNenhum autor cadastrado estava vivo !");
                }
            }

            if (opcao == 5) {
                var opcaoIdioma = """
                        \nDigite o idioma escolhido conforme abaixo:
                        pt - Português
                        es - Espanhol
                        en - Inglês
                        fr - Francês
                        de - Alemão
                        """;
                System.out.print(opcaoIdioma);
                var idiomaLivro = leitura.nextLine();
                List<Book> livrosPorIdioma = repositorio.buscaLivrosIdioma(idiomaLivro);
                System.out.println( "\n---------- LIVROS POR IDIOMA ----------");
                if (livrosPorIdioma.isEmpty()) {
                    System.out.println("Nenhum livro cadastrado neste idioma !");
                }
                livrosPorIdioma.forEach(System.out::println);
            }
            System.out.println("---------------------------------------\n");
        }
    }

    public static String extrairPrimeiroElemento(DadosResponse response) {
        if (response.resultado().isEmpty()) {
            return "O livro não está no Gutendex !";
        }
        DadosResult primeiro = response.resultado().get(0);
        String titulo = primeiro.titulo();
        DadosAuthor primeiroAutor = primeiro.autor().get(0);
        String nomeAutor = primeiroAutor.nome();
        int nascimento = primeiroAutor.nascimento();
        int falecimento = primeiroAutor.falecimento();
        String idioma = primeiro.linguas().get(0);
        int downloads = primeiro.download();

        Optional<Author> autores = repositorio.findByNameContainingIgnoreCase(nomeAutor);
       if (autores.isPresent()) {
            Book livro = new Book(titulo, idioma, downloads);
            livro.setAutor(autores.get());
            autores.get().getLivros().add(livro);
            repositorio.save(autores.get());
        }

        else{
            Author autor = new Author(nomeAutor, nascimento, falecimento);
            repositorio.save(autor);
            Book livro = new Book(titulo, autor, idioma, downloads);
            autor.getLivros().add(livro);
            repositorio.save(autor);
        }

        return String.format("\n" + "------------------------------------\n" +
                "Título: %s\nAutor: %s\nIdioma: %s\nNúmero de Downloads: %d\n" +
                "____________________________________" + "", titulo, nomeAutor, idioma, downloads);
    }
}
