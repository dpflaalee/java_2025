package com.company.java009_ex;

//클래스부품 > 상태와 행위
//final 수정하지
/*초기화순서
			  기본값 > 명시적 초기화 > 초기화 블록 > 생성자
final nation  null		korea	  korea		korea
final jumin	  null		null(X)	  null(X)	null(X)
name		  null		null(X)	  null(X)	.연산자 이용 (O) 수정가능
*/

class User002 {
	   final String nation = "Korea";   
	   final String jumin;   
	   String name;

	   public User002() { jumin="00000"; }
	   public User002(String jumin, String name) {
	      this.jumin = jumin;
	      this.name = name;
	   }
	@Override
	public String toString() {
		return "User002 [nation=" + nation + ", jumin=" + jumin + ", name=" + name + "]";
	}
	}
	 public class FinalEx {
	   public static void main(String[] args) {
	      User002 user1 = new User002("123456-1234567", "아이유");
	      System.out.println(user1);   
	      
	      //user1.nation = "USA";      //final 붙어있는데 새로 선언해서
	      //user1.jumin  = "123123-1234321"; //초기화값을 잡지않아서 
	      user1.name = "IU";  
	      System.out.println(user1);   
	   }
	}


/*
(1) runtime data area
----------------------------------------------------------------------
[method : 정보,공유] User002.class FinalEx.class // final{nation, jumin] ##1.
 ----------------------------------------------------------------------
[heap:동적영역]									| [stack:임시지역변수]
1번지 {nation=Korea, jumin=123456-1234567, name=아이유}< user1 (1번지)
 												| main ##2.
 ----------------------------------------------------------------------
	 

*/