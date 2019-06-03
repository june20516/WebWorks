package member.model;

public class MemberDTO {
	
	private String id;
	private String pw;
	private String pwRetype;
	private String name;
	private String tel1;
	private String tel2;
	private String tel3;
	private String birth1;
	private String birth2;
	private String birth3;
	private String sex;
	private String email;

	
	
	public MemberDTO() {
	
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPwRetype() {
		return pwRetype;
	}
	public void setPwRetype(String pwRetype) {
		this.pwRetype = pwRetype;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public String getTel3() {
		return tel3;
	}
	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}
	public String getBirth1() {
		return birth1;
	}
	public void setBirth1(String birth1) {
		this.birth1 = birth1;
	}
	public String getBirth2() {
		return birth2;
	}
	public void setBirth2(String birth2) {
		this.birth2 = birth2;
	}
	public String getBirth3() {
		return birth3;
	}
	public void setBirth3(String birth3) {
		this.birth3 = birth3;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "DTO [id=" + id + ", pw=" + pw + ", pwRetype=" + pwRetype + ", name=" + name + ", tel1=" + tel1
				+ ", tel2=" + tel2 + ", tel3=" + tel3 + ", birth1=" + birth1 + ", birth2=" + birth2 + ", birth3="
				+ birth3 + ", sex=" + sex + ", email=" + email + "]";
	}
	
	
}
