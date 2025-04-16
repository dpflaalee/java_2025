package com.thejoa.boot3.board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter @ToString
@NoArgsConstructor
public class PagingDto {
	private int listtotal;   //1) 전체글 전체 수량			:120
	private int onepagelist; //2) 한 페이지에 보이는 게시글 수	:10
	private int pagetotal;   //3) 총 페이지 수 				:120/10 12페이지
	private int bottomlist;  //4) 하단의 페이지 나누기		:11 12 13 ... 몇개?
	
	private int pstartno;    //5) 페이지의 스타트번호			:[1]-최신글 0~10개
	
	private int current;     //6) 현재 페이지 번호
	private int start;       //7) 시작 페이지 번호
	private int end;         //8) 끝 페이지 번호
	
	public PagingDto(int listtotal, int pstartno) {
		super();
		this.listtotal = listtotal;		//전체계산한 값 120
		this.onepagelist = 10;
		
		// 120/10 = 12page
		if(this.listtotal<0) {this.listtotal=1;}
		this.pagetotal = (int)Math.ceil(listtotal/(double)onepagelist);
		
		this.bottomlist=10; 
		// 하단에 10개씩 노출
		
		this.pstartno = pstartno*10;	//시작번호 넘겨받은 값 limit 0,10 10,10 ,20,10
		//    1(0) 2(10) 3(20) 4(30) 5(40) 6 7 8 9 10 다음		
		//이전 11 12 13 14 15 16 17 18 19 20 다음
		//pstartno = 10 이라고하면 현재 페이지 번호는 2
		//pstartno = 30 이라고하면 현재 페이지 번호는 4
		this.current=(this.pstartno/this.onepagelist)+1;
		//시작번호) 11 15 20 (11~20사이 목록이라면 어떤 수를 받아도 11부터 시작하게)-> 앞자리는 1 -> 1*10+1
		this.start=((this.current-1)/this.bottomlist)*this.bottomlist+1;       
		this.end=this.start+bottomlist-1;
		if(pagetotal<end) {this.end=pagetotal;}
	}
	
}
