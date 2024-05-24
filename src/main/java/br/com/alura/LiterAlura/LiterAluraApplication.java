package br.com.alura.LiterAlura;

import br.com.alura.LiterAlura.model.*;
import br.com.alura.LiterAlura.service.ConsumoApi;
import br.com.alura.LiterAlura.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("OLA");
		var consumoApi = new ConsumoApi();
		var consumo = new ArrayList<>();
		Scanner leitura = new Scanner(System.in);
		List<DadosLivro> dadosLivros = new ArrayList<>();
		List<DadosResult> dadosResult = new ArrayList<>();

		//var json = consumoApi.obterDados("https://gutendex.com/books/80/");
		//var json = consumoApi.obterDados("https://gutendex.com/books/?search=Dracula");
		//System.out.println(json);


		//DadosLivro dados = conversor.obterDados(json, DadosLivro.class);
		//dadosLivros.add(dados);

//		ConverteDados conversor = new ConverteDados();
//		DadosResult dados2 = conversor.obterDados(json, DadosResult.class);
//		dadosResult.add(dados2);
//		dadosResult.forEach(r-> System.out.println(r.toString()));
//		dadosResult.forEach(r-> r.resultado().forEach(t-> System.out.println(t.getTitle())));


//		for (int i = 20; i <= 23; i++){
//			json = consumoApi.obterDados("https://gutendex.com/books/" + i +"/");
//			dados = conversor.obterDados(json, DadosLivro.class);
//			dadosLivros.add(dados);
//		}

		//dadosLivros.forEach(t -> System.out.println(t.titulo()));
//		dadosLivros.forEach(t -> System.out.println(t.download()));
//		dadosLivros.forEach(a -> System.out.println(a.linguas()));
//		dadosLivros.forEach(a -> a.autor().forEach(n -> System.out.println(n.getBirth_year())));
//		dadosLivros.forEach(a -> a.autor().forEach(n -> System.out.println(n.getName())));

		ConverteDados conversor = new ConverteDados();
		var opcao = -1;
		while (opcao != 0) {
			var menu = """
					****** Escolha o número de sua Opção *****
					1 - Busca livro por título
					2 - Listar livros registrados

					Digite a opção escolhida:
					""";
			System.out.println(menu);
			opcao = leitura.nextInt();
			leitura.nextLine();

			if (opcao == 1) {

				System.out.println("Digite o nome do livro");
				var nomeLivro = leitura.nextLine();

				var json = consumoApi.obterDados("https://gutendex.com/books/?search=" + nomeLivro.replace(" ", "%20"));
				//System.out.println(json);


				DadosResult dados2 = conversor.obterDados(json, DadosResult.class);
				dadosResult.add(dados2);
				dadosResult.forEach(r-> r.resultado().forEach(t-> System.out.println(t.getTitle())));
				dadosResult.forEach(r-> r.resultado().forEach(a-> a.getAuthors().forEach(n-> System.out.println(n.getName()))));

				dadosResult.forEach(r-> System.out.println(r.toString()));
				//dadosResult.forEach(r-> r.resultado().forEach(t-> System.out.println(t.getTitle())));
				System.out.println();
				System.out.println();


			}
		}
	}
}
