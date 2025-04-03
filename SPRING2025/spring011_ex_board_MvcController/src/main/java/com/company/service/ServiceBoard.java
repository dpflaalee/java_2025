package com.company.service;

import java.util.List;

import com.company.dao.MyDao;
import com.company.dto.BoardDto;

@MyDao
public interface ServiceBoard {
	public int   insert(BoardDto dto);  // 글쓰기기능
	
	public int   update(BoardDto dto);  // 수정기능 (해당글번호보기)
	public int   updateForm(int bno);   // 해당번호 글수정 폼
	
	public int       delete(BoardDto dto);  // 글 삭제기능
	
	public BoardDto  detail(int bno); //상세보기 (조회수올리기 + 해당글번호가져오기) 
	public List<BoardDto>  selectAll();  // 전체데이터가져오기
}
