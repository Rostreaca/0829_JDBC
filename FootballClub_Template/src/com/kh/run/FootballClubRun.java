package com.kh.run;

import com.kh.common.JDBCTemplate;
import com.kh.view.FootballClubView;

public class FootballClubRun {
	public static void main(String[] args) {
		
		JDBCTemplate.registDriver();
		
		FootballClubView fcv = new FootballClubView();
		fcv.mainMenu();
	}
}
