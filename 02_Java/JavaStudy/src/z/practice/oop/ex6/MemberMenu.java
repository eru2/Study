package z.practice.oop.ex6;

import java.util.Scanner;

public class MemberMenu {

	private Scanner sc = new Scanner(System.in);

	MemberController mc = new MemberController();

	public MemberMenu() {
		super();
	}

	public void mainMenu() {

		while (true) {
			System.out.println("최대 등록된 회원 수는" + mc.SIZE + "명 입니다.");
			System.out.println("현재 등록된 회원 수는 " + mc.existMemberNum() + "명 입니다.");
			
			if (mc.existMemberNum() != 10) {
				System.out.println("1. 새 회원 등록 ");
			} else {
				System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.");
			}
			System.out.println("2. 회원 검색");
			System.out.println("3. 회원 정보 수정 ");
			System.out.println("4. 회원 삭제 ");
			System.out.println("5. 모두 출력 ");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				this.inserMember();
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
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.printf("잘못 입력하셨습니다. 다시 입력해주세요. \n \n");

			}
		}
	}

	public void inserMember() {
		System.out.println("새 회원을 등록합니다.");
		String inputId, name, password, emailString;
		char gender;
		int age;
		while (true) {
			System.out.print("아이디 : ");
			inputId = sc.next();
			if (mc.checkId(inputId)) {
				break;
			} else {
				System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
			}
		}
		System.out.print("이름 : ");
		name = sc.next();
		
		System.out.print("비밀번호 : ");
		password = sc.next();
		
		System.out.print("이메일 : ");
		emailString = sc.next();
		
		while (true) {
			System.out.print("성별 (M/F) : ");
			gender = sc.next().charAt(0);

			if (gender == 'M' || gender == 'm' || gender == 'W' || gender == 'w') {
				break;
			} else {
				System.out.println("성별을 다시 입력하세요.");
			}
		}
		System.out.print("나이 : ");
		age = sc.nextInt();
		
		mc.insertMember(inputId, name, password, emailString, gender, age);
		System.out.println("회원 등록 완료");
		

	}

	public void searchMember() {
		System.out.println("1. 아이디로 검색하기");
		System.out.println("2. 이름으로 검색하기");
		System.out.println("3. 이메일로 검색하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 : ");
		int choice2 = sc.nextInt();
		
		switch(choice2){
		case 1:
			this.searchId();
			break;
		case 2:
			this.searchName();
			break;
		case 3:
			this.searchEmail();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				return;
		}
	}

	public void searchId() {
		System.out.print("검색할 아이디 : ");
		String id = sc.next();
		String member = mc.searchId(id);
		if(member == null) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}else {
			System.out.println("찾으신 회원 조회 결과입니다." );
			System.out.println(member);
		}
	}

	public void searchName() {
		System.out.print("검색할 이름 : ");
        String name = sc.next();
        
        Member[] mName = mc.searchName(name);
        
       
            if (mName[0] == null) {
            	System.out.println("검색 결과가 없습니다.");
                
            }else
            	System.out.println("찾으신 회원 조회 결과입니다.");
            for (Member mem : mName) {
            	if(mem == null)
            		break;
            	System.out.println(mem.infrom());
            return;
        }
	}

	public void searchEmail() {
		System.out.print("검색할 아이디 : ");
        String email = sc.next();
        Member[] mEmail = mc.searchEmail(email);
        if (mEmail[0] == null) {
        	System.out.println("검색 결과가 없습니다.");
            
        }else
        	System.out.println("찾으신 회원 조회 결과입니다.");
        for (Member mem : mEmail) {
        	if(mem == null)
        		break;
        	System.out.println(mem.infrom());
        return;
    }

	}

	public void updateMember() {
		System.out.println("1. 비밀번호 수정하기");
		System.out.println("2. 이름 수정하기");
		System.out.println("3. 이메일 수정하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 : ");
		int choice3 = sc.nextInt();
		switch(choice3){
		case 1:
			this.updatePassword();
			break;
		case 2:
			this.updateName();
			break;
		case 3:
			this.updateEmail();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				return;
		}
	}

	public void updatePassword() {
		String id, pwd;
		
		System.out.print("수정할 회원의 아이디");
		id = sc.next();
		
		System.out.println("수정할 비밀번호 : ");
		pwd = sc.next();
		sc.nextLine();
		
		boolean isUpdate = mc.updatePassword(id, pwd);
		
		if(isUpdate) {
			System.out.println("수정이 성공적으로 되었습니다.");
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}

	}

	public void updateName() {
		String id, name;
		
		System.out.print("수정할 회원의 아이디");
		id = sc.next();
		
		System.out.println("수정할 이름 : ");
		name = sc.next();
		sc.nextLine();
		
		boolean isUpdate = mc.updateName(id, name);
		
		if(isUpdate) {
			System.out.println("수정이 성공적으로 되었습니다.");
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}

	}

	public void updateEmail() {

		String id, email;
		
		System.out.print("수정할 회원의 아이디");
		id = sc.next();
		
		System.out.println("수정할 이메일 : ");
		email = sc.next();
		sc.nextLine();
		
		boolean isUpdate = mc.updateEmail(id, email);
		
		if(isUpdate) {
			System.out.println("수정이 성공적으로 되었습니다.");
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
	}

	public void deleteMember() {

		System.out.println("1. 특정 회원 삭제하기");
		System.out.println("2. 전체 회원 삭제");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 : ");
		int choice3 = sc.nextInt();
		switch(choice3){
		case 1:
			this.deleteOne();
			break;
		case 2:
			this.deleteAll();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				return;
		}
	}

	public void deleteOne() {

	String id;
	System.out.println("삭제할 ID : ");
	id = sc.next();
	
	System.out.println("정말 삭제하시겠습니까? (y/n) : ");
	char result = sc.next().toLowerCase().charAt(0);
	
	if(result == 'y') {
		boolean isDelete = mc.delete(id);
		if(isDelete) {
		System.out.println("성공적으로 삭제하였습니다.");
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
	}
	
		
	}

	public void deleteAll() {

		System.out.println("정말 삭제하시겠습니까? (y/n) : ");
		char result = sc.next().toLowerCase().charAt(0);
		
		if(result == 'y') {
			mc.delete();
			System.out.println("성공적으로 삭제하였습니다.");
		}
		
		
	}

	public void printAll() {
		Member[] mArr = mc.printAll();
		for(Member mem : mArr) {
			if(mem == null)
				break;
			System.out.println(mem.infrom());
		}

	}

}
