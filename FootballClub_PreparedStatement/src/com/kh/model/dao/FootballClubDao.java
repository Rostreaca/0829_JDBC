package com.kh.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.model.dto.FootballClubDTO;
import com.kh.model.vo.FootballClub;

public class FootballClubDao {

	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@115.90.212.20:10000:XE";
	private final String USERNAME = "PSH07";
	private final String PASSWORD = "PSH071234";
	
	public int addPlayer(FootballClub player) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result =0;
		
		String sql = """
				         INSERT
				           INTO
				                TB_FOOTBALL_CLUB
				         VALUES
				                (
				                ?
				              , ?
				              , ?
				              , ?
				              , ?
				              , ?
				              , ?
				              , ?
				              , SYSDATE
				                )
				     """;
		
		try {
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, player.getPlayerNo());
			pstmt.setString(2, player.getPlayerName());
			pstmt.setString(3, player.getGender());
			pstmt.setString(4, player.getPosition());
			pstmt.setInt(5, player.getHeight());
			pstmt.setInt(6, player.getWeight());
			pstmt.setString(7, player.getDominantFoot());
			pstmt.setInt(8, player.getSalary());
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			}
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt !=null ) {
					pstmt.close();
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
		
		Connection conn = null;
		PreparedStatement pstmt = null;
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
				          ORDER 
				             BY 
				                CONTRACT_DATE DESC
				     """;
		
		try {
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				players.add(new FootballClub(rset.getInt("PLAYER_NO")
						                    ,rset.getString("PLAYER_NAME")
						                    ,rset.getString("GENDER")
						                    ,rset.getString("POSITION")
						                    ,rset.getInt("HEIGHT")
						                    ,rset.getInt("WEIGHT")
						                    ,rset.getString("DOMINANT_FOOT")
						                    ,rset.getInt("SALARY")
						                    ,rset.getDate("CONTRACT_DATE")));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset != null) {
					rset.close();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstmt != null) {
					pstmt.close();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return players;
	}
	
	public FootballClub findByNumber(int playerNo) {
		
		FootballClub player = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
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
				                PLAYER_NO = ?
				     """;
		
		try {
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, playerNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				player = new FootballClub(rset.getInt("PLAYER_NO")
						                 ,rset.getString("PLAYER_NAME")
						                 ,rset.getString("GENDER")
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
				if(pstmt !=null) {
					pstmt.close();
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
		
		Connection conn =null;
		PreparedStatement pstmt = null;
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
				               PLAYER_NAME LIKE '%'||?||'%'
				     """;
		
		try {
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				players.add(new FootballClub(rset.getInt("PLAYER_NO")
						                    ,rset.getString("PLAYER_NAME")
						                    ,rset.getString("GENDER")
						                    ,rset.getString("POSITION")
						                    ,rset.getInt("HEIGHT")
						                    ,rset.getInt("WEIGHT")
						                    ,rset.getString("DOMINANT_FOOT")
						                    ,rset.getInt("SALARY")
						                    ,rset.getDate("CONTRACT_DATE")));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset!=null) {
					rset.close();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstmt!=null) {
					pstmt.close();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn !=null) {
					conn.close();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		return players;
	}
	
	public int update(FootballClubDTO fcd) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = """
				         UPDATE
				                TB_FOOTBALL_CLUB
				            SET
				                HEIGHT = ?
				              , WEIGHT = ?
				          WHERE
				                PLAYER_NO = ?
				     """;
		
		try {
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fcd.getHeight());
			pstmt.setInt(2, fcd.getWeight());
			pstmt.setInt(3, fcd.getPlayerNo());
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) {
					pstmt.close();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null) {
					conn.close();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		return result;
	}
	
	public int delete(FootballClub player) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = """
				         DELETE
				           FROM
				                TB_FOOTBALL_CLUB
				          WHERE
				                PLAYER_NO = ?
				            AND
				                PLAYER_NAME = ?
				     """;
		
		try {
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, player.getPlayerNo());
			pstmt.setString(2, player.getPlayerName());
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(pstmt!=null) {
					pstmt.close();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
}
