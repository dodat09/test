package demo.entiti;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
//@NamedQuery(name="Author.findConditionAge",query="select a from author a where a.age< 18")
@Table(name="author")
public class Author { 

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private Long id;
@Column
private String name;
@Column
private String genre;
@Column
private int age;

@OneToMany(cascade=CascadeType.ALL,mappedBy="author")
private List<Book> books;
//@ManyToOne
//@JoinColumn(name = "author_id")
//private Book book;	
public Author(Long id, String name, String genre, int age) {
	this.id = id;
	this.name = name;
	this.genre = genre;
	this.age = age;
}

public Author() {
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getGenre() {
	return genre;
}

public void setGenre(String genre) {
	this.genre = genre;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

//public List<Book> getBooks() {
//	return books;
//}
//
//public void setBooks(List<Book> books) {
//	this.books = books;
//}

}

