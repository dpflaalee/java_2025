package com.company.java005;

public class Repeat001_For {
	public static void main(String[]args) {
		//STEP1
		System.out.println("step1)");
		System.out.print(1+"\t"); //{} 		시작1
		System.out.print(2+"\t"); //{변수} 	변화1
		System.out.print(3+"\t"); //		종료3
		
		//STEP2
		System.out.println("\n\nstep2)");
		//{반복} {변수} 
		for(int i=1; i<=3; i++)
		{	System.out.print(i+"\t");	} System.out.println();
		
		for(int i=3; i<=8; i++)
		{	System.out.print(i+"\t");	} System.out.println();
		
		for(int i=1; i<=10; i++)
		{	System.out.print(i+"\t");	} System.out.println();
		
		for(int i=1; i<=5; i+=2)
		{	System.out.print(i+"\t");	}
		
		//STEP3
	}
}
