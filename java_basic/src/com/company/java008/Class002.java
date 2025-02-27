package com.company.java008;
//1. 클래스는 부품객체이다
//2. 클래스는 속성(멤버변수)과 행위(멤버함수)를 포함함
class Anima1002{
	//속성 멤버변수
	String name; int age;
	//행위 멤버함수
	void show() {System.out.println(this.name+"\t"+this.age);} //this : 그 주소가 가지고 있는 .변수
}


public class Class002 {
	public static void main(String[] args) {
		Anima1002 a1 = new Anima1002(); a1.show(); 
		//1.new(공간,객체생성) 2. Animal002() 초기화 3. a1주소 0 = 1번지
		
		Anima1002 a2 = new Anima1002(); a2.show(); 
		//1.new(공간,객체생성) 2. Animal002() 초기화 3. a2주소 0 = 2번지
		
	}
}
/*
A1 a= new A1()
---------------------------------------------------------------[runtime data area]
[method: 정보, static, final :: 공용정보] A1.class, public Class001.class
---------------------------------------------------------------
[heap:동적 영역]			|[stack:잠깐 빌리기]
1번지 {name=null age=0}			←a1:1번지 this
2번지 {name=zzang age=13} 		←a2:2번지 this
						| main
---------------------------------------------------------------

*/