package demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.entiti.Book;
@Repository
public interface BookRepo extends JpaRepository<Book,Long>{
 List<Book> findByTitle(String title);
 
 List<Book> findByIsbn(String isbn);
 
 Book findOneById(Long id);
}
