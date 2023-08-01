package demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entiti.Book;

public interface BookRepo extends JpaRepository<Book,Long>{
 List<Book> findByTitle(String title);
 
 List<Book> findByIsbn(String isbn);
 
}
