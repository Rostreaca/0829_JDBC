package kh.com.model.vo;

import java.sql.Date;
import java.util.Objects;

public class Employee {

	private int empId;
	private String empName;
	private int salary;
	private String empNo;
	private String email;
	private String phone;
	private String deptCode;
	private String jobCode;
	private String salLevel;
	private double bonus;
	private int managerId;
	private Date hireDate;
	
	
	

	public Employee(int empId, String empName, int salary, String deptCode, String jobCode) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.deptCode = deptCode;
		this.jobCode = jobCode;
	}

	public Employee(int empId, String empName, int salary, String empNo, String email, String phone, String deptCode,
			String jobCode, String salLevel, double bonus, int managerId, Date hireDate) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.empNo = empNo;
		this.email = email;
		this.phone = phone;
		this.deptCode = deptCode;
		this.jobCode = jobCode;
		this.salLevel = salLevel;
		this.bonus = bonus;
		this.managerId = managerId;
		this.hireDate = hireDate;
	}

	public int getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public String getEmpNo() {
		return empNo;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public String getJobCode() {
		return jobCode;
	}

	public String getSalLevel() {
		return salLevel;
	}

	public int getSalary() {
		return salary;
	}

	public double getBonus() {
		return bonus;
	}

	public int getManagerId() {
		return managerId;
	}

	public Date getHireDate() {
		return hireDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bonus, deptCode, email, empId, empName, empNo, hireDate, jobCode, managerId, phone,
				salLevel, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Double.doubleToLongBits(bonus) == Double.doubleToLongBits(other.bonus)
				&& Objects.equals(deptCode, other.deptCode) && Objects.equals(email, other.email)
				&& empId == other.empId && Objects.equals(empName, other.empName) && Objects.equals(empNo, other.empNo)
				&& Objects.equals(hireDate, other.hireDate) && Objects.equals(jobCode, other.jobCode)
				&& managerId == other.managerId && Objects.equals(phone, other.phone)
				&& Objects.equals(salLevel, other.salLevel) && salary == other.salary;
	}
	
	
	
	
	
}
