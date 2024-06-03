package br.com.alura.LiterAlura.model;

import jakarta.persistence.*;

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
    public Book(String titulo, String linguas, int numeroDownloads) {
        this.titulo = titulo;
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
        return "\nTitulo: " + titulo +
                "\nAutor: " + autor.getName() +
                "\nIdioma: " + linguas +
                "\nNum. downloads: " + numeroDownloads;
    }
}
