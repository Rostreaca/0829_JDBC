package com.kh.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
				         +", SYSDATE"
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
	
	public List<FootballClub> findAll(){
		
		List<FootballClub> players = new ArrayList();
		
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
				          FROM
				               TB_FOOTBALL_CLUB
				         ORDER
				            BY
				               CONTRACT_DATE DESC
				     """;
		
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE","PSH07","PSH071234");
			    Statement stmt = conn.createStatement();
			    ResultSet rset = stmt.executeQuery(sql)){
				
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
					
					players.add(new FootballClub(playerNo,playerName,gender,position,height,weight,dominantFoot,salary,contractDate));
					
				}
				
			}
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return players;
	}
	
	public FootballClub findByNumber(int playerNo) {
		
		FootballClub player = null;
		
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
				           FROM
				                TB_FOOTBALL_CLUB
				          WHERE
				                PLAYER_NO = 
				     """;
		sql += playerNo + " \n";
		sql += "ORDER "
		         +"BY "
				     +"CONTRACT_DATE DESC";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE","PSH07","PSH071234");
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				player = new FootballClub(rset.getInt("PLAYER_NO")
						                 ,rset.getString("PLAYER_NAME")
						                 ,rset.getString("GENDER").charAt(0)
						                 ,rset.getString("POSITION")
						                 ,rset.getInt("HEIGHT")
						                 ,rset.getInt("WEIGHT")
						                 ,rset.getString("DOMINANT_FOOT")
						                 ,rset.getInt("SALARY")
						                 ,rset.getDate("CONTRACT_DATE"));
			}
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset!=null) {
					rset.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				if(stmt !=null) {
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
		
		
		
		return player;
	}
	
	public List<FootballClub> findByKeyword(String keyword){
		
		List<FootballClub> players = new ArrayList();
		
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
				           FROM
				                TB_FOOTBALL_CLUB
				          WHERE
				                PLAYER_NAME LIKE
				     """
				    +" '%"+keyword+"%' "
				        +"ORDER "
				        +   "BY "
				               +"CONTRACT_DATE DESC";
		
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE","PSH07","PSH071234");
			    Statement stmt = conn.createStatement();
			    ResultSet rset = stmt.executeQuery(sql)){
				
				while(rset.next()) {
					players.add(new FootballClub(rset.getInt("PLAYER_NO")
			                                    ,rset.getString("PLAYER_NAME")
			                                    ,rset.getString("GENDER").charAt(0)
			                                    ,rset.getString("POSITION")
			                                    ,rset.getInt("HEIGHT")
			                                    ,rset.getInt("WEIGHT")
			                                    ,rset.getString("DOMINANT_FOOT")
			                                    ,rset.getInt("SALARY")
			                                    ,rset.getDate("CONTRACT_DATE")));
				}
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return players;
	}
	
}
