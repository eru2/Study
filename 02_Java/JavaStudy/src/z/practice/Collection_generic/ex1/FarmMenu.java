package z.practice.Collection_generic.ex1;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class FarmMenu {

	private Scanner sc = new Scanner(System.in);
	FarmController fc = new FarmController();

	public void mainMenu() {

		System.out.println("========== KH 마트 ==========");
		while (true) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 직원메뉴");
			System.out.println("2. 손님 메뉴");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : ");
			int menuNum = sc.nextInt();
			sc.nextLine();

			switch (menuNum) {
			case 1:
				adminMenu();
				break;
			case 2:
				customerMenu();
				break;
			case 9:
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
			}
		}
	}

	public void adminMenu() {
		while (true) {
			System.out.println("******* 직원 메뉴 *******");
			System.out.println("1. 새 농산물 추가");
			System.out.println("2. 종류 삭제");
			System.out.println("3. 수량 수정");
			System.out.println("4. 농산물 목록");
			System.out.println("9. 메인으로 돌아가기");
			System.out.print("메뉴 번호 선택 : ");
			int menuNum = sc.nextInt();
			sc.nextLine();

			switch (menuNum) {
			case 1:
				addNewKind();
				break;
			case 2:
				removeKind();
				break;
			case 3:
				changeAmount();
				break;
			case 4:
				printFarm();
				break;
			case 9:
				return;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
			}
		}
	}

	public void customerMenu() {
		System.out.println("현재 KH마트 농산물 수량");
		printFarm();
		System.out.println("\n******* 고객 메뉴 *******");
		System.out.println("1. 농산물 사기 ");
		System.out.println("2. 농산물 빼기 ");
		System.out.println("3. 구입한 농산물 보기 ");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 선택 : ");
		int menuNum = sc.nextInt();
		sc.nextLine();

		switch (menuNum) {
		case 1:
			buyFarm();
			break;
		case 2:
			removeFarm();
			break;
		case 3:
			printBuyFarm();
			break;
		case 9:
			return;
		default:
			System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
		}

	}

	public void addNewKind() {

		System.out.println("1. 과일 / 2. 채소 / 3. 견과");
		System.out.print("추가할 종류 번호 : ");
		int type = sc.nextInt();
		sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("수량 : ");
		int num = sc.nextInt();

		Farm farm = null;
		switch (type) {
		case 1:
			farm = new Fruit("과일", name);
			break;
		case 2:
			farm = new Vegetable("야채", name);
			break;
		case 3:
			farm = new Nut("견과", name);
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
		}
		boolean result = fc.addNewKind(farm, num);
		if (result) {
			System.out.println("새 농산물이 추가되었습니다.");
		} else {
			System.out.println("새 농산물 추가에 실패하였습니다. 다시 입력해주세요.");
		}
	}

	public void removeKind() {

		System.out.println("1. 과일 / 2. 채소 / 3. 견과");
		System.out.print("삭제할 종류 번호 : ");
		int type = sc.nextInt();
		sc.nextLine();

		System.out.print("이름 : ");
		String name = sc.next();
		sc.nextLine();

		Farm farm = null;
		switch (type) {
		case 1:
			farm = new Fruit("과일", name);
			break;
		case 2:
			farm = new Vegetable("야채", name);
			break;
		case 3:
			farm = new Nut("견과", name);
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
		}
		boolean result = fc.removeKind(farm);
		if (result) {
			System.out.println("농산물 삭제에 성공하였습니다.");
		} else {
			System.out.println("농산물 삭제에 실패하였습니다. 다시 입력해주세요.");
		}

	}

	public void changeAmount() {
		System.out.println("1. 과일 / 2. 채소 / 3. 견과");
		System.out.print("수정할 종류 번호 : ");
		int type = sc.nextInt();
		sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("수량 : ");
		int num = sc.nextInt();

		Farm farm = null;
		switch (type) {
		case 1:
			farm = new Fruit("과일", name);
			break;
		case 2:
			farm = new Vegetable("야채", name);
			break;
		case 3:
			farm = new Nut("견과", name);
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
		}
		boolean result = fc.changeAmount(farm, num);
		if (result) {
			System.out.println("농산물 수량이 수정되었습니다.");

		} else {
			System.out.println("농산물 수량 수정에 실패하였습니다. 다시 입력해주세요.");
		}

	}

	public void printFarm() {
		for (Farm mapKey : fc.printFarm().keySet()) {
			int amount = fc.printFarm().get(mapKey);
			
			System.out.println(mapKey.getKind() + " : " + mapKey +"(" + amount + "개)");
		}

	}

	public void buyFarm() {
		System.out.println("1. 과일 / 2. 채소 / 3. 견과");
		System.out.print("구매할 종류 번호 : ");
		int type = sc.nextInt();
		sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.next();
		
		Farm farm = null;
		switch (type) {
		case 1:
			farm = new Fruit("과일", name);
			break;
		case 2:
			farm = new Vegetable("야채", name);
			break;
		case 3:
			farm = new Nut("견과", name);
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
		}
		boolean result = fc.buyFarm(farm);
		if (result) {
			System.out.println("구매에 성공하였습니다.");

		} else {
			System.out.println("마트에 없는 물건이거나 수량이 없습니다. 다시 입력해주세요.");
		}

	}

	public void removeFarm() {

		System.out.println("1. 과일 / 2. 채소 / 3. 견과");
		System.out.print("구매 취소할 종류 번호 : ");
		int type = sc.nextInt();
		sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.next();
		Farm farm = null;
		switch (type) {
		case 1:
			farm = new Fruit("과일", name);
			break;
		case 2:
			farm = new Vegetable("야채", name);
			break;
		case 3:
			farm = new Nut("견과", name);
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
		}
		boolean result = fc.removeFarm(farm);
		if (result) {
			System.out.println("구매 취소에 성공하였습니다");

		} else {
			System.out.println("구매 목록에 존재하지 않습니다. 다시 입력해주세요.");
		}

	}

	public void printBuyFarm() {
		Iterator<Farm> iterator = fc.printBuyFarm().iterator();
		while (iterator.hasNext()) {
			Farm farm = iterator.next();
			System.out.println(farm.getKind() + " : " + farm);
		}
	}

}
