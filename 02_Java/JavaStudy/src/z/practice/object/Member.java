package z.practice.object;

public class Member {

	String id;
	String pwd;
	String name;
	String phone;
	String email;
	int age;
	String gender;
		
	// alt + shift + s -> o
	public Member() {
		super();
	}
	
	public Member(String id, String pwd, String name) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}
	
	public void setInfo(String phone, String email, int age, String gender) {
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.gender = gender;
	}
	
	public void toInfo() {
		System.out.printf("id : %s  pwd : %s  name : %s  phone : %s  email : %s  age : %d  gender : %s \n", this.id, this.pwd, this.name, this.phone, this.email, this.age, this.gender);
		
	}
}
