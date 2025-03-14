package com.company.java016;

import java.util.Scanner;

class Count implements Runnable{

	@Override
	public void run() {
		for(int i=10; 0<=i; i--) {
			System.out.println(i);
			try { Thread.sleep(1000); }catch (InterruptedException e) { break; }
	} }
	
}

public class Thread004_Interrupted {
	public static void main(String[] args) {
		Thread count = new Thread(new QuestionCount()); count.start();
		
		Scanner sc = new Scanner (System.in);
		System.out.println("count stop? y/n");
		if(sc.next().equals("y")) {
			System.out.println("count 종료");
			count.interrupt();
		}
		System.out.println("main end...");
		sc.close();
	}
}
