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
AuthorRepo authorRepo;
//them moi mootj tacs giar
public Author createAuthor(Author author) {
	authorRepo.save(author);
	return author;
}
//getall tat ca cac book của tac giả
public List<Author> getAll(){
	List<Author> list= authorRepo.findAll();
	return list;
}
}
