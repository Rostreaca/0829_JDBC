package kh.com.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import kh.com.controller.EmployeeController;
import kh.com.model.dto.EmployeeDTO;
import kh.com.model.vo.Employee;

public class EmployeeView {

	private Scanner sc = new Scanner(System.in);
	private EmployeeController ec = new EmployeeController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("=== 메인메뉴 ===");
			System.out.println("1. 사원 전체 조회");
			System.out.println("2. 같은 부서 사원 조회");
			System.out.println("3. 같은 직급 사원 조회");
			System.out.println("4. 사원 상세 조회");
			System.out.println("5. 급여가 높은 상위 5명 조회");
			System.out.println("6. 급여가 낮은 하위 5명 조회");
			System.out.println("7. 사원 추가");
			System.out.println("8. 사원 정보 수정");
			System.out.println("9. 사원 퇴사");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 번호 입력 : ");
			
			int menuNo = 0;
			
			try {
				menuNo = sc.nextInt();
				sc.nextLine();				
			} catch(InputMismatchException e) {
				e.printStackTrace();
			}
			
			switch(menuNo) {
			case 1 : findAll();break;
			case 2 : findByDept();break;
			case 3 : findByJob();break;
			case 4 : findById();break;
			case 5 : findByDesc();break;
			case 6 : findByAsc();break;
			case 7 : save();break;
			case 8 : update();break;
			case 9 : delete();break;
			case 0 : System.out.println("프로그램 종료.");return;
			default : System.out.println("잘못된 값을 입력하였습니다.");
			}
		}
	}
	
	private void findAll() {
		
		System.out.println("전체 사원을 조회합니다..");
		
		List<Employee> employees = ec.findAll();
		
		if(!employees.isEmpty()) {
			
			for(Employee employee : employees) {
				System.out.print("사원 번호 : "+employee.getEmpId());
				System.out.print(" 사원 이름 : "+employee.getEmpName());
				System.out.print(" 급여 : "+employee.getSalary());
				System.out.print(" 부서 : "+employee.getDeptCode());
				System.out.print(" 직급 : "+employee.getJobCode());
				System.out.println();
			}
			
		} else {
			System.out.println("조회 결과가 없습니다.");
		}
	}
	
	private void findByDept() {
		
		System.out.print("조회할 부서를 입력해 주십시오 : ");
		String dept = sc.nextLine();
		
		List<Employee> employees = ec.findByDept(dept);
		if(!employees.isEmpty()) {
			
			for(Employee employee : employees) {
				System.out.print("사원 번호 : "+employee.getEmpId());
				System.out.print(" 사원 이름 : "+employee.getEmpName());
				System.out.print(" 급여 : "+employee.getSalary());
				System.out.print(" 부서 : "+employee.getDeptCode());
				System.out.print(" 직급 : "+employee.getJobCode());
				System.out.println();
			}
			
		} else {
			System.out.println("조회 결과가 없습니다.");
		}
	}
	
	private void findByJob() {
		System.out.print("조회할 직급을 입력하십시오 : ");
		String job = sc.nextLine();
		
		List<Employee> employees = ec.findByJob(job);
		
		if(!employees.isEmpty()) {
			for(Employee employee : employees) {
				System.out.print("사원 번호 : "+employee.getEmpId());
				System.out.print(" 사원 이름 : "+employee.getEmpName());
				System.out.print(" 급여 : "+employee.getSalary());
				System.out.print(" 부서 : "+employee.getDeptCode());
				System.out.print(" 직급 : "+employee.getJobCode());
				System.out.println();
			}
		} else {
			System.out.println("조회 결과가 없습니다!!");
		}
		
	}
	private void findById() {
		System.out.println("조회할 사원의 사원번호를 입력하십시오 : ");
		int empId = sc.nextInt();
		sc.nextLine();
		
		Employee employee = ec.findById(empId);
		
		if(employee != null) {
			System.out.println("사원 번호 : "+employee.getEmpId());
			System.out.println("사원 이름 : "+employee.getEmpName());
			System.out.println("급여 : "+employee.getSalary());
			System.out.println("부서 : "+employee.getDeptCode());
			System.out.println("직급 : "+employee.getJobCode());
			System.out.println();
		} else {
			System.out.println("조회할 사원이 없습니다..");
		}
		
	}
	private void findByDesc() {
		System.out.println("급여 상위 5인은 이하와 같습니다.");
		System.out.println("========================");
		List<Employee> employees = ec.findByDesc();
		
		if(!employees.isEmpty()) {
			for(Employee employee : employees) {
				System.out.print("사원 번호 : "+employee.getEmpId());
				System.out.print(" 사원 이름 : "+employee.getEmpName());
				System.out.print(" 급여 : "+employee.getSalary());
				System.out.print(" 부서 : "+employee.getDeptCode());
				System.out.print(" 직급 : "+employee.getJobCode());
				System.out.println();
			}
		} else {
			System.out.println("조회할 사원이 없습니다.");
		}
	}
	
	private void findByAsc() {
		System.out.println("급여 하위 5인은 이하와 같습니다.");
		System.out.println("========================");
		List<Employee> employees = ec.findByAsc();
		
		if(!employees.isEmpty()) {
			for(Employee employee : employees) {
				System.out.print("사원 번호 : "+employee.getEmpId());
				System.out.print(" 사원 이름 : "+employee.getEmpName());
				System.out.print(" 급여 : "+employee.getSalary());
				System.out.print(" 부서 : "+employee.getDeptCode());
				System.out.print(" 직급 : "+employee.getJobCode());
				System.out.println();
			}
		} else {
			System.out.println("조회할 사원이 없습니다.");
		}
	}
	private void save() {
		System.out.println("사원 등록 시스템입니다.");
		System.out.println("아래 정보들을 입력해주십시오.");
		System.out.print("사원 이름 : ");
		String empName = sc.nextLine();
		System.out.print("주민등록번호 : ");
		String empNo = sc.nextLine();
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		System.out.print("전화번호 : ");
		String phone = sc.nextLine();
		System.out.print("부서 코드 : ");
		String deptCode = sc.nextLine();
		System.out.print("직급 코드 : ");
		String jobCode = sc.nextLine();
		System.out.print("급여 등급 : ");
		String salLevel = sc.nextLine();
		System.out.print("급여 : ");
		int salary = sc.nextInt();
		sc.nextLine();
		System.out.print("보너스 : ");
		double bonus = sc.nextDouble();
		System.out.print("관리자 사번 : ");
		int managerId = sc.nextInt();
		
		int result = ec.save(new EmployeeDTO(empName,empNo,email,phone,deptCode,jobCode,salLevel,salary,bonus,managerId));
		
		if(result > 0) {
			System.out.println("사원 추가에 성공하였습니다!");
		} else {
			System.out.println("사원 추가에 실패했습니다.");
		}
		
	}
	private void update() {
		System.out.println("사원 정보 수정 기능입니다.");
		System.out.print("변경할 사원의 사번을 입력해주세요 > ");
		int empId = sc.nextInt();
		sc.nextLine();
		System.out.print("변경할 사원의 급여를 입력해주세요 > ");
		int salary = sc.nextInt();
		sc.nextLine();
		System.out.print("변경할 직급명을 입력해 주십시오 > ");
		String jobCode = sc.nextLine();
		System.out.print("변경할 부서명을 입력해 주십시오 > ");
		String deptCode = sc.nextLine();
		
		EmployeeDTO ed = new EmployeeDTO();
		
		ed.setEmpId(empId);
		ed.setSalary(salary);
		ed.setJobCode(jobCode);
		ed.setDeptCode(deptCode);
		
		int result = ec.update(ed);
		
		if(result > 0) {
			System.out.println("사원 정보 변경에 성공했습니다.");
		} else {
			System.out.println("사원 정보 변경에 실패했습니다.");
		}
		
	}
	private void delete() {
		System.out.println("퇴사할 사원의 정보를 지웁니다.");
		System.out.print("퇴사할 사원의 사번을 입력해주세요 > ");
		int empId = sc.nextInt();
		sc.nextLine();
		
		int result = ec.delete(empId);
		
		if(result > 0) {
			System.out.println("사원이 퇴사하였습니다.");
		} else {
			System.out.println("정보 삭제에 실패하였습니다.");
		}
	}
	
	
}
