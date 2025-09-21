package kh.com.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;

import kh.com.common.JDBCTemplate;
import kh.com.model.dto.EmployeeDTO;
import kh.com.model.vo.Employee;

public class EmployeeDAO {
	
	public List<Employee> findAll(SqlSession session){
		return session.selectList("employeeMapper.findAll");
	}
	
	public List<Employee> findByDept(Connection conn, String dept){
		
		List<Employee> employees = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findByDept");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				employees.add(new Employee(rset.getInt("EMP_ID")
						                  ,rset.getString("EMP_NAME")
						                  ,rset.getInt("SALARY")
						                  ,rset.getString("DEPT_TITLE")
						                  ,rset.getString("JOB_NAME")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return employees;
	}
	
	public List<Employee> findByJob(Connection conn, String job){
		List<Employee> employees = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findByJob");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, job);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				employees.add(new Employee(rset.getInt("EMP_ID")
						                  ,rset.getString("EMP_NAME")
						                  ,rset.getInt("SALARY")
						                  ,rset.getString("DEPT_TITLE")
						                  ,rset.getString("JOB_NAME")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return employees;
		
	}
	
	public Employee findById(Connection conn, int empId) {
		
		Employee employee = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findById");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				employee = new Employee(rset.getInt("EMP_ID")
						               ,rset.getString("EMP_NAME")
						               ,rset.getInt("SALARY")
						               ,rset.getString("DEPT_TITLE")
						               ,rset.getString("JOB_NAME"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return employee;
	}
	
	public List<Employee> findByDesc(Connection conn){
		List<Employee> employees = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findByDesc");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				employees.add(new Employee(rset.getInt("EMP_ID")
						                  ,rset.getString("EMP_NAME")
						                  ,rset.getInt("SALARY")
						                  ,rset.getString("DEPT_TITLE")
						                  ,rset.getString("JOB_NAME")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return employees;
	}
	
	public List<Employee> findByAsc(Connection conn){
		List<Employee> employees = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findByAsc");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				employees.add(new Employee(rset.getInt("EMP_ID")
						                  ,rset.getString("EMP_NAME")
						                  ,rset.getInt("SALARY")
						                  ,rset.getString("DEPT_TITLE")
						                  ,rset.getString("JOB_NAME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return employees;
	}
	
	public int save(Connection conn, EmployeeDTO ed) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("save");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ed.getEmpName());
			pstmt.setString(2, ed.getEmpNo());
			pstmt.setString(3, ed.getEmail());
			pstmt.setString(4, ed.getPhone());
			pstmt.setString(5, ed.getDeptCode());
			pstmt.setString(6, ed.getJobCode());
			pstmt.setString(7, ed.getSalLevel());
			pstmt.setInt(8, ed.getSalary());
			pstmt.setDouble(9, ed.getBonus());
			pstmt.setInt(10, ed.getManagerId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int update(Connection conn, EmployeeDTO ed) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updㅁate");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ed.getSalary());
			pstmt.setString(2, ed.getJobCode());
			pstmt.setString(3, ed.getDeptCode());
			pstmt.setInt(4, ed.getEmpId());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result; 
	}
	
	
	public int delete(Connection conn, int empId) {
		int result =0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("delete");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
	}
}
