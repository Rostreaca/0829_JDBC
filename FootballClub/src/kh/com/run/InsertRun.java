package kh.com.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertRun {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("등번호를 입력해 주십시오 : ");
		int playerNo = sc.nextInt();
		sc.nextLine();
		System.out.print("이름을 입력해 주십시오 : ");
		String playerName = sc.nextLine();
		System.out.print("성별을 입력해 주십시오 : ");
		char gender = sc.nextLine().charAt(0);
		System.out.print("포지션을 입력해 주십시오 : ");
		String position = sc.nextLine();
		System.out.print("키를 입력해 주십시오 : ");
		int height = sc.nextInt();
		sc.nextLine();
		System.out.print("체중을 입력해 주십시오 : ");
		int weight = sc.nextInt();
		sc.nextLine();
		System.out.print("주로 사용하는 발을 입력해 주십시오 : ");
		String dominantFoot = sc.nextLine();
		System.out.print("급여를 입력해 주십시오 : ");
		int salary = sc.nextInt();
		sc.nextLine();
		System.out.print("계약 시작일을 입력해 주십시오 : ");
		String contractDate = sc.nextLine();
		System.out.print("계약 종료일을 입력해 주십시오 : ");
		String expiryDate = sc.nextLine();
		
		String sql = "INSERT "
				    +"INTO "
				            +"TB_FOOTBALL_CLUB "
				    +"VALUES "
				           +"("
				            +playerNo
				      +", '"+playerName+"'"
				      +", '"+gender+"'"
				      +", '"+position+"'"
				       +", "+height
				       +", "+weight
				      +", '"+dominantFoot+"'"
				       +", "+salary
				      +", '"+contractDate+"'"
				      +", '"+expiryDate+"'"
				           +")";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver 등록 성공");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE", "PSH07", "PSH071234");
			System.out.println("DB서버 접속 성공");
			
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(sql);
			System.out.println("SQL문 실행 성공");
			
			if(result > 0) {
				conn.commit();
			}
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null && stmt.isClosed()) {
					stmt.close();
					}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn !=null && conn.isClosed()) {
					conn.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
