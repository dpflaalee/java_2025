package com.thejoa.boot3.board;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa.boot3.member.MemberRepository;
import com.thejoa.boot3.util.UtilUpload;

@Service  //##
public class BoardService{
	@Autowired  BoardRepository  boardRepository; //##
	@Autowired MemberRepository memberRepository;
	@Autowired UtilUpload utilUpload;
	
	/*PAGING*/
	/*PAGING*/
	//1 : 최신글 10 		order by bno desc limit 0,10 0번째부터 10번째
	//2 : 그 다음 최신글 10 order by bno desc limit 10,10 10번째부터 10번째
	public Page<Board> getPaging(int page){//int page : 어디서부터?
		List<Sort.Order> sorts=new ArrayList<>();
		sorts.add(Sort.Order.desc("id")); //id를 기준으로 내림차순		
		
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		return boardRepository.findAll(pageable);
	}
	
	/*PAGING*/
	/*PAGING*/
	
	 public List<Board> findAll() {//##전체리스트뽑고
		//return boardRepository.findAll(); //기본제공 Repository
		return boardRepository.findAllByOrderBydesc(); // repository 설정하고 사용하는 명령어 최신글 위로 올리기
	}
 
	@Transactional  // commit (반영) / rollback (되돌리기)
	 public Board find(Long id) {//##조회수올리고 / 상세보기기능 
		Board board = boardRepository.findById(id).get();
		
		board.setBhit(board.getBhit()+1);   // 기존조회수 + 1
		boardRepository.save(board);
		return board;
	}

	/*img upload :: MultipartFile*/
	 public void insert(MultipartFile file, Board board) {
		/*file Upload*/
		 try {
			board.setBfile(utilUpload.fileUpload(file));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		 
		board.setMember(memberRepository.findByUsername(board.getMember().getUsername()).get());  
		try { board.setBip(InetAddress.getLocalHost().getHostAddress()); }
		catch (UnknownHostException e) { e.printStackTrace(); }
		boardRepository.save(board);
	}

	 public Board update_view(Long id) { return boardRepository.findById(id).get(); }

	 public int update(MultipartFile file, Board board) {
		 /*file Upload*/
		 /*새로운 파일이 올라왔는지 확인*/
		String save = board.getBfile(); // 1.edit.html 먼저 파일 경로 
		if(file.getOriginalFilename().length()!=0) { // 2.새로운 파일이 올라왔는지 확인
		 	try { save= utilUpload.fileUpload(file); }  // 3.새로운거면 업로드
		 	catch (IOException e1) { e1.printStackTrace(); }
		}
		board.setBfile(save); //3.파일이름저장 
		
		//boardRepository.save(board);
		 return boardRepository.updateByIdBpass(
				 board.getId(), 
				 board.getBpass(), 
				 board.getBtitle(),
				 board.getBcontent(),
				 board.getBfile()
				 );
	}

	 public int delete(Board board) {
		//boardRepository.delete(board); // 기본:delete from board where id=?
		return boardRepository.deleteByIdAndBpass(board.getId(), board.getBpass());
	}

}

//
//public void        insert(Board board); //## 글쓰기기능
//
//public Board    update_view(Long id);//## 수정하기 폼
//public void        update(Board board); //## 글수정기능
//
//public void        delete(Board board); //## 글수정기능

