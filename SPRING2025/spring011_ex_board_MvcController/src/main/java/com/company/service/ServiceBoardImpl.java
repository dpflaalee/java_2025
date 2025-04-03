package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dao.BoardDao;
import com.company.dto.BoardDto;

@Service
public class ServiceBoardImpl implements ServiceBoard {

	@Autowired BoardDao dao;
	
	@Override public int insert(BoardDto dto) { return dao.insert(dto); }
	@Override public int update(BoardDto dto) { return dao.update(dto); }
	@Override public int delete(BoardDto dto) { return dao.delete(dto); }

	@Override public List<BoardDto> selectAll() { return dao.selectAll(); }
	@Override public int updateForm(int bno) { return 0; }
	@Override public BoardDto detail(int bno) { return null; }

}
