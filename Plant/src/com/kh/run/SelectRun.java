package com.kh.run;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectRun {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = """
				        SELECT
				               PLANT_ID
				             , PLANT_NAME
				             , PLANT_TYPE
				             , PRICE
				             , STORE_DATE
				             , COLOR
				             , BLOOMING_PERIOD
				          FROM
				               TB_PLANT
				         ORDER
				            BY
				               STORE_DATE DESC
				     """;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver 등록 성공");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE",
					                    	   "PSH07",
					                           "PSH071234");
			
			System.out.println("DB서버 접속 성공!");
			
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			System.out.println("Statement 객체 생성!");
			
			rset = stmt.executeQuery(sql);
			System.out.println("SQL문 실행 성공");
			
			while(rset.next()) {
				int plantId = rset.getInt("PLANT_ID");
				String plantName = rset.getString("PLANT_NAME");
				String plantType = rset.getString("PLANT_TYPE");
				int price = rset.getInt("PRICE");
				Date storeDate = rset.getDate("STORE_DATE");
				String color = rset.getString("COLOR");				
				int period = rset.getInt("BLOOMING_PERIOD");
				
				System.out.println("번호 : "+plantId 
						         +", 이름 : "+ plantName 
						         +", 종류 : "+ plantType 
						         +", 가격 : "+ price 
						        +", 입고일 : "+ storeDate 
						         +", 색깔 : "+ color 
						      +", 개화시기 : "+ period);
				
			}
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset !=null && !rset.isClosed()) {
					rset.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				if(stmt !=null && !stmt.isClosed()) {
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