package com.kh.controller;

import java.sql.Date;

import com.kh.model.dao.FootballClubDao;
import com.kh.model.vo.FootballClub;

public class FootballClubController {

	public int addPlayer(int playerNo, String playerName, char gender, String position, int height, int weight,
			String dominantFoot, int salary, Date contractDate, Date expiryDate) {

		FootballClub footballClub = new FootballClub(playerNo, playerName, gender, position, height, weight, dominantFoot, salary, contractDate, expiryDate);
		//Date를 임포트 하지 않아서 오류가 남
		
		
		int result = new FootballClubDao().addPlayer(footballClub);
		
		return result;
	}

}
