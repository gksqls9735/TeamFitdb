package view;

import java.util.Scanner;

public class MenuViewer {
	public static Scanner choice = new Scanner(System.in);

	public static void mainMenuView() {
		System.out.println();
		System.out.println("Teamfit 강의 신청 프로그램");
		System.out.println("해당 번호를 입력하세요.");
		System.out.println("1. 유저 정보 목록/입력/수정/삭제");
		System.out.println("2. 강의 정보 목록/입력/수정/삭제");
		System.out.println("3. 수강 신청 목록/신청/취소");
		System.out.println("4. 프로그램 종료");
		System.out.print("번호 선택: ");
	}

	public static void userMenuView() {
		System.out.println();
		System.out.println("1. 유저 정보 목록");
		System.out.println("2. 유저 정보 입력");
		System.out.println("3. 유저 정보 수정");
		System.out.println("4. 유저 정보 삭제");
		System.out.println("5. 메인 메뉴");			
		System.out.print("번호 선택: ");			
	}
	public static void exerciseMenuView() {
		System.out.println();
		System.out.println("1. 강의 정보 목록");
		System.out.println("2. 강의 정보 입력");
		System.out.println("3. 강의 정보 수정");
		System.out.println("4. 강의 정보 삭제");
		System.out.println("5. 메인 메뉴");			
		System.out.print("번호 선택: ");			
	}



	public static void cartMenuView() {
		System.out.println();
		System.out.println("1. 수강 신청 목록");
		System.out.println("2. 수강 신청");
		System.out.println("3. 수강 취소");
		System.out.println("4. 메인 메뉴");			
		System.out.print("번호 선택: ");	
	}
}
