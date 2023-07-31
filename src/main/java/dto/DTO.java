package dto;

public class DTO {
	private String title;
	private String name;
	private String gener;
	private Long authorid;

//thiếu constructor

	public DTO() {
	}

	public DTO(String title, String name, String gener, Long authorid) {
		this.title = title;
		this.name = name;
		this.gener = gener;
		this.authorid = authorid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGener() {
		return gener;
	}

	public void setGener(String gener) {
		this.gener = gener;
	}

	public Long getAuthorid() {
		return authorid;
	}

	public void setAuthorid(Long authorid) {
		this.authorid = authorid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
