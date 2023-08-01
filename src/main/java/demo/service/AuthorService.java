package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.entiti.Author;
import demo.repository.AuthorRepo;

@Service
@Transactional
public class AuthorService {

	@Autowired
	private AuthorRepo authorRepo;

//Add new Author
	public Author createAuthor(Author author) {
		return authorRepo.save(author);
	}

// tim author dua tren id
	public Author findAuthorBaseOnId(Long id) {
		return authorRepo.findOneById(id);
	}

//getall tat ca cac book của tac giả
	public List<Author> getAll() {
		List<Author> list = authorRepo.findAll();
		return list;
	}

}
