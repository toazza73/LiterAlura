package br.com.alura.LiterAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAuthor(@JsonAlias("name") String nome,
                          @JsonAlias("birth_year") Integer nascimento,
                          @JsonAlias("death_year") Integer falecimento) {
}