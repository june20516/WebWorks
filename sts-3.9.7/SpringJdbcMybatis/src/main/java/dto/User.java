package dto;

public class User {
	
	private String id;
	private String name;
	private String password;

	public User(String userId, String name, String password) {
		super();
		this.id = userId;
		this.name = name;
		this.password = password;
	}
	
	public User() {
		
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPw() {
		return password;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPw(String pw) {
		this.password = pw;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	
	
	
}
