package com.kh.statement.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.Template;
import com.kh.statement.model.dao.MemberDao;
import com.kh.statement.model.vo.Member;

public class MemberService {
	
	private MemberDao memberDao = new MemberDao();
	
	public int save(Member member) {
		/*
		 * Connection conn = JDBCTemplate.getConnection();
		 * 
		 * int result = new MemberDao().save(conn, member);
		 * 
		 * if(result > 0){
		 *    JDBCTemplate.close(conn);
		 * }
		 * 
		 * return result;
		 * 
		 */
		SqlSession session = Template.getSqlSession();
		
		int result = memberDao.save(session, member);
		
		if(result > 0) {
			session.commit();
		}
		
		
		session.close();
		
		
		return result;
	}
	
	public List<Member> findAll(){
		
		SqlSession session = Template.getSqlSession();
		
		List<Member> members = memberDao.findAll(session);
		
		session.close();
		
		return members;
	}
	
	
}
