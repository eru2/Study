package z.practice.Exception.ex1;

import java.util.Scanner;

public class NumberMenu {
	NumberController nc = new NumberController();

	public void menu() {
		try(Scanner sc = new Scanner(System.in);){
			
			System.out.print("num1 : ");
			int num1 = sc.nextInt();
			System.out.print("num2 : ");
			int num2 = sc.nextInt();
			boolean check = nc.checkDouble(num1, num2);
			
			System.out.printf("%d은(는) %d의 배수인가 ? %b \n", num1, num2, check);
		} catch (NumRangeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
	}

	
	
}
