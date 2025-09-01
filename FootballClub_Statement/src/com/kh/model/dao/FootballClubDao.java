package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.kh.model.vo.FootballClub;

public class FootballClubDao {

	
	public int addPlayer(FootballClub player) {
		Connection conn = null;
		Statement stmt = null;
		int result =0;
		
		String sql = "INSERT "
				      +"INTO "
				            +"TB_FOOTBALL_CLUB "
				    +"VALUES"
				           +"("
				            +player.getPlayerNo()
				       +",'"+player.getPlayerName()+"'"
				       +",'"+player.getGender()+"'"
				       +",'"+player.getPosition()+"'"
				        +","+player.getHeight()
				        +","+player.getWeight()
				       +",'"+player.getDominantFoot()+"'"
				        +","+player.getSalary()
				       +",'"+player.getContractDate()+"'"
				       +",'"+player.getExpiryDate()+"'"
				           +")";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE"
					                          ,"PSH07"
					                          ,"PSH071234");
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(sql);
			
			if(result > 0) {
				conn.commit();
			}
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt !=null ) {
					stmt.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn !=null) {
					conn.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
}
