package demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import demo.entiti.Book;

@Repository
@Transactional(readOnly = true)
public interface BookRepo extends JpaRepository<Book,Long>{
 List<Book> findByTitle(String title);
 
}
