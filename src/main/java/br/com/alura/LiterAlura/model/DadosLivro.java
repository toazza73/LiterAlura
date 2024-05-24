package br.com.alura.LiterAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro( @JsonAlias("id") Integer id,
                          @JsonAlias("title") String titulo,
                          @JsonAlias("authors") List<Author> autor,
                          @JsonAlias("languages") List<String> linguas,
                          @JsonAlias("download_count") Integer download) {
}
