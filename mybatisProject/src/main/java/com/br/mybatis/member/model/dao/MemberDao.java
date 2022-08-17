package com.br.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.br.mybatis.member.model.vo.Member;

public class MemberDao {
	
	public int insertMember(SqlSession sqlSession, Member m) {
		
		/*
		 * 기존에 순수 JDBC 과정 
		 * 
		 * int result = 0;
		 * PreparedStatement pstmt = null;
		 * String sql = prop.getProperty("insertMember");
		 * 
		 * try{
		 * 		pstmt = conn.prepareStatment(sql);
		 * 		pstmt.setString(1, m.getUserId());
		 * 		pstmt.setString(2, m.getUserPwd());
		 * 		.....
		 * 
		 * 		result = pstmt.executeUpdate();
		 * 
		 * } catch(XXX){
		 * 
		 * } finally{
		 *   close(pstmt);
		 * }
		 */
		
		/*
		 * sqlSession에서 제공하는 메소드를 이용해서
		 * sql문 찾아서 곧바로 실행하고 결과바로받음
		 * 
		 * 결과 = sqlSession.sql문종류에맞는메소드("매퍼의별칭.해당sql문고유한id", [그sql문을 완성시킬 객체]);
		 */
		
		//int result = sqlSession.insert("memberMapper.insertMember", m);
		//return result;
		return sqlSession.insert("memberMapper.insertMember", m);
	}
	
	public Member loginMember(SqlSession sqlSession, Member m) {
		
		/*
		 * Member loginUser = null;
		 * PreparedStatement pstmt = null;
		 * ResultSet rset = null;
		 * 
		 * String sql = prop.getProperty("loginMember");
		 * 
		 * try{
		 * 		pstmt = conn.prepareStatement(sql);
		 * 		pstmt.setString(1, m.getUserId());
		 * 		pstmt.setString(2, m.getUserPwd());
		 * 
		 * 		rset = pstmt.executeQuery();
		 * 
		 * 		if(rset.next()){
		 * 			loginUser = new Member(rset.getInt("user_no"),
		 * 								   rset.getString("user_id"),
		 * 								   ...);
		 *  	}
		 * }catch(XXXX) {
		 * 
		 * }
		 * 
		 */
		
		// selectOne 메소드 : 조회결과가 없다면 null반환
		Member loginUser = sqlSession.selectOne("memberMapper.loginMember", m);
		return loginUser;
	}
	
	
	
	
	

}
