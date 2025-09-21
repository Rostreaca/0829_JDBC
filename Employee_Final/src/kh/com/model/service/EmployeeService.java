package kh.com.model.service;

import static kh.com.common.JDBCTemplate.close;
import static kh.com.common.JDBCTemplate.commit;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.com.common.Template;
import kh.com.model.dao.EmployeeDAO;
import kh.com.model.dto.EmployeeDTO;
import kh.com.model.vo.Employee;

public class EmployeeService {
	
	public List<Employee> findAll(){
		
		SqlSession session = Template.getSqlSession();
		
		List<Employee> employees = new EmployeeDAO().findAll(session);
		
		session.close();
		
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
