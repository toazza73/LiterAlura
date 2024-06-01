package br.com.alura.LiterAlura.repository;

import br.com.alura.LiterAlura.model.Author;
import br.com.alura.LiterAlura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT l livros FROM Author a JOIN a.livros l")
    List<Book> buscaLivros ();

    @Query("SELECT l livros FROM Author a JOIN a.livros l WHERE l.linguas ILIKE %:idiomaBuscado%")
    List<Book> buscaLivrosIdioma (String idiomaBuscado);

   // @Query("SELECT v autoresVivos FROM Author a WHERE a.birth_year>=anoVivo AND a.death_year<=anoVivo")
   // List<Author> buscaAutorAno (int anoVivo);


}
