package kh.com.run;

import kh.com.common.JDBCTemplate;
import kh.com.view.EmployeeView;

public class EmployeeRun {

	public static void main(String[] args) {
		JDBCTemplate.registDriver();
		
		EmployeeView ev = new EmployeeView();
		ev.mainMenu();
		
	}

}
