package com.company.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // 1. 스프링이 관리하는 부품객체 - dao
public class TestDaoimpl implements TestDao {

	@Autowired private SqlSession sqlSession; // 2. crud
	private static final String namespace="com.company.dao.TestDao";
	
	@Override
	public String readTime() {
		return sqlSession.selectOne(namespace+".readTime");
	}
	//sqlSession.insert(경로의 메서드명, dto) 
	//sqlSession.update(경로의 메서드명, dto) 
	//sqlSession.delete(경로의 메서드명, no) 
	//sqlSession.selectOne(경로의 메서드명, no) 
	//sqlSession.selectList(경로의 메서드명, no) 
}
