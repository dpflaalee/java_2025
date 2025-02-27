package com.company.java008_ex;
//1. 클래스는 부품객체이다
//2. 클래스는 속성(멤버변수)과 행위(멤버함수)를 포함함
class Student001{
	String name; int no, kor, eng, math;
//	void info(String name, int kor, int eng, int math) {
//		this.name = name;
//		this.kor = kor;
//		this.eng = eng;
//		this.math = math;
//		int score = kor+eng+math;
//		System.out.println("이름:"+name);
//		System.out.println("총점:"+score);
//		System.out.printf("평균: %.2f",(score/3f));		}//내가한거 이것도 오류는 없었는데
	
	void info() {
		System.out.println("이름:"+this.name);
		System.out.println("총점:"+(this.kor+this.eng+this.math));
		System.out.printf("평균: %.2f",(this.kor+this.eng+this.math)/3f);
	}
}

public class ClassEx001 {
	public static void main(String[] args) {
		Student001 s1 = new Student001(); 
		//s1.info("first",100,100,90); //내가한거 - 출력
		s1.name = "first"; s1.kor = 100; s1.eng = 100; s1.math = 99;
		s1.info();
	}
}
/*
A1 a= new A1()
---------------------------------------------------------------[runtime data area]
[method: 정보, static, final :: 공용정보] Student001.class, ClassEx001.class >> public 붙은쪽이 우선실행
---------------------------------------------------------------
[heap:동적 영역]			|[stack:잠깐 빌리기]
1번지 s1{ }				←s1
						| main
---------------------------------------------------------------

*/