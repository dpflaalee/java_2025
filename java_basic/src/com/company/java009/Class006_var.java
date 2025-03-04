package com.company.java009;

class A{
	//멤버변수
	int a=10;	//인스턴스 변수 - heap - new O - this 각각
	{a=100;}
	static String company="동물농장"; 	//명시적 초기화
	static {company="동물농장-joy";}	//초기화블록
	//클래스 변수 - 'method'영역의 'new'와 관련없음 > 생성자와 관련없음 - 공유되는 영역
	//멤버함수
	void methid(){int a=3000; System.out.println(a);} //지역변수-stack-무조건 초기화
	void show(){System.out.println(this.a);}	//인스턴스변수
	
	A(){}
	A(int a){this.a=a;}
	@Override
	public String toString() {
		return "A [a=" + a + "]";
	}
}

public class Class006_var {
	public static void main(String[] args) {
		//클래스변수
		System.out.println(A.company);
		//인스턴스변수
		A a1 = new A(3); System.out.println(a1);
		A a2 = new A(7); System.out.println(a2); a2.methid();
	}
}
/*
(1) runtime data area
----------------------------------------------------------------------
[method : 정보,공유] A.class Class006.class // company[], main ##1.
----------------------------------------------------------------------
[heap:동적영역]			| [stack:임시지역변수]
						← a2.method(){int a=3000; System.out.println(a);} >수동으로 초기화
2번지{a=7}				← a2 2번지
1번지{a=3}				← a1 1번지
						| main ##2.
----------------------------------------------------------------------

(2) 초기화 순서
*					기본값	명시적초기화	초기화블록		 생성자
클래스변수 company		1.null	2.동물농장		3.동물농장-joy	 관련X
							ex.company="회사명"	
인스턴스 변수 a			4.0		5.10		6.100		 7.3	

*/