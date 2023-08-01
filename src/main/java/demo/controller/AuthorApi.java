package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.entiti.Author;
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
}
