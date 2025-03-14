package com.company.java016;
//◖⚆ᴥ⚆◗
//프로세스 실행 중 프로그램 :: Thread + 자원
//작업수행클래스 1) Thread extends 2) Runnable ## // run() 실행할 작업	-> start() 실행
class Animal{}
class DogSound extends Animal implements Runnable{// Runnable :: 다른걸 상속받아서 Thread 상속을 받지 못할 때
	
	@Override
	public void run() {
		//try {Thread.sleep(1000);}catch (Exception e) {e.printStackTrace();}
		for(int i=0; i<5; i++) {
			System.out.print("멍멍멍");
			try {Thread.sleep(1000);}catch (Exception e) {e.printStackTrace();}		}
	} 
	
}//E.D

public class Thread003_Runnable {
	public static void main(String[] args) {
		Thread sound = new Thread(new DogSound()); sound.start();
		
		Thread count = new Thread( new Runnable() {  // 1. Runnable
			@Override public void run() { //2. runtodo 
				for(int i=1; i<6; i++) { 
					System.out.print(i+"마리");
					try {Thread.sleep(1000);}catch (Exception e) {e.printStackTrace();}
				}
			} 
		}); 
		count.start(); //3. start
		
		for(int i=0; i<5; i++) {
			System.out.print("◖⚆ᴥ⚆◗");
			try {Thread.sleep(1000);}catch (Exception e) {e.printStackTrace();}
		}
		
		
	}//E.M
}//E.C
