package controller;

import java.util.Scanner;

import model.CartVO;
import model.ExerciseVO;

public class CartRegisterManager {

	public Scanner sc = new Scanner(System.in);

	public void cartList(String id) {
		boolean success = false;
		CartDAO cd = new CartDAO();
		UserDAO ud = new UserDAO();

		if (cd.checkCart(id)) {
			System.out.println("수강 내역이 존재하지 않습니다.");
			System.out.println("이전 페이지로 돌아갑니다.");
			return;
		}
		
		System.out.println();
		System.out.println("강의 신청 리스트");
		cd.getCartTotal(id);
		System.out.println();
	}

	public void cartRegister(String id) {
		CartDAO cd = new CartDAO();
		CartVO cv = new CartVO();

		ExerciseDAO ed = new ExerciseDAO();

		int e_no = 0;
		String c_ps = null;
		boolean success = false;

		System.out.println("신청 가능한 강의 리스트");
		ed.getExerciseTotalList();
		System.out.println();

		System.out.println("아이디: " + id);
		//do-while문을 추가해서 같은 강의 중복 신청 막기
		System.out.print("강의 일련번호: ");
		e_no = Integer.parseInt(sc.nextLine());
		do {
			System.out.print("결제 여부: ");
			c_ps = sc.nextLine().toUpperCase();

			if (c_ps.equalsIgnoreCase("Y") || c_ps.equalsIgnoreCase("N")) {
				success = true;
			} else {
				System.out.println("Y 혹은 N을 입력해주세요.");
			}		
		} while (!success);
		
		
		cv.setU_id(id);
		cv.setE_no(e_no);
		cv.setC_payment_status(c_ps);
		
		cd.setCartRegister(cv);
		System.out.println();
		System.out.println( id +"님의 수강 신청 목록");
		cd.getCartTotal(id);
		System.out.println();
	}

	public void cartDelete(String id) {
		CartDAO cd = new CartDAO();

		if (cd.checkCart(id)) {
			System.out.println("수강 내역이 존재하지 않습니다.");
			System.out.println("이전 페이지로 돌아갑니다.");
			return;
		}
		
		System.out.println();
		cd.getCartTotal(id);
		System.out.println("취소할 강의 신청 일련번호 입력: ");
		System.out.print("일련번호: ");
		int c_no = Integer.parseInt(sc.nextLine());
		cd.setCartDelete(c_no);
		System.out.println();
		System.out.println( id +"님의 수강 신청 목록");
		cd.getCartTotal(id);
		System.out.println();
	}
	
	public void allCartDelete(String id) {
		CartDAO cd = new CartDAO();
		boolean success = false;
		String cancle = null;
		
		if (cd.checkCart(id)) {
			System.out.println("수강 내역이 존재하지 않습니다.");
			System.out.println("이전 페이지로 돌아갑니다.");
			return;
		}
		
		System.out.println( id +"님의 수강 신청 목록");
		cd.getCartTotal(id);
		System.out.println();
		
		do {
			System.out.print("강의를 전체 취소하시겠습니까?(Y/N):  ");
			cancle = sc.nextLine();
			if (cancle.equalsIgnoreCase("Y")) {
				cd.allCartDelete(id);
				success = true;
			} else if(cancle.equalsIgnoreCase("N")) {
				System.out.println("강의 취소를 진행하지 않고 이전 페이지로 돌아갑니다.");
				return;
			} else {
				System.out.println("Y 혹은 N을 선택해주세요.");
			}			
		} while (!success);
	}
	
	public void cartSearch() {
		CartDAO cd = new CartDAO();
		ExerciseDAO ed = new ExerciseDAO();
		System.out.println("검색할 운동 종목 입력");
		System.out.print("운동종목: ");
		String e_name = sc.nextLine();
		ed.getExerciseSearch(e_name);
	}
}
