package com.thejoa.boot003;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thejoa.boot003.myjpa.Board;
import com.thejoa.boot003.myjpa.BoardRepository;
import com.thejoa.boot003.myjpa.Member;
import com.thejoa.boot003.myjpa.MemberRepository;

@SpringBootTest
public class BoardTest {
	@Autowired BoardRepository boardRepository;
	@Autowired MemberRepository memberRepository;
	
	@Disabled //@Test
	public void insert() {
		Member member = new Member();
		member.setId(1L);
		
		Board board = new Board();
		board.setId(1L);
		board.setBtitle("title-1");
		board.setBcontent("content-1");
		board.setBpass("1111");
		board.setBfile("1.jpg");
		
		try {
			board.setBip(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) { e.printStackTrace(); }
		
		board.setMember(member);
		boardRepository.save(board);
	}

	@Disabled @Test
	public void findALL() {
		List<Board> list = boardRepository.findAll();
		System.out.println(list.get(0).getBtitle());
	}
	
	//detail , editView
	@Disabled @Test
	public void findBoard() {
		Optional<Board> findBoard= boardRepository.findById(1L);
		if(findBoard.isPresent()) {
			Board board = findBoard.get();
			System.out.println(board.getBtitle());
		}
	}
	
	@Disabled @Test
	public void update () {
		Optional<Board> findBoard = boardRepository.findById(1L);
		if(findBoard.isPresent()) {
			Board board = findBoard.get();
			board.setBtitle("title-new");
			board.setBcontent("content-new");
			boardRepository.save(board);
		}
	}
	
	/*
	 * @Disabled @Test public void delete() { Optional<Board> findBoard =
	 * boardRepository.findById(2L); Board board =findBoard.get();
	 * boardRepository.delete(board); }
	 */
}
