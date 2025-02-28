package com.company.java008_ex;
//card()생성자 오버로딩시 컴파일러가 기본생성자 자동생성취소
//card()기본생성자 기본셋팅 
class Card{
	   int cardNum; boolean  isMembership;   
	   void input(){} //입력
	   void show(){} //출력
	}

public class ClassExc005 {
	public static void main(String[] args) {
		Card  c1= new Card(); 
		   System.out.println(c1);  
	}
}
/*
public class ClassEx005{
   public static void main(String[] args) {
   Card  c1= new Card(); 
   System.out.println(c1);  
   }
}

출력내용 :
Card[cardNum=0, isMembership=false]*/