package demo.entiti;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
@Column
private String title;
@Column
private String isbn;   
//private Long author_id;
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name= "author_id")
private Author author;
//@OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
//private Set<Author> Authors;

public Book() {
}

public Book(String title, String isbn) {
	this.title = title;
	this.isbn = isbn;
	//this.author_id = author_id;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getIsbn() {
	return isbn;
}

public void setIsbn(String isbn) {
	this.isbn = isbn;
}

public Author getAuthor() {
	return author;
}

public void setAuthor(Author author) {
	this.author = author;
}

//public Set<Author> getAuthors() {
//	return Authors;
//}
//
//public void setAuthors(Set<Author> authors) {
//	Authors = authors;
//}

//public Long getAuthor_id() {
//	return author_id;
//}
//
//public void setAuthor_id(Long author_id) {
//	this.author_id = author_id;
//}

}