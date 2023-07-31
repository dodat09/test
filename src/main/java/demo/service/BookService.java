package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.entiti.Author;
import demo.entiti.Book;
import demo.repository.AuthorRepo;
import demo.repository.BookRepo;
import dto.DTO;

@Service
public class BookService {

	@Autowired
	BookRepo bookRepo;
	@Autowired
	AuthorRepo authorRepo;

	// theem mois mot sach moi
	public Book createBook(DTO dto) {
		Book book =new Book();
		Author author=authorRepo.findOneById(dto.getAuthorid());
		book.setTitle(dto.getTitle());
		book.setIsbn(dto.getName());
		book.setAuthor(author);
		bookRepo.save(book);
		return book;
	}
	// hien thi
	public List<Book> getAll() {
		return bookRepo.findAll();
	}
	
//	public Book saveBook(BookDto dto) {
//		Book book = new Book();
//		book.setTitle(dto.getTitle());
//		book.setIsbn(dto.getIsbn());
//		book.setAuthor_id(dto.getAuthor_id());
//		return bookRepo.save(book);
//	}
	

	
}
