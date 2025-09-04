package kh.com.controller;

import java.util.List;

import kh.com.model.dto.EmployeeDTO;
import kh.com.model.service.EmployeeService;
import kh.com.model.vo.Employee;

public class EmployeeController {

	
	public List<Employee> findAll(){
		
		List<Employee> employees = new EmployeeService().findAll();
		
		return employees;
	}
	
	public List<Employee> findByDept(String dept){
		
		List<Employee> employees = new EmployeeService().findByDept(dept);
		
		return employees;
	}
	
	public List<Employee> findByJob(String job){
		
		List<Employee> employees = new EmployeeService().findByJob(job);
		
		return employees;
	}
	
	public Employee findById(int empId) {
		
		Employee employee = new EmployeeService().findById(empId);
		
		return employee;
	}
	
	public List<Employee> findByDesc(){
		
		List<Employee> employees = new EmployeeService().findByDesc();
		
		return employees;
	}
	
	public List<Employee> findByAsc(){
		List<Employee> employees = new EmployeeService().findByAsc();
		
		return employees;
	}
	
	public int save(EmployeeDTO ed) {
		
		int result = new EmployeeService().save(ed);
		
		return result;
	}
	public int update(EmployeeDTO ed) {
		
		int result = new EmployeeService().update(ed);
		
		return result;
	}
	
	public int delete(int empId) {
		
		int result = new EmployeeService().delete(empId);
		
		return result;
	}
}
