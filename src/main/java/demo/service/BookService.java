package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dto.BookDTO;
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
	public List<Book> getAllBook() {
		return bookRepo.findAll();
	}
	//hien thi dạu trên id sach
	public Book getBookById(Long id) {
		return bookRepo.findOneById(id);
	}
    //xoa sach dưa tren id sach
	public String deleteBookById(Long id) {
		bookRepo.delete(bookRepo.findOneById(id));
		return "xóa thành công sách có id = "+id;
		}
    //update book dưa vào id 
	public Book updateBookById(BookDTO bookDTO , Long id) {
		Book book= bookRepo.findOneById(id);
		book.setAuthor(authorRepo.findOneById(bookDTO.getAuthor_id()));
		book.setIsbn(bookDTO.getIsbn());
		book.setTitle(bookDTO.getTitle());
		bookRepo.save(book);
		return book;
	}
	

}
