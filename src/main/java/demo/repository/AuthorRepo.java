package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entiti.Author;

public interface AuthorRepo extends JpaRepository<Author,Long> {
	
//	@Query(value = "select * from author where author_id = :id")
//	Author findByAuthorId(@Param("id") Long id);
	Author findOneById(Long id);
	
}
