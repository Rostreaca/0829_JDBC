package com.kh.run;

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
		System.out.print("직원 번호를 입력해주십시오 : ");
		int empId = sc.nextInt();
		sc.nextLine();
		System.out.print("이름을 입력해주십시오 : ");
		String empName = sc.nextLine();
		System.out.print("주민등록번호를 입력해주십시오 : "); //EMP_ID , EMP_NAME, EMP_NO, EMAIL, PHONE, DEPT_CODE, JOB_CODE, SAL_LEVEL, SALARY, BONUS, MANAGER_ID, HIRE_DATE, ENT_DATE, ENT_YN  
		String empNo = sc.nextLine();
		System.out.print("이메일을 입력해주십시오 : ");
		String email = sc.nextLine();
		System.out.print("전화번호를 입력해주십시오 : ");
		String phone = sc.nextLine();
		System.out.print("부서코드를 입력해주십시오 : ");
		String deptCode = sc.nextLine();
		System.out.print("직업코드를 입력해주십시오 : ");
		String jobCode = sc.nextLine();
		System.out.print("급여등급을 입력해주십시오 : ");
		String salLevel = sc.nextLine();
		System.out.print("급여를 입력해주십시오 : ");
		int salary = sc.nextInt();
		sc.nextLine();
		System.out.print("보너스를 입력해주십시오 : ");
		double bonus = sc.nextDouble();
		System.out.print("관리자 사번을 입력해주십시오 : ");
		int managerId = sc.nextInt();
		sc.nextLine();
		
		String sql = "INSERT "
				   + "INTO "
				          + "EMPLOYEE "
				           +"("
				           +"EMP_ID"
				         +", EMP_NAME"
				         +", EMP_NO"
				         +", EMAIL"
				         +", PHONE"
				         +", DEPT_CODE"
				         +", JOB_CODE"
				         +", SAL_LEVEL"
				         +", SALARY"
				         +", BONUS"
				         +", MANAGER_ID"
				         +", HIRE_DATE"
				           +")"
				   + "VALUES"
				             +"("
				               +empId
				         +", '"+empName
				        +"' ,'"+empNo
				        +"', '"+email
				        +"', '"+phone
				        +"', '"+deptCode
				        +"', '"+jobCode
				        +"', '"+salLevel
				         +"', "+salary
				          +", "+bonus
				          +", "+managerId
				          +", "+"SYSDATE"
				          	+ ")";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver 등록 성공");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE",
					                           "PSH07",
					                           "PSH071234");
			conn.setAutoCommit(false);
			
			System.out.println("DB서버 접속 성공!");
			
			stmt = conn.createStatement();
			System.out.println("Statement 객체 생성!");
			
			result = stmt.executeUpdate(sql);
			System.out.println("SQL문 실행 성공");
			
			if(result > 0) {
				conn.commit();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt !=null) {
					stmt.close();					
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

}
