package kh.com.model.service;

import static kh.com.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import kh.com.model.dao.EmployeeDAO;
import kh.com.model.dto.EmployeeDTO;
import kh.com.model.vo.Employee;

public class EmployeeService {

	private Connection conn = null;
	
	public EmployeeService() {
		this.conn = getConnection();
	}
	
	public List<Employee> findAll(){
		
		List<Employee> employees = new EmployeeDAO().findAll(conn);
		
		close(conn);
		
		return employees;
	}
	
	public List<Employee> findByDept(String dept){
		List<Employee> employees = new EmployeeDAO().findByDept(conn, dept);
		
		close(conn);
		
		return employees;
	}
	
	public List<Employee> findByJob(String job){
		List<Employee> employees = new EmployeeDAO().findByJob(conn, job);
		
		close(conn);
		
		return employees;
	}
	
	public Employee findById(int empId) {
		Employee employee = new EmployeeDAO().findById(conn, empId);
		
		close(conn);
		
		return employee;
	}
	
	public List<Employee> findByDesc(){
		List<Employee> employees = new EmployeeDAO().findByDesc(conn);
		
		close(conn);
		
		return employees;
	}
	
	public List<Employee> findByAsc(){
		List<Employee> employees = new EmployeeDAO().findByAsc(conn);
		
		close(conn);
		
		return employees;
	}
	
	public int save(EmployeeDTO ed) {
		int result = new EmployeeDAO().save(conn,ed);
		
		if(result > 0) {
			commit(conn);		
		}
		
		close(conn);
		
		return result;		
	}
	public int update(EmployeeDTO ed) {
		int result = new EmployeeDAO().update(conn, ed);
		
		if(result > 0) {
			commit(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	
	public int delete(int empId) {
		int result = new EmployeeDAO().delete(conn, empId);
		
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		
		return result;
	}
}
