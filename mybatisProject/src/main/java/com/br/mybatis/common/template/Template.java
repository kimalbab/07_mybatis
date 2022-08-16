package com.br.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {

	
	/*
	 * 기존 JDBC
	 * 
	 * public static Connection getConnection(){
	 * 		// driver.properties 파일 읽어들여서 해당 db와 접속된 Connection 객체 생성해서 반환
	 * }
	 * 
	 * public static void close(JDBC용객체) {
	 * 		// 전달받은 JDBC용 객체 반납
	 * }
	 * 
	 * public static void commit | rollback(Connection){
	 * 		// 트랜젝션처리
	 * }
	 */
	
	public static SqlSession getSqlSession() {
		// mybatis-config.xml 파일 읽어들여서 해당 db와 접속된 sqlsession 객체 생성해서 반환
		SqlSession sqlSession = null;
		
		// SqlSession 생성하기 위해 SqlSessionFactory 객체 필요
		// SqlSessionFactory 생성을 위헤 => SqlSessionFactoryBuilder 객체 필요
		
		// /config/mybatis-config.xml을 읽어들이기 위한 입력용 스트림
		try {
			InputStream stream = Resources.getResourceAsStream("/config/mybatis-config.xml");
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession(false);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSession;
	}
	
	
}
