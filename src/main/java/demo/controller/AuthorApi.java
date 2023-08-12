package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.entiti.Author;
import demo.entiti.Book;
import demo.service.AuthorService;

@RestController
@RequestMapping("/a")
public class AuthorApi {
@Autowired
AuthorService authorService;
//them moi mot authoor
@PostMapping("/author")
public Author creat(@RequestBody Author author) {
	authorService.createAuthor(author);
	return author;
}
//lay ra tât cả các author
@GetMapping("/author")
public Page<Author> getAllAuthor(@RequestParam(defaultValue="0") int page,
		                          @RequestParam(defaultValue="1")int size){
	Pageable pageable = PageRequest.of(page,size);
	Page<Author> author = authorService.getAllAuthor(pageable);
	return author;
}
//update thogn tin cua author dua vòa id của author
@PutMapping("/author/{id}")
public Author updateAuthorById(@PathVariable("id") Long id,@RequestBody Author author) {
	return authorService.updateAuthorById(author, id);
}
// lây ra một author dua vào id
@GetMapping("author/{id}")
public Author getAuthorByid(@PathVariable("id") int id) {
	return authorService.getAuthorByid(id);
}

// xoa 1 author dụa vào id 
@DeleteMapping("/author/{id}")
public String deleteAuthorByid(@PathVariable("id") Long id) {
	return authorService.deleteAuthorById(id);
}
// lấy ra danh sach các sach dưa vào id của tác giả
@GetMapping("/listbook/{id}")
public List<Book> getBookByAuthorId(@PathVariable("id") Long id){	
	return authorService.getBookByAuthorId(id);
	}
// laasy ra list cac author cos tuoi lon hon 18
//@GetMapping("/ageauthor")
//public List<Author> getAgeGreate18(){
//	return authorService.getAgeGreat18();
//}
// xoa auhor có tuoir trên 18
@DeleteMapping("/ageauthor")
public void deleteAuthor() {
   authorService.deleteAuthor();
}
}

