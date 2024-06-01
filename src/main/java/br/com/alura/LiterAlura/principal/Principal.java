package br.com.alura.LiterAlura.principal;

import br.com.alura.LiterAlura.model.*;
import br.com.alura.LiterAlura.repository.AuthorRepository;
import br.com.alura.LiterAlura.service.ConsumoApi;
import br.com.alura.LiterAlura.service.ConverteDados;
import ch.qos.logback.core.encoder.JsonEscapeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


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

					Digite a opção escolhida:""";
            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            if (opcao == 1) {

                System.out.println("Digite o nome do livro");
                var nomeLivro = leitura.nextLine();

                var json = consumoApi.obterDados("https://gutendex.com/books/?search=" + nomeLivro.replace(" ", "%20"));
                //System.out.println(json);

                DadosResponse dadosApi = conversor.obterDados(json, DadosResponse.class);
                dadosResponse.add(dadosApi);
                //System.out.println(dadosResponse);

                String primeiroElemento = extrairPrimeiroElemento(dadosApi);
                System.out.println(primeiroElemento);
                System.out.println("\n");


            }
            if (opcao == 2) {

                List<Book> livrosBuscados = repositorio.buscaLivros();
                System.out.println( "\n---------- LIVROS REGISTRADOS ----------\n");
                livrosBuscados.forEach(System.out::println);
            }

            if (opcao == 3) {

                List<Author> autores = repositorio.findAll();
                //autores.forEach(b -> b.getName().forEach(System.out::println));
                System.out.println("\n---------- AUTORES REGISTRADOS ----------\n");
                autores.forEach(System.out::println);
            }

            if (opcao == 4) {

                //List<Author> autoresVivos = repositorio.buscaAutorAno(1900);
                //autores.forEach(b -> b.getName().forEach(System.out::println));
                System.out.println("\n---------- AUTORES VIVOS ----------\n");
               // autoresVivos.forEach(System.out::println);
            }

            if (opcao == 5) {

                List<Book> livrosPorIdioma = repositorio.buscaLivrosIdioma("en");
                System.out.println( "\n---------- LIVROS POR IDIOMA ----------\n");
                livrosPorIdioma.forEach(System.out::println);
            }
        }
    }

    public static String extrairPrimeiroElemento(DadosResponse response) {
        if (response.resultado().isEmpty()) {
            return "Lista vazia";
        }
        DadosResult primeiro = response.resultado().get(0);
        String titulo = primeiro.titulo();
        DadosAuthor primeiroAutor = primeiro.autor().get(0);
        String nomeAutor = primeiroAutor.nome();
        int nascimento = primeiroAutor.nascimento();
        int falecimento = primeiroAutor.falecimento();
        String idioma = primeiro.linguas().get(0);
        int downloads = primeiro.download();

        Author autor = new Author(nomeAutor, nascimento, falecimento);
        repositorio.save(autor);
        Book livro = new Book(titulo, autor, idioma, downloads);
        autor.getLivros().add(livro);
        repositorio.save(autor);


        return String.format("\n" +
                "------------------------------------\n" +
                "Título: %s\nAutor: %s\nIdioma: %s\nNúmero de Downloads: %d\n" +
                "____________________________________" +
                "", titulo, nomeAutor, idioma, downloads);
    }
}
