package jdbcapi;

public class User {
	
	private String userId;
	private String name;
	private String password;
	
	public String getUserId() {
		return userId;
	}
	public String getName() {
		return name;
	}
	public User(String userId, String name, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
	}
	
	public User() {
		
	}
	
	public String getPassword() {
		return password;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
