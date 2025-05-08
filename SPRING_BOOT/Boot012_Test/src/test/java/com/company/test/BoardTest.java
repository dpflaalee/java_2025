package com.company.test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.test.board.Board;
import com.company.test.board.BoardRepository;

@SpringBootTest
public class BoardTest {
	@Autowired BoardRepository boardRepository;
	
	//insert
	@Disabled @Test
	public void insertBoard() {
		Board board = new Board();
		board.setBtitle("first-test");
		board.setBcontent("first-content");
		board.setBpass("1111");
		try { board.setBip(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) { e.printStackTrace(); }
		boardRepository.save(board);
	}
	//select
	@Disabled @Test
	public void selectAll() {
		List<Board> list =boardRepository.findAll();
		System.out.println(list.get(0).getBtitle());
	}
	//selectOne
	@Disabled @Test
	public void findByIdBoard() {
		Optional<Board> findBoard = boardRepository.findById(2L);
		if(findBoard.isPresent()) {
			Board board = findBoard.get();
			System.out.println(board.getBtitle());
		}
	}
	
	@Disabled @Test
	public void selectAllOrderByDesc() {
		List<Board> list = boardRepository.findAllByOrderByIddesc();
		System.out.println(list.get(0).getBtitle());
	}
	
	//update
	@Disabled @Test
	public void updateBoard() {
		Optional<Board> findBoard = boardRepository.findById(2L);
		if(findBoard.isPresent()) {
			Board board = findBoard.get();
			board.setBtitle("second-new");
			board.setBcontent("content-new");
			boardRepository.save(board);
		}
	}
	
	//delete
	@Test
	public void deleteBoard() {
		Optional<Board> findBoard = boardRepository.findById(1L);
		if(findBoard.isPresent()) {
			Board board = findBoard.get();
			boardRepository.delete(board);
		}
	}

}
