package com.company.java008_ex;

import java.util.Scanner;

// class = 부품객체 :: 상태(멤버변수) 행위(멤버함수) 포함
// 생성자호출 초기화

class TV{
	//상태-멤버변수
	String channel; int volume;
	//행위-멤버함수 >> 채널과 볼륨을 입력-출력 input() / show() :: 함수
	void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("채널입력:"); this.channel = sc.next();
		System.out.print("볼륨입력:"); this.volume = sc.nextInt();
		System.out.println("\n");
		sc.close();
	}
	void show() {System.out.println(this.channel+"\t"+this.volume);}
	
	/*public*/ TV(String channel, int volume){this.channel=channel; this.volume=volume;}
	TV(){}//기본생성자:TV(){} :: 클래스명이 동일하고 아무것도 입력되지 않은상태 
	//컴파일러 TV() 기본 자동생성, 그러나 생성자를 개발자가 손대는순간 자동생성취소 :: 디폴트생성자를 먼저 만들고 시작하는게 좋음
}
//class TV2_ai extends TV{
//	TV2_ai(String channel, int volume) {
//		super(channel, volume);
//		// TODO Auto-generated constructor stub
//	}} 디폴트생성자를 만들지 않으면 사용할 수 없기 때문에 일단 킵

public class ClassEx004 {
	public static void main(String[] args) {
		TV t1 = new TV("MBC", 8); // 수동으로 만들면
		t1.show();
		TV t2= new TV();
		t2.input(); t2.show();
	}
}
