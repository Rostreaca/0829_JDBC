package com.kh.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.board.model.vo.Board;

public class BoardRepository {

	public int insertBoard(SqlSession session, Board board) {
		return session.insert("boardMapper.insertBoard",board);
	}
	
	public List<Board> selectBoardList(SqlSession session){
		return session.selectList("boardMapper.selectBoardList");
		
	}
	
	public Board selectBoard(SqlSession session, int boardNo) {
		return session.selectOne("boardMapper.selectBoard",boardNo);
	}
	
	public int deleteBoard(SqlSession session, int boardNo) {
		return session.update("boardMapper.deleteBoard",boardNo);
	}
}
