package com.company.java013_ex;

class MilkPrint{
	void show(Milk[] milks) {
//		System.out.println(Arrays.toString(milks));
		for(int i=0; i<milks.length; i++) {
		System.out.println(milks[i].getName()+"/"+milks[i].getPrice());
		}
	}
}
public class RepeatClass002 {
	public static void main(String[] args) {
		Milk []milks = new Milk[3];   
		milks[0] = new Milk("white",1000);
		milks[1] = new Milk("choco",1200);
		milks[2] = new Milk("banana",1500);
		
		MilkPrint  print = new MilkPrint();   
		print.show(  milks     );	
		// 출력된 결과 : 
//		 * white  / 1000
//		 * choco  / 1200
//		 * banana / 1500 
	}
}
//MilkPrint 클래스를 구현하시오 