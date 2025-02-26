package com.company.java007_ex;

import java.util.Scanner;

public class MethodEx004 {
	
	public static Integer process_total(int kor, int eng, int math) { return kor+eng+math; };
	public static float process_avg(int avg) {
		return avg/3f; };
	public static String process_pass(float avg , int kor, int eng, int math) {
		//평균이60이상이고, 각각 국어, 영어, 수학40이상 || 불합격/재시험-각각 40미만인게 있다면
		String pass = "";
		if(avg>=60 && kor>=40 && eng>=40 && math>=40) {pass = "합격";} 
		else if(avg<60) {pass = "불합격";} 
		else if(kor<40 || eng<40 || math<40) {pass = "재시험";}
		return pass;
	}
	public static String process_scholar(float avg) {
		String jang = "";
		if(avg>=95) {jang="장학생";}else {jang="----";}
		return jang;
	}
	public static String process_star(float avg) {
		String star="";
		int index = (int) (avg/10);
		for(int i=0; i<index; i++) { star+="*"; }
		return star;
		}
	public static void process_show(String name,int kor,int eng,int math,int total,float avg,String pass,String jang,String star) {
		System.out.print("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: \n");
		System.out.print("이름"+"\t"+"국어"+"\t"+"영어"+"\t"+"수학"+"\t"+"총점"+"\t"+"평균"+"\t"+"합격여부"+"\t"+"장학생"+"\t"+"랭킹\n");
		System.out.print("--------------------------------------------------------------------------------------------\n");
		System.out.print(name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+total+"\t"+avg+"\t"+pass+"\t"+jang+"\t"+star+"\n");
		System.out.print("--------------------------------------------------------------------------------------------");
	}
	
	
	//////////////////////////////////////////////
	public static void main(String[] args) {
	
		  ///////(1)  변수
	      String name  = ""; 
	      int kor, eng, math, total ;
	      float avg = 0.0f; 
	      String pass = "";
	      String jang = "";
	      String star= ""; 
	      Scanner scanner = new Scanner(System.in);
	      
	      ///////(2) 입력 : 이름, 국어, 영어, 수학점수를 입력받으시오.
	      System.out.print("이름: "); name = scanner.next(); 
	      System.out.print("국어: "); kor = scanner.nextInt(); 
	      System.out.print("영어: "); eng = scanner.nextInt(); 
	      System.out.print("수학:"); math = scanner.nextInt(); 
	   
	      ///////(3) 처리 : 
	      total = process_total(kor , eng, math);    // 1. 총점처리
	      avg = process_avg(total);    //2.  평균처리
     
	      pass = process_pass(avg , kor, eng, math);	///////3.  합격  평균이60이상이고, 각각 국어, 영어, 수학40이상/불합격/재시험-각각 40미만인게 있다면 
	      
	      jang = process_scholar(  avg  );	//////// 4. 평균이 95점이상이면 장학생
	      
	      star = process_star(avg);	//////// 5. 평균점수대로 별표 붙이기
	      //System.out.print("총점:"+total+"\t"+"평균:"+avg+"\t"+"합불합:"+pass+"\t"+"별"+star);
	      
	      process_show(name, kor, eng, math, total, avg, pass, jang, star);	///////(4) 출력
	      
	      scanner.close();
	//////////////////////////////////////////////
	}//end main
}//end class
/*
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
이름      국어   영어   수학   총점  평균    합격여부   장학생   랭킹
--------------------------------------------------------------------------------------------
아이언맨   100   100   100   300    100.0    합격      장학생   **********
--------------------------------------------------------------------------------------------
*/