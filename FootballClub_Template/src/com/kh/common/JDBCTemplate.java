package com.kh.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {

	// 드라이버, 커넥션, 트랜잭션, 자원반납
	
	public static void registDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE"
					                   					 ,"PSH07"
					                   					 ,"PSH071234");
			conn.setAutoCommit(false);
			
			return conn;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn != null) {
				conn.commit();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection conn) {
		try {
			if(conn !=null) {
				conn.rollback();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		
		try {
			if(conn!=null) {
				conn.close();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void close(Statement stmt) {
		try {
			if(stmt !=null) {
				stmt.close();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void close(ResultSet rset) {
		try {
			if(rset !=null) {
				rset.close();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
