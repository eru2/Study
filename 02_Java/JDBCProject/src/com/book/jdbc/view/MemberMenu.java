package com.book.jdbc.view;

import java.util.Scanner;

import com.book.jdbc.controller.MemberController;


public class MemberMenu {

	
	private Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	
	public void firstMenu() {
		while(true) {
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("9. 종료");
			System.out.print("메뉴 입력 : ");
			int log = sc.nextInt();
			sc.nextLine();
			
			switch(log) {
			case 1:
				this.logIn();
				break;
			case 2:
				this.insertMember();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
				default:
					System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void logIn() {
		System.out.println("----- 로그인 페이지 -----");
		System.out.print("\n아이디 : ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String memberPwd = sc.nextLine();
		
		mc.logIn(memberId, memberPwd);
		
	}
	public void insertMember() {
		System.out.println("----- 회원가입 페이지 -----");
		System.out.print("\n아이디 : ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String memberPwd = sc.nextLine();
		System.out.print("이름 : ");
		String memberName = sc.nextLine();
		System.out.print("성별(M/F) : ");
		String gender = sc.nextLine();
		System.out.print("주소 : ");
		String address = sc.nextLine();
		System.out.print("전화번호 : ");
		String phone = sc.nextLine();
		
		mc.insertMember(memberId, memberPwd, memberName, gender, phone, address);
	}
	
	public void userPage() {
		
	}
	
	
	
	
	//------------------------------------- 응답 화면 ---------------------------------
	//로그인 실패 -> 아이디나 비밀번호 중 하나만 틀릴경우 -> 로그인화면으로 다시 이동
	public void failLogIn(String message) {
		System.out.println(message);
		this.logIn();
	}
	
	//로그인실패(아이디와 비밀번호 둘다 틀릴경우) -> 처음화면으로 이동
	public void NonLog(String message) {
		System.out.println(message);
		this.firstMenu();
	}
	
}
