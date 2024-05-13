package controller;

import java.util.Scanner;

import model.CartVO;
import model.ExerciseVO;

public class CartRegisterManager {

	public Scanner sc = new Scanner(System.in);

	public void cartList() {
		boolean success = false;
		CartDAO cd = new CartDAO();
		UserDAO ud = new UserDAO();

		System.out.println("강의 신처 리스트");

		String u_id = null;
		String u_pw = null;

		do {
			System.out.print("아이디: ");
			u_id = sc.nextLine();
			System.out.print("비밀번호: ");
			u_pw = sc.nextLine();

			success = ud.getUserLogin(u_id, u_pw);
			if (!success) {
				System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
				System.out.println();
			}
		} while (!success);

		System.out.println();
		System.out.println("강의 신청 리스트");
		cd.getCartTotal(u_id);
		System.out.println();
	}

	public void cartRegister() {
		CartDAO cd = new CartDAO();
		CartVO cv = new CartVO();

		ExerciseDAO ed = new ExerciseDAO();
		ExerciseVO ev = new ExerciseVO();

		UserDAO ud = new UserDAO();

		String u_id = null;
		String u_pw = null;
		int e_no = 0;
		String c_ps = null;
		boolean success = false;

		System.out.println("신청 가능한 강의 리스트");
		ed.getExerciseTotalList();
		System.out.println();
		System.out.println("강의 신청을 위한 정보 입력");

		do {
			System.out.print("아이디: ");
			u_id = sc.nextLine();
			System.out.print("비밀번호: ");
			u_pw = sc.nextLine();

			success = ud.getUserLogin(u_id, u_pw);
			if (!success) {
				System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
				System.out.println();
			}
		} while (!success);

		System.out.println("아이디: " + u_id);
		ed.getExerciseTotalList();
		System.out.print("강의 일련번호: ");
		e_no = Integer.parseInt(sc.nextLine());
		System.out.print("결제 여부: ");
		c_ps = sc.nextLine().toUpperCase();
		
		cv.setU_id(u_id);
		cv.setE_no(e_no);
		cv.setC_payment_status(c_ps);
		
		cd.setCartRegister(cv);
		System.out.println();
		System.out.println("강의 신청한 리스트");
		cd.getCartTotal(u_id);
		System.out.println();
	}

	public void cartDelete() {
		CartDAO cd = new CartDAO();
		UserDAO ud = new UserDAO();

		int c_no = 0;
		String u_id = null;
		String u_pw = null;
		boolean success = false;

		System.out.println("강의 신청 취소를 위한 정보 입력");
		do {
			System.out.print("아이디: ");
			u_id = sc.nextLine();
			System.out.print("비밀번호: ");
			u_pw = sc.nextLine();

			success = ud.getUserLogin(u_id, u_pw);
			if (!success) {
				System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
				System.out.println();
			}
		} while (!success);

		System.out.println();
		cd.getCartTotal(u_id);
		System.out.println("취소할 강의 신청 일련번호 입력: ");
		System.out.print("일련번호: ");
		c_no = Integer.parseInt(sc.nextLine());
		cd.setCartDelete(c_no);
		System.out.println();
		System.out.println("강의 신청 취소 후 리스트");
		cd.getCartTotal(u_id);
		System.out.println();
	}
	
	public void cartSearch() {
		//제대로 검색이 되지 않음
		CartDAO cd = new CartDAO();
		ExerciseDAO ed = new ExerciseDAO();
		System.out.println("검색할 운동 종목 입력");
		System.out.print("운동종목: ");
		String e_name = sc.nextLine();
		ed.getExerciseSearch(e_name);
	}
}
