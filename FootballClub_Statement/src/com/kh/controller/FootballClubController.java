package com.kh.controller;

import com.kh.model.dao.FootballClubDao;
import com.kh.model.vo.FootballClub;

public class FootballClubController {

	public int addPlayer(int playerNo, String playerName, char gender, String position, int height, int weight,
			String dominantFoot, int salary, String contractDate, String expiryDate) {

		FootballClub footballClub = new FootballClub(playerNo, playerName, gender, position, height, weight, dominantFoot, salary, contractDate, expiryDate);
		
		int result = new FootballClubDao().addPlayer(footballClub);
		
		return result;
	}

}
