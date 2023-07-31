package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.entiti.Book;
import demo.service.BookService;
import dto.DTO;

@RestController
@RequestMapping("/a")
public class BookApi {
 @Autowired
 BookService bookService;
 
 //them moi mot sách
 @PostMapping("/book")
 public Book creteBook(@RequestBody DTO dto) {
	return  bookService.createBook(dto);
 }
 //hien thị tat ca ra màn hình
 @GetMapping("/book")
 public List<Book> getAll(){
	 return bookService.getAll();
 }
}
