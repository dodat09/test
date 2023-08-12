package demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import demo.entiti.Author;
@Repository
public interface AuthorRepo extends JpaRepository<Author,Long> {
	
//	@Query(value = "select * from author where author_id = :id")
//	Author findByAuthorId(@Param("id") Long id);
	Author findOneById(Long id);
	Page<Author> findAll(Pageable pageable);
	
	// tim kiếm author dựa vào id
	@Query(value="select a from author a where a.id= :id",nativeQuery=true)
	Author findAcountByid(@Param("id") int id);
	
	@Modifying
	@Query(value="delete from author a where age >18",nativeQuery=true)
	void deleteByAge();
}
