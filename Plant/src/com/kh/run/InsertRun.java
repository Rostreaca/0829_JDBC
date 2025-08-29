package com.kh.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("식물 번호를 입력해주세요 : ");
		int plantId = sc.nextInt();
		sc.nextLine();
		System.out.print("식물 이름을 입력해주세요 : ");
		String plantName = sc.nextLine();
		System.out.print("식물 종류를 입력해주세요 : ");
		String plantType = sc.nextLine();
		
		String sql = "INSERT"
				    +"INTO"
				            +"TB_PLANT"
				    +"VALUES"
				            +"("
				            +plantId
				      +", '"+plantName+"'"
				      +", '"+plantType+"'"
				            +")";
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver 등록 성공");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE",
					                    "PSH07",
					                    "PSH071234");
			System.out.println("DB서버 접속 성공");
			conn.setAutoCommit(false);
			
			
			stmt = conn.createStatement();
			System.out.println("Statement 객체 생성");
			
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
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn !=null && !conn.isClosed()) {
					conn.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

}