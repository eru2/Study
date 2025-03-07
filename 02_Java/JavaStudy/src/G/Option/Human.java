package G.Option;

public class Human {
	//필드(private) -> 외부에 접근을 막아 데이터를 의도에 맞게 사용할 수 있게 만든다 -> 정보은닉
	
	private String name;
	private int age;
	static int count = 0;
	
	public Human() {
		super();
	}


	public Human(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		this.count++;
	}

	//외부에서 접근가능하도록 getter/setter를 작성해준다.
	//모든 데이터에 접근은 메서드를 통해서 한다.

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	public static int getCount() {
		return count;
	}


	public static void setCount(int count) {
		Human.count = count;
	}
	
	public void inform() {
		System.out.println("이름 : " + this.name);
		System.out.println("나이 : " + this.age);
		System.out.println("총 회원 수 : " + this.count);
	}
	
	

}
