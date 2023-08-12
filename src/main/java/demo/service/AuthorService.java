package demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.entiti.Author;
import demo.entiti.Book;
import demo.repository.AuthorRepo;
import demo.repository.BookRepo;

@Service
@Transactional
public class AuthorService {

	@Autowired
	private AuthorRepo authorRepo;
    @Autowired
    private BookRepo bookRepo;
//Add new Author
	public Author createAuthor(Author author) {
		return authorRepo.save(author);
	}

// tim author dua tren id
	public Author findAuthorBaseOnId(Long id) {
		return authorRepo.findOneById(id);
	}

//getall tat ca cac  tac giả
	public Page<Author> getAllAuthor(Pageable pageable) {
		
		return authorRepo.findAll(pageable);
	}
	//xoa author dua tren id
	public String deleteAuthorById(Long id) {
		authorRepo.delete(authorRepo.findOneById(id));
		return "xoa thanh cong author có id="+id;
	}
	// update thông tin mới dựa vòa id
	public Author updateAuthorById(Author author , Long id) {
		Author author1= authorRepo.findOneById(id);
		author1.setAge(author.getAge());
		author1.setGenre(author.getGenre());
		author1.setName(author.getName());
		authorRepo.save(author1);
		return author1;
	}
// láy tất cả các sách của 1 author dựa vào id
	//public List<Book> getBookByIdAuthor(Long authorid){
//		Author author = new Author();
//		
//		List<Book> list = new ArrayList();
//		
		//return list;
	//}
	//list các sach của tác giả dụa vào id của tác giả
	public List<Book> getBookByAuthorId(Long id){
		List<Book> list= new ArrayList<Book>();
		List<Book> listBook = bookRepo.findAll();
		for(Book a : listBook) {
			Author b = a.getAuthor();
			if(b.getId()==id) {
				list.add(a);
			}
		}
		return list;
		
	}
	// list author cos tuooir lown hown 18
//	public List<Author> getAgeGreat18(){
//		List<Author> list = authorRepo.findConditionAge();
//		return list;
	//}
	//xóa author có tuoir lơn hơn 18
	public void deleteAuthor() {
		authorRepo.deleteByAge();
	}
	// tim author dựa vào id của author
	public Author getAuthorByid(int id) {
		return authorRepo.findAcountByid(id);
	}
}
















