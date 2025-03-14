package com.company.java016;

import javax.swing.JOptionPane;

class QuestionCount implements Runnable{

	@Override
	public void run() {
		for(int i=10; 0<=i; i--) {
			System.out.println(i);
			try { Thread.sleep(1000); }catch (InterruptedException e) { break; }
	} }
	
}
public class ThreadEx001 {
	public static void main(String[] args) {
		
		Thread count = new Thread(new QuestionCount()); count.start();
		
		String answer = JOptionPane.showInputDialog("사과알파벳을 입력하세요");
		System.out.println(answer);
		
		if(answer.equals("apple")) {System.out.println("정답입니다"); count.interrupt(); } else {System.out.println("정답이 아닙니다"); count.interrupt();}
		System.out.println("main-end");
	}
}
/*
1. QuestionCount ==> 10부터 1까지 카운트하는 클래스 1초에 하나씩 

2. 사과알파벳을 입력하세요 ==> 알림창...
 	사과를 입력받으면 "정답입니다" // "정답이 아닙니다"

문제점: 입력해도 count 계속실행 + 메인 종료돼도 다른 프로세스 실행중 

*/