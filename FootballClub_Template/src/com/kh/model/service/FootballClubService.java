package com.kh.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.model.dao.FootballClubDao;
import com.kh.model.dto.FootballClubDTO;
import com.kh.model.vo.FootballClub;

public class FootballClubService {

	private Connection conn = null;
	
	public FootballClubService() {
		
		conn = getConnection();
	}
	
	public int addPlayer(FootballClub player) {
		
		int result = new FootballClubDao().addPlayer(conn,player);
		
		if(result > 0) {
			commit(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public List<FootballClub> findAll(){
		
		List<FootballClub> players = new FootballClubDao().findAll(conn);
		
		close(conn);
		
		return players;
	}
	
	public FootballClub findByNumber(int playerNo) {
		
		FootballClub player = new FootballClubDao().findByNumber(conn,playerNo);
		
		close(conn);
		
		return player;
	}
	public List<FootballClub> findByKeyword(String keyword){
		
		List<FootballClub> players = new FootballClubDao().findByKeyword(conn,keyword);
		
		close(conn);
		
		return players;
	}
	public int update(FootballClubDTO fcd) {
		
		int result = new FootballClubDao().update(conn,fcd);
		
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		
		return result;
	}
	public int delete(FootballClub player) {
		
		int result = new FootballClubDao().delete(conn,player);
		
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		
		return result;
	}
}
