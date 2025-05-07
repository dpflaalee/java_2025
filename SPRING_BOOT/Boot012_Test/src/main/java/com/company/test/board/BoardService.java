package com.company.test.board;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.test.member.MemberRepositroy;

@Service
public class BoardService {
	@Autowired BoardRepository boardRepository;
	@Autowired MemberRepositroy memberRepositroy;
	
	//select
	public List<Board> findAll(){
		return boardRepository.findAllByOrderByIddesc();
	}
	
	//hitUp
	@Transactional
	public Board find(Long id) {
		Board board = boardRepository.findById(id).get();
		board.setBhit(board.getBhit()+1);
		boardRepository.save(board);
		return board;
	}
	
	//insert
	public void insert(Board board) {
		board.setMember(memberRepositroy.findByUsername(board.getMember().getUsername()).get());
		try { board.setBip(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) { e.printStackTrace(); }
		boardRepository.save(board);
	}
	
	//update
	public Board update_view(Long id) {
		return boardRepository.findById(id).get();
	}
	public int update(Board board) {
		return boardRepository.updateByIdAndBpass(board.getId(), board.getBpass(), board.getBtitle(), board.getBcontent());
	}
	
	//delete
	public int delete(Board board) {
		return boardRepository.deleteByIdAndBpass(board.getId(), board.getBpass());
	}
	
	
}
