package br.com.alura.LiterAlura.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autor")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private int birth_year;
    private int death_year;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> livros = new ArrayList<>();

    public Author() {}
    public Author(String name, int birth_year, int death_year) {
        this.name = name;
        this.birth_year = birth_year;
        this.death_year = death_year;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getBirth_year() { return birth_year; }
    public void setBirth_year(int birth_year) { this.birth_year = birth_year; }

    public int getDeath_year() { return death_year; }
    public void setDeath_year(int death_year) { this.death_year = death_year; }

    public List<Book> getLivros() {
        return livros;
    }

    public void setLivros(List<Book> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return  "Autor = " + name +
                "\nAno Nascimento = " + birth_year +
                "\nAno Falecimento = " + death_year + "\n";
    }
}
