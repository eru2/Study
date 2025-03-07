package z.practice.map.ex1;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class MemberMenu {
    private Scanner sc = new Scanner(System.in);
    private MemberController mc = new MemberController();

    public void mainMenu() {
        while (true) {
            System.out.println("========== KH 사이트 ==========");
            System.out.println("=====***** 메인 메뉴 *****=====");
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("3. 같은 이름 회원 찾기");
            System.out.println("9. 종료");
            System.out.print("메뉴 번호 입력 : ");
            int menuNum = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            switch (menuNum) {
                case 1:
                    joinMembership();
                    break;
                case 2:
                    logIn();
                    break;
                case 3:
                    sameName();
                    break;
                case 9:
                    System.out.println("프로그램 종료");
                    return;
                default:
                    System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
            }
        }
    }

    public void memberMenu() {
        while (true) {
            System.out.println("=====***** 회원 메뉴 *****=====");
            System.out.println("1. 비밀번호 바꾸기");
            System.out.println("2. 이름 바꾸기");
            System.out.println("3. 로그아웃");
            System.out.print("메뉴 번호 입력 : ");
            int menuNum = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            switch (menuNum) {
                case 1:
                    changePassword();
                    break;
                case 2:
                    changeName();
                    break;
                case 3:
                    System.out.println("로그아웃 되었습니다.");
                    return;
                default:
                    System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
            }
        }
    }

    public void joinMembership() {
        System.out.print("아이디 : ");
        String id = sc.nextLine();
        System.out.print("비밀번호 : ");
        String password = sc.nextLine();
        System.out.print("이름 : ");
        String name = sc.nextLine();

        Member member = new Member(password, name);
        boolean result = mc.joinMembership(id, member);
        if (result) {
            System.out.println("성공적으로 회원가입 완료하였습니다.");
        } else {
            System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
        }
    }

    public void logIn() {
        while (true) {
            System.out.print("아이디 : ");
            String id = sc.nextLine();
            System.out.print("비밀번호 : ");
            String password = sc.nextLine();

            String name = mc.logIn(id, password);
            if (name != null) {
                System.out.println(name + "님, 환영합니다!");
                memberMenu();
                break;
            } else {
                System.out.println("틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요.");
            }
        }
    }
    public void changePassword() {
    	  System.out.print("아이디 : ");
          String id = sc.nextLine();
          System.out.print("비밀번호 : ");
          String password = sc.nextLine();
          
        System.out.print("새로운 비밀번호 : ");
        String newPw = sc.nextLine();

        boolean result = mc.changePassword(id, password, newPw);
        if (result) {
            System.out.println("비밀번호 변경에 성공했습니다.");
        } else {
            System.out.println("비밀번호 변경에 실패했습니다. 다시 입력해주세요.");
        }
    }

    public void changeName() {
    	  System.out.print("아이디 : ");
          String id = sc.nextLine();
          System.out.print("비밀번호 : ");
          String password = sc.nextLine();
        String currentName = mc.logIn(id, password); 
        System.out.println(currentName);
        System.out.print("변경할 이름 : ");
        String newName = sc.nextLine();
        mc.changeName(id, newName);
        System.out.println("이름 변경에 성공했습니다.");
    }

    public void sameName() {
    	System.out.print("이름 : ");
        String name = sc.nextLine();
        TreeMap result = mc.sameName(name);
        if(result.isEmpty()) {
        	System.out.println(name + "이라는 회원을 찾지 못하였습니다.");
        } else {
        	for(Object entry : result.entrySet()) {
        		Entry<String, String> en = (Entry)entry;
        		System.out.println(en.getKey() + " : " + en.getValue());
        	}
        }
    }
}