package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.dto.BookDTO;
import demo.entiti.Author;
import demo.entiti.Book;
import demo.service.AuthorService;
import demo.service.BookService;

@RestController
@RequestMapping("/a")
public class BookApi {

	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private BookService bookService;

	// them moi mot sách
	@PostMapping("/book")
 public String createBook(@RequestBody BookDTO bookDTO) {
	 Author author = authorService.findAuthorBaseOnId(bookDTO.getAuthor_id());
	 if(author == null) {
		 return "Khong tim dc author tuong ung trong DB";
	 }
	 
	 Book book = new Book();
	 book.setTitle(bookDTO.getTitle());
	 book.setIsbn(bookDTO.getIsbn());
	 book.setAuthor(author);
	 
//	 List<Book> list = bookService.findBookBaseOnTitle(book.getTitle());
//	 
//	 if(list!=null) {
//		 return "Da ton tai sach tuong ung";
//	 }
	 
	 bookService.createBook(book);
	 return "success";
 }

	// hien thị tat ca ra màn hình
	@GetMapping("/book")
	public List<Book> getAll() {
		return bookService.getAll();
	}
}
