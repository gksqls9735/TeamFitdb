package main;

import controller.CartDAO;
import controller.CartRegisterManager;
import controller.ExerciseRegisterManager;
import controller.UserRegisterManager;
import view.CART_CHOICE;
import view.EXERCISE_CHOICE;
import view.LOGIN_CHOICE;
import view.LoginViewer;
import view.MENU_CHOICE;
import view.MenuViewer;
import view.USER_CHOICE;

public class TeamfitMain {

	public static String id = null;
	public static String pw = null;

	public static void main(String[] args) {
//		login();
		mainMenu();
	}
/*
	public static void login() {
		int choiceNum = 0;
		boolean success = false;
		UserRegisterManager userManager = new UserRegisterManager();
		while (true) {
			LoginViewer.loginMenuView();
			choiceNum = Integer.parseInt(LoginViewer.choice.nextLine());

			switch (choiceNum) {
			case LOGIN_CHOICE.LOGIN:
				success = userManager.userLogin();
				break;
			case LOGIN_CHOICE.SIGNIN:
				success = userManager.userRegister();
				break;
			case LOGIN_CHOICE.EXIT:
				return;
			}
		}
	}
*/
	public static void mainMenu() {
		int choiceNum = 0;

		while (true) {
			try {
				MenuViewer.mainMenuView();
				choiceNum = Integer.parseInt(MenuViewer.choice.nextLine());

				switch (choiceNum) {
				case MENU_CHOICE.USER:
					userMenu();
					break;
				case MENU_CHOICE.EXERCISE:
					exerciseMenu();
					break;
				case MENU_CHOICE.CATR:
					cartMenu();
					break;
				case MENU_CHOICE.EXIT:
					System.out.println("프로그램 종료");
					System.exit(0);
					;
				default:
					System.out.println("해당 메뉴 번호만 입력하세요.");
				}
			} catch (Exception e) {
				System.out.println("\n 입력에 오류가 있습니다. \n프로그램을 다시 시작하세요.");
				return;
			}
		}

	}

	public static void userMenu() {
		int choice;

		UserRegisterManager userManager = new UserRegisterManager();
		MenuViewer.userMenuView();
		choice = Integer.parseInt(MenuViewer.choice.nextLine());

		switch (choice) {
		case USER_CHOICE.LIST:
			System.out.println();
			userManager.userList();
			break;
		case USER_CHOICE.INSERT:
			System.out.println();
			userManager.userRegister();
			break;
		case USER_CHOICE.UPDATE:
			System.out.println();
			userManager.userUpdate();
			break;
		case USER_CHOICE.DELETE:
			System.out.println();
			userManager.userDelete();
			break;
		case USER_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}

	public static void exerciseMenu() {
		int choice;

		ExerciseRegisterManager exerManager = new ExerciseRegisterManager();
		MenuViewer.exerciseMenuView();
		;
		choice = Integer.parseInt(MenuViewer.choice.nextLine());

		switch (choice) {
		case EXERCISE_CHOICE.LIST:
			System.out.println();
			exerManager.exerciseList();
			break;
		case EXERCISE_CHOICE.INSERT:
			System.out.println();
			exerManager.exerciseRegister();
			break;
		case EXERCISE_CHOICE.UPDATE:
			System.out.println();
			exerManager.exerciseUpdate();
			break;
		case EXERCISE_CHOICE.DELETE:
			System.out.println();
			exerManager.exerciseDelete();
			break;
		case EXERCISE_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}

	public static void cartMenu() {
		int choice;

		CartRegisterManager cartManager = new CartRegisterManager();
		MenuViewer.cartMenuView();
		;
		choice = Integer.parseInt(MenuViewer.choice.nextLine());

		switch (choice) {
		case CART_CHOICE.LIST:
			System.out.println();
			cartManager.cartList();
			break;
		case CART_CHOICE.INSERT:
			System.out.println();
			cartManager.cartRegister();
			break;
		case CART_CHOICE.DELETE:
			System.out.println();
			cartManager.cartDelete();
			break;
		case CART_CHOICE.SEARCH:
			System.out.println();
			cartManager.cartSearch();
		case CART_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}

}
