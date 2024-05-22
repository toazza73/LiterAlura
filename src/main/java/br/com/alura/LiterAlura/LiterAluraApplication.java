package br.com.alura.LiterAlura;

import br.com.alura.LiterAlura.model.DadosLivro;
import br.com.alura.LiterAlura.service.ConsumoApi;
import br.com.alura.LiterAlura.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("OLA");
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://gutendex.com/books/84/");
		System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadosLivro dados = conversor.obterDados(json, DadosLivro.class);

		System.out.println(dados);
	}
}
