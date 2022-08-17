package com.br.mybatis.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.br.mybatis.common.template.Template;
import com.br.mybatis.member.model.dao.MemberDao;
import com.br.mybatis.member.model.vo.Member;

public class MemberServiceImpl implements MemberService {
	
	private MemberDao mDao = new MemberDao();

	@Override
	public int insertMember(Member m) {
		/*
		 * 기존의 방식
		 * Connection conn = JDBCTemplate.getConnection();
		 * int result = new MemberDao().insertMember(conn, m);
		 * if(result>0) { 
		 * 		JDBCTemplate.commit(conn);
		 * }else{
		 * 		JDBCTemplate.rollback(conn);
		 * }
		 * JDBCTemplate.close(conn);
		 * 
		 * return result;
		 */
		SqlSession sqlSession = Template.getSqlSession(); // mybatis-config.xml 문서읽어들여짐, xxx-mapper.xml 문서들도 읽어들여짐
		int result = mDao.insertMember(sqlSession, m);
		
		if(result > 0) {
			sqlSession.commit();
		}
		
		sqlSession.close();
		
		return result;
	}

	@Override
	public Member loginMember(Member m) {
		
		SqlSession sqlSession = Template.getSqlSession();
		Member loginUser = mDao.loginMember(sqlSession, m);
		
		sqlSession.close();
		return loginUser;
		
	}

	@Override
	public int updateMember(Member m) {
		return 0;
	}

	@Override
	public int deleteMember(String userId) {
		return 0;
	}

}
