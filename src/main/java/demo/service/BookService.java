package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.entiti.Book;
import demo.repository.AuthorRepo;
import demo.repository.BookRepo;

@Service
public class BookService {

	@Autowired
	BookRepo bookRepo;
	@Autowired
	AuthorRepo authorRepo;

	// theem mois mot sach moi
	public boolean createBook(Book book) {
		try {
			bookRepo.save(book);
			return true;
		} catch (Exception e) {
			System.out.println("Error when you try save BOOK!");
			return false;
		}
	}

	// tim theo tieu de sach
	public List<Book> findBookBaseOnTitle(String title) {
		return bookRepo.findByTitle(title);
	}

	// tim theo tieu de sach
	public List<Book> findBookBaseOnIsbn(String isbn) {
		return bookRepo.findByIsbn(isbn);
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
