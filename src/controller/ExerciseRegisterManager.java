package controller;

import java.util.Scanner;

import model.ExerciseVO;

public class ExerciseRegisterManager {
	
	public static Scanner sc = new Scanner(System.in);

	public void exerciseList() {
		ExerciseDAO ed = new ExerciseDAO();
		System.out.println("강의 전체 리스트");
		ed.getExerciseTotalList();
		System.out.println();
	}

	public void exerciseRegister() {
		ExerciseDAO ed = new ExerciseDAO();
		ExerciseVO ev = new ExerciseVO();
		
		System.out.println("강의 전체 리스트");
		ed.getExerciseTotalList();
		System.out.println();
		
		System.out.println("강의 정보 입력");
		System.out.print("운동종목: ");
		String e_name = sc.nextLine();
		System.out.print("가격: ");
		int price = Integer.parseInt(sc.nextLine());
		System.out.print("강의날짜: ");
		String e_date = sc.nextLine();
		System.out.print("강의시간: ");
		String e_time = sc.nextLine();
		System.out.print("강의장소: ");
		String e_addr = sc.nextLine();
		
		ev.setE_name(e_name);
		ev.setE_price(price);
		ev.setE_date(e_date);
		ev.setE_time(e_time);
		ev.setE_addr(e_addr);
		
		ed.setExerciseRegister(ev);
		System.out.println();
		System.out.println("강의 전체 리스트");
		ed.getExerciseTotalList();
		System.out.println();	
	}
	public void exerciseUpdate() {
		ExerciseDAO ed = new ExerciseDAO();
		ExerciseVO ev = new ExerciseVO();
		
		System.out.println("강의 전체 리스트");
		ed.getExerciseTotalList();
		System.out.println();
		System.out.println("수정할 강의의 일련번호 입력: ");
		System.out.print("일련번호: ");
		int e_no = Integer.parseInt(sc.nextLine());
		
		System.out.println();
		System.out.println("수정할 정보 입력");
		System.out.print("가격: ");
		int price = Integer.parseInt(sc.nextLine());
		System.out.print("강의날짜: ");
		String e_date = sc.nextLine();
		System.out.print("강의시간: ");
		String e_time = sc.nextLine();
		System.out.print("강의장소: ");
		String e_addr = sc.nextLine();
		
		ev.setE_no(e_no);
		ev.setE_price(price);
		ev.setE_date(e_date);
		ev.setE_time(e_time);
		ev.setE_addr(e_addr);
		
		ed.setExerciseRegister(ev);
		System.out.println();
		System.out.println("강의 전체 리스트");
		ed.getExerciseTotalList();
		System.out.println();	
	}
	
	public void exerciseDelete() {
		ExerciseDAO ed = new ExerciseDAO();
		
		System.out.println("유저 전체 리스트");
		System.out.print("관리자 아이디: ");
		String id = sc.nextLine();
		System.out.print("관리자 비밀번호: ");
		String pw = sc.nextLine();

		if (id.equals("admin") && pw.equals("admin1234")) {
			System.out.println("강의 전체 리스트");
			ed.getExerciseTotalList();
			System.out.println();
			
			System.out.println("삭제할 강의의 일련번호 입력");
			System.out.println("일련번호: ");
			int e_no = Integer.parseInt(sc.nextLine());
			
			System.out.println();
			System.out.println("강의 전체 리스트보기");
			ed.getExerciseTotalList();
			System.out.println();
		} else {
			System.out.println("관리자 아이디 혹은 비밀번호가 틀렸습니다.");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
