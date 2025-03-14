package com.company.java016;

import java.awt.Toolkit;

//프로세스 : 실행중인 프로그램
// 1) 상속, Runnable 2) run() 해야할일 3) start() 실행 // 우클릭 -> source -> Override

class PigSound extends Thread {// #1. 상속 Thread (작업수행클래스)

	@Override
	public void run() { // #2. run() 해야할일
		try{Thread.sleep(10);}catch (Exception e) {e.printStackTrace();}
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i =0; i<5; i++){
			//toolkit.beep();
			System.out.println("꿀");
			try{Thread.sleep(1000);}catch (Exception e) { e.printStackTrace(); }	
		}}
}

class PigCount extends Thread{

	@Override
	public void run() {
		for(int i = 0; i<5; i++) {
			System.out.println(i+"마리");
			try{Thread.sleep(1000);}catch (Exception e) { e.printStackTrace(); }	
	}}
	
}
	


public class Thread002 {
	public static void main(String[] args) {// 1개의 스레드
		//여러가지 일을 동시에
		
		// 작업스래드 # 3단계
		Thread count = new PigCount(); count.start();
		Thread sound = new PigSound(); sound.start();
		//˙Ꙫ˙ 5번
		for(int i =0; i<5; i++) {
			System.out.println("˙Ꙫ˙");
			try{Thread.sleep(1000);}catch (Exception e) { e.printStackTrace(); }	
		}
		
		
	}// E.M
}// E.C
