package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import demo.entiti.Author;

@Repository
@Transactional
public interface AuthorRepo extends JpaRepository<Author,Long> {
	
//	@Query(value = "select * from author where author_id = :id")
//	Author findByAuthorId(@Param("id") Long id);
	Author findOneById(Long id);
}
