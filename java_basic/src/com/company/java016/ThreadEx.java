package com.company.java016;
//ʕ  -ᴥ-  ʔ
class Gawol implements Runnable{
	String [] arr = {"푸데데", "맹", "듀...","우리 친구지?","집에가고싶다","쿨...", "피곤하다"};
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			double random = Math.random();
			int num = (int)Math.round(random*(arr.length-1));
			System.out.println(arr[num]);
			try{Thread.sleep(1000);}catch(Exception e) {e.printStackTrace();}
		}
	}
	
}
public class ThreadEx {
	public static void main(String[] args) {
		Thread gawol = new Thread(new Gawol()); gawol.start();
		
		for(int i=0; i<5; i++) {
			System.out.print("ʕ  -ᴥ-  ʔ");
			try{Thread.sleep(1000);}catch(Exception e) {e.printStackTrace();}
		}
	}
}
