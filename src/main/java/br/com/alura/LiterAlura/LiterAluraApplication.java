package br.com.alura.LiterAlura;

import br.com.alura.LiterAlura.principal.Principal;
import br.com.alura.LiterAlura.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {
	@Autowired
	private AuthorRepository repositorio;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal(repositorio);
		principal.exibeMenu();

		//var json = consumoApi.obterDados("https://gutendex.com/books/80/");
		//var json = consumoApi.obterDados("https://gutendex.com/books/?search=Dracula");

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


}
}
