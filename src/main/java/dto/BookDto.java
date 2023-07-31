package dto;


public class BookDto {

	private String title;
	private String isbn;
	private Long author_id;
	public BookDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookDto(String title, String isbn, Long author_id) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.author_id = author_id;
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
	public Long getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(Long author_id) {
		this.author_id = author_id;
	}
	
}
