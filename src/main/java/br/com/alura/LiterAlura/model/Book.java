package br.com.alura.LiterAlura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="livros")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    @ManyToOne
    private Author autor;

    private String linguas;
    private int numeroDownloads;

    public Book() { }
    public Book(String titulo, Author autor, String linguas, int numeroDownloads) {
        this.titulo = titulo;
        this.autor = autor;
        this.linguas = linguas;
        this.numeroDownloads = numeroDownloads;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Author getAutor() {
        return autor;
    }

    public void setAutor(Author autor) {
        this.autor = autor;
    }

    public String getLinguas() {
        return linguas;
    }

    public int getNumeroDownloads() {
        return numeroDownloads;
    }

    @Override
    public String toString() {
        return "Titulo = " + titulo +
                "\nAutor = " + autor.getName() +
                "\nIdioma = " + linguas +
                "\nNum. de downloads = " + numeroDownloads + "\n";
    }
}
