package com.company.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.dto.BoardDto;

@Repository
public class BoardDaoimpl implements BoardDao {
	@Autowired SqlSession sqlSession;
	private static final String namepass="com.company.dao.BoardDao";
	
	@Override
	public int insert(BoardDto dto) {
		return sqlSession.insert(namepass+".insert",dto);
	}
	@Override
	public int update(BoardDto dto) {
		return sqlSession.update(namepass+".update",dto);
	}
	
	@Override
	public int delete(BoardDto dto) {
		return sqlSession.delete(namepass+".delete",dto);
	}
	
	@Override
	public int updateHit(int bno) {
		return sqlSession.update(namepass+".updateHit",bno);
	}
	
	@Override
	public BoardDto selectOne(int bno) {
		return sqlSession.selectOne(namepass+".selectOne",bno);
	}
	
	@Override
	public List<BoardDto> selectAll() {
		return sqlSession.selectList(namepass+".selectAll");
	}
}
