package com.kh.statement.run;

import java.sql.Date;

import com.kh.common.JDBCTemplate;
import com.kh.statement.view.MemberView;

public class MemberRun {

	public static void main(String[] args) {
		JDBCTemplate.registDriver();
		MemberView mv = new MemberView();
		mv.mainMenu();
	}

}
