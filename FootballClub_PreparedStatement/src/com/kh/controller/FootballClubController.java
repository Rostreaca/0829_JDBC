package com.kh.controller;

import java.util.List;

import com.kh.model.dao.FootballClubDao;
import com.kh.model.dto.FootballClubDTO;
import com.kh.model.vo.FootballClub;

public class FootballClubController {

	public int addPlayer(int playerNo, String playerName, String gender, String position, int height, int weight,
			String dominantFoot, int salary) {

		FootballClub footballClub = new FootballClub(playerNo, playerName, gender, position, height, weight, dominantFoot, salary);
		//Date를 임포트 하지 않아서 오류가 남
		
		
		int result = new FootballClubDao().addPlayer(footballClub);
		
		return result;
	}

	
	public List<FootballClub> findAll(){
		
		
		List<FootballClub> players = new FootballClubDao().findAll();
		
		return players;
	}
	
	public FootballClub findByNumber(int playerNo) {
		
		FootballClub player = new FootballClubDao().findByNumber(playerNo);
		
		return player;
	}
	
	public List<FootballClub> findByKeyword(String keyword){
		
		List<FootballClub> players = new FootballClubDao().findByKeyword(keyword);
		
		return players;
	}
	
	public int update(int playerNo, int height, int weight) {
		
		FootballClubDTO fcd = new FootballClubDTO(playerNo,height,weight);
		
		int result = new FootballClubDao().update(fcd);
		
		return result;
	}
	
	public int delete(int playerNo, String playerName) {
		
		FootballClub player = new FootballClub();
		player.setPlayerNo(playerNo);
		player.setPlayerName(playerName);
		
		int result = new FootballClubDao().delete(player);
		
		return result;
	}
}
