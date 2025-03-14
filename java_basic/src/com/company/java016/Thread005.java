package com.company.java016;
/*
 	#
*/

class Rank{
	int num=0;
	public void plusnum() {//등수올리기
		int rank = num;
		try {Thread.sleep(1000);}catch(InterruptedException e) {e.printStackTrace();}
	}
}
//실행클래스
class  User extends Thread{
	Rank rank;
	public User(Rank rank) {this.rank=rank;}
	@Override
	public void run() {
		rank.plusnum();
		System.out.println(rank.num+"등"+super.getName()); // Thread
	}
	
}

public class Thread005 {
	public static void main(String[] args) {
		Rank rank = new Rank(); //공유자원 num=1 num=2 등수
		
		Thread user1 = new User(rank); user1.setName("sally"); user1.start();
		try {Thread.sleep(1000);} catch(InterruptedException e) {e.printStackTrace();}
		
		Thread user2 = new User(rank); user2.setName("siru"); user2.start();
		
	}
}
/*   synchronized  before)         
user1   →  [Rank : num    ]  ←  user2
first                     second
*/  
/*   synchronized  after)         
user1   →  [Rank : num    ]  ←  user2
first                     second
*/