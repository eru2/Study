package z.practice.Exception.ex2;

import java.util.Scanner;

public class CharacterMenu {
	
	CharacterController cc = new CharacterController();
	
	public void menu() {
		try(Scanner sc = new Scanner(System.in);){
			System.out.print("문자열 : ");
			String str = sc.nextLine();
			
			int count = cc.countAlpha(str);
			
			System.out.printf("'%s'에 포함된 영문자 개수 : %d" , str, count);
		} catch(CharCheckException e) {
			e.getMessage();
			e.printStackTrace();
		}
		System.out.println("종료됩니다.");
	}

}
