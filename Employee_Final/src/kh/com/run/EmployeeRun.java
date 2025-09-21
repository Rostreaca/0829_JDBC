package kh.com.run;

import kh.com.common.Template;
import kh.com.view.EmployeeView;

public class EmployeeRun {

	public static void main(String[] args) {
		//JDBCTemplate.registDriver();
//		Template.getSqlSession();
		EmployeeView ev = new EmployeeView();
		ev.mainMenu();
		
	}

}
