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
	}
}
