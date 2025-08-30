package kh.com.run;

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
				                PLAYER_NO
				              , PLAYER_NAME
				              , GENDER
				              , POSITION
				              , HEIGHT
				              , WEIGHT
				              , DOMINANT_FOOT
				              , SALARY
				              , CONTRACT_DATE
				              , EXPIRY_DATE
				           FROM
				                TB_FOOTBALL_CLUB
				          ORDER
				             BY
				                CONTRACT_DATE
				     """;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver 등록 성공");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE",
					                           "PSH07",
					                           "PSH071234");
			System.out.println("DB서버 접속 성공");
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			System.out.println("SQL문 실행 성공");
			
			while(rset.next()) {
				int playerNo = rset.getInt("PLAYER_NO");
				String playerName = rset.getString("PLAYER_NAME");
				char gender = rset.getString("GENDER").charAt(0);
				String position = rset.getString("POSITION");
				int height = rset.getInt("HEIGHT");
				int weight = rset.getInt("WEIGHT");
				String dominantFoot = rset.getString("DOMINANT_FOOT");
				int salary = rset.getInt("SALARY");
				Date contractDate = rset.getDate("CONTRACT_DATE");
				Date expiryDate =  rset.getDate("EXPIRY_DATE");
				
				System.out.println("선수 번호 : "+playerNo
						            +", 이름 : "+playerName
						            +", 성별 : "+gender
						           +", 포지션 : "+position
						              +", 키 : "+height
						             +", 체중 : "+weight
						        +", 주로 쓰는발 : "+dominantFoot
						        +", 급여 : "+salary
						         +", 계약시작일 : "+contractDate
						         +", 계약종료일 : "+expiryDate);
			}
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset!=null && !rset.isClosed()) {
					rset.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				if(stmt!=null && !stmt.isClosed()) {
					stmt.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null && !conn.isClosed()) {
					conn.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	
	}

}
