package z.practice.oop.ex3;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		
		TV myTV = new TV("삼성", 2020, 65, 100000);
		myTV.show();
		
		TV myTV2 = new TV("LG", 2024, 85, 500000);
		myTV2.show();
		
		Human one = new Human("최지원", 1000000);
		one.buy(myTV);

	}

}
