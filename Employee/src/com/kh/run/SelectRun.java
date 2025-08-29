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
				        EMP_ID
				      , EMP_NAME
				      , EMP_NO
				      , EMAIL
				      , PHONE
				      , DEPT_CODE
				      , JOB_CODE
				      , SAL_LEVEL
				      , SALARY
				      , BONUS
				      , MANAGER_ID
				      , HIRE_DATE
				      , ENT_DATE
				      , ENT_YN
				   FROM
				        EMPLOYEE
				  ORDER
				     BY
				        HIRE_DATE DESC
				     """;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver 등록 성공");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE",
					                           "PSH07",
					                           "PSH071234");
			System.out.println("DB 서버 접속 성공");
			
			stmt = conn.createStatement();
			System.out.println("Statement 객체 생성");
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				int empId = rset.getInt("EMP_ID");
				String empName = rset.getString("EMP_NAME");
				String empNo = rset.getString("EMP_NO");
				String email = rset.getString("EMAIL");
				String phone = rset.getString("PHONE");
				String deptCode = rset.getString("DEPT_CODE");
				String jobCode = rset.getString("JOB_CODE");
				String salLevel = rset.getString("SAL_LEVEL");
				int salary = rset.getInt("SALARY");
				double bonus = rset.getDouble("BONUS");
				int managerId = rset.getInt("MANAGER_ID");
				Date hireDate = rset.getDate("HIRE_DATE");
				Date entDate = rset.getDate("ENT_DATE");
				char entYn = rset.getString("ENT_YN").charAt(0);
				
				System.out.println("사원 번호 : "+empId
						          +"사원 이름 : "+empName
						          +"사원 주민번호 : "+empNo
						          +"사원 메일 : "+email
						          +"사원 핸드폰번호 : "+phone
						          +"사원 부서번호 : "+deptCode
						          +"사원 직업번호 : "+jobCode
						          +"사원 급여등급 : "+salLevel
						          +"사원 급여 : "+salary
						          +"사원 보너스 : "+bonus
						          +"관리자 사번 : "+managerId
						          +"입사일 : "+hireDate
						          +"퇴사일 : "+entDate
						          +"퇴사여부 : "+entYn);
			}
			
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset != null && !rset.isClosed()) {
					rset.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				if(stmt!=null &&!stmt.isClosed()) {
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
