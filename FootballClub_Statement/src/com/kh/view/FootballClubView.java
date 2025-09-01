package com.kh.view;

import java.sql.Date;
import java.util.Scanner;

import com.kh.controller.FootballClubController;

public class FootballClubView {
	
	private FootballClubController fcc = new FootballClubController();
	private Scanner sc = new Scanner(System.in);

	/* 나만의 테이블에 INSERT 
	 * 전체 조회
	 * 유니크제약조건 걸려있는 컬럼으로 조회
	 * LIKE키워드 써서 조회
	 * */
	
	
	/**
	 * 프로그램 구동 시 메인메뉴를 출력해주는 메소드
	 */
	public void mainMenu() {
		System.out.println("------축구선수 관리 프로그램 ------");
		System.out.println("1. 선수 추가");
		System.out.println("2. 선수 전체 조회");
		System.out.println("3. 선수 등번호로 조회");
		System.out.println("4. 선수 이름 키워드로 조회");
		System.out.println("9. 프로그램 종료");
		System.out.print("메뉴 번호를 입력해주십시오 > ");
		
		int menuNo = sc.nextInt();
		sc.nextLine();
		switch(menuNo) {
		case 1 : addPlayer(); break;
		case 2 : break;
		case 3 : break;
		case 4 : break;
		case 9 : System.out.println("프로그램을 종료합니다"); return;
		default : System.out.println("잘못된 값을 입력하셨습니다.");
		}
		
		
	}
	
	private void addPlayer() {
		System.out.println("\n선수를 추가합니다");
		System.out.print("등번호를 입력해주세요 : ");
		int playerNo = sc.nextInt();
		sc.nextLine();
		System.out.print("이름을 입력해주세요 : ");
		String playerName = sc.nextLine();
		System.out.print("성별을 입력해주세요 : ");
		char gender = sc.nextLine().charAt(0);
		System.out.print("포지션을 입력해주세요 : ");
		String position = sc.nextLine();
		System.out.print("키를 입력해주세요 : ");
		int height = sc.nextInt();
		sc.nextLine();
		System.out.print("체중을 입력해주세요 : ");
		int weight = sc.nextInt();
		sc.nextLine();
		System.out.print("주로 사용하는 발을 입력해주세요 : ");
		String dominantFoot = sc.nextLine();
		System.out.print("급여를 입력해주세요 : ");
		int salary = sc.nextInt();
		sc.nextLine();
		System.out.print("계약 시작일을 입력해주세요 : ");
		Date contractDate = sc.nextLine();
		System.out.print("계약 종료일을 입력해주세요 : ");
		Date expiryDate = sc.nextLine();
		
		fcc.addPlayer(playerNo, playerName, gender, position,height,weight, dominantFoot,salary, contractDate, expiryDate);
		
		
	}
	
	
	
}
