package z.practice.oop.ex6.re;

import java.util.Scanner;

public class MemberMenu {

	private Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	
	
	public MemberMenu() {
		super();
	}
	
	public void mainMenu() {
		System.out.println("최대 등록 가능한 회원 수는 " + mc.SIZE + "명입니다.");
		System.out.println("현재 등록된 회원 수는 " + mc.existMembrNum() + "명입니다.");
		System.out.println();
		
		while(true) {
			if(mc.existMembrNum() == 10) {
				System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다");
			} else {
				System.out.println("1. 새 회원 등록");
			}
			System.out.println("2. 회원 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 모두 출력");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				System.out.println("새 회원을 등록합니다.");
				this.insertMember();
				break;
			case 2:
				this.searchMember();
				break;
			case 3:
				this.updateMember();
				break;
			case 4:
				this.deleteMember();
				break;
			case 5:
				this.printAll();
				break;
			case 9:
				return;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
		
	}
	
	public void insertMember() {
		char gender;
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("비밀번호 : ");
		String password = sc.next();
		System.out.print("이메일 : ");
		String email = sc.next();
		System.out.print("성벌(M/F) : ");
		while(true) {
			gender = sc.next().toLowerCase().charAt(0);
			if(gender != 'm' || gender != 'f') {
				System.out.println("성별을 다시 입력하세요.");
			} else
				break;
		}
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		mc.insertMember(id, name, password, email, gender, age);
		
	}
	
	public void searchMember() {
		
	}
	
	public void searchId() {
		
	}
	
	public void searchEmail() {
		
	}
	
	public void updateMember() {
		
	}
	
	public void updatePassword() {
		
	}
	
	public void updateName() {
		
	}
	
	public void updateEmail() {
		
	}
	
	public void deleteMember() {
		
	}
	
	public void deleteOne() {
		
	}
	
	public void deleteAll() {
		
	}
	
	public void printAll() {
			System.out.println(mc.printAll());
	}
	
	
}
