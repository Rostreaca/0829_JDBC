package com.kh.view;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.kh.controller.FootballClubController;
import com.kh.model.vo.FootballClub;

public class FootballClubView {
	
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
		
		while(true) {
		System.out.println("------축구선수 관리 프로그램 ------");
		System.out.println("1. 선수 추가");
		System.out.println("2. 선수 전체 조회");
		System.out.println("3. 선수 등번호로 조회");
		System.out.println("4. 선수 이름 키워드로 조회");
		System.out.println("5. 선수 신체 정보 변경");
		System.out.println("6. 선수 탈퇴");
		System.out.println("9. 프로그램 종료");
		System.out.print("메뉴 번호를 입력해주십시오 > ");
		
		int menuNo = sc.nextInt();
		sc.nextLine();
		switch(menuNo) {
		case 1 : addPlayer(); break;
		case 2 : findAll(); break;
		case 3 : findByNumber();break;
		case 4 : findByKeyword();break;
		case 5 : update();break;
		case 6 : delete();break;
		case 9 : System.out.println("프로그램을 종료합니다"); return;
		default : System.out.println("잘못된 값을 입력하셨습니다.");
		}
		
		}
		
	}
	
	private void addPlayer() {
		/*
		 * System.out.print("(테스트)계약일을 입력해주세요 : "); Date date =
		 * Date.valueOf(sc.nextLine()); System.out.println(date);
		 */
		
		System.out.println("\n선수를 추가합니다");
		System.out.print("등번호를 입력해주세요 : ");
		int playerNo = sc.nextInt();
		sc.nextLine();
		System.out.print("이름을 입력해주세요 : ");
		String playerName = sc.nextLine();
		System.out.print("성별을 입력해주세요 : ");
		String gender = sc.nextLine();
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
		
		int result = fcc.addPlayer(playerNo, playerName, gender, position,height,weight, dominantFoot,salary);
		
		System.out.println();
		
		if(result > 0) {
			System.out.println("회원이 정상적으로 추가되었습니다.");
		} else {
			System.out.println("회원 추가에 실패하였습니다.");
		}
		
	}
	
	private void findAll() {
		
		System.out.println("\n선수 전체 조회");
		
		List<FootballClub> players = fcc.findAll();
		
		if(players.isEmpty()) {
			System.out.println("조회결과가 존재하지 않습니다.");
		} else {
			for(FootballClub player : players) {
				System.out.print("선수 번호 : "+player.getPlayerNo());
				System.out.print(", 선수 이름 : "+player.getPlayerName());
				System.out.print(", 성별 : "+player.getGender());
				System.out.print(", 포지션 : "+player.getPosition());
				System.out.print(", 키 : "+player.getHeight());
				System.out.print(", 체중 : "+player.getWeight());
				System.out.print(", 주로 쓰는 발 : "+player.getDominantFoot());
				System.out.print(", 급여 : "+player.getSalary());
				System.out.print(", 계약일 : "+player.getContractDate());
				System.out.println();
			}
		}
		
	}
	
	private void findByNumber() {
		System.out.println("\n선수 등번호로 조회하기");
		System.out.print("조회할 선수의 등번호를 입력해주십시오. : ");
		int playerNo = sc.nextInt();
		sc.nextLine();
		
		FootballClub player = fcc.findByNumber(playerNo);
		
		if(player != null) {
			System.out.print("선수 번호 : "+player.getPlayerNo());
			System.out.print(", 선수 이름 : "+player.getPlayerName());
			System.out.print(", 성별 : "+player.getGender());
			System.out.print(", 포지션 : "+player.getPosition());
			System.out.print(", 키 : "+player.getHeight());
			System.out.print(", 체중 : "+player.getWeight());
			System.out.print(", 주로 쓰는 발 : "+player.getDominantFoot());
			System.out.print(", 급여 : "+player.getSalary());
			System.out.print(", 계약일 : "+player.getContractDate());
			System.out.println();
		} else {
			System.out.println("조회할 결과가 없습니다.");
		}
		
	}
	
	private void findByKeyword() {
		System.out.println("\n선수 이름 키워드로 선수 조회");
		System.out.print("검색할 키워드를 입력해주세요 > ");
		String keyword = sc.nextLine();
		
		List<FootballClub> players = fcc.findByKeyword(keyword);
		
		if(players.isEmpty()) {
			System.out.println("조회 결과가 없습니다.");
		} else {
			for(FootballClub player : players) {
				System.out.print("선수 번호 : "+player.getPlayerNo());
				System.out.print(", 선수 이름 : "+player.getPlayerName());
				System.out.print(", 성별 : "+player.getGender());
				System.out.print(", 포지션 : "+player.getPosition());
				System.out.print(", 키 : "+player.getHeight());
				System.out.print(", 체중 : "+player.getWeight());
				System.out.print(", 주로 쓰는 발 : "+player.getDominantFoot());
				System.out.print(", 급여 : "+player.getSalary());
				System.out.print(", 계약일 : "+player.getContractDate());
				System.out.println();
			}
		}
		
	}
	
	private void update() {
		System.out.println("\n 선수 신체 정보 변경");
		System.out.print("정보를 변경할 선수 번호를 입력해주세요 : ");
		int playerNo = sc.nextInt();
		sc.nextLine();
		System.out.print("변경할 키 정보를 입력해주십시오 :");
		int height = sc.nextInt();
		sc.nextLine();
		System.out.print("변경할 체중 정보를 입력해주십시오 : ");
		int weight = sc.nextInt();
		
		int result = fcc.update(playerNo,height,weight);
		
		if(result >0) {
			System.out.println("변경에 성공하였습니다!");
		} else {
			System.out.println("변경에 실패하였습니다.");
		}
		
	}
	
	private void delete() {
		System.out.println("\n 탈퇴한 선수의 정보를 지웁니다.");
		System.out.print("탈퇴한 선수의 등번호를 입력해주십시오 : ");
		int playerNo = sc.nextInt();
		sc.nextLine();
		System.out.print("탈퇴한 선수의 이름을 입력해주십시오 : ");
		String playerName = sc.nextLine();
		
		int result = fcc.delete(playerNo,playerName);
		
		if(result > 0) {
			System.out.println(playerName+" 선수가 탈퇴하였습니다.");
		} else {
			System.out.println("실패하였습니다.");
		}
		
	}
	
}
