package com.company.java008_ex;

class Score{
	String stdid; int kor,eng,math,total,avg; 
	void total(){total=kor+eng+math;} //총점구하기
	void avg(){avg=total/3;} //평균구하기
	void info(){
		total(); //메서드 안에서 메서드 호출가능
		System.out.println("\n학번"+"\tkor"+"\teng"+"\tmath"+"\t총점"+"\t평균");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f",stdid,kor,eng,math,total,total/3.0);
	} //정보출력
	
	public Score(String stdid, int kor, int eng, int math){ this.stdid = stdid;	this.kor = kor;	this.eng = eng;	this.math = math;	}
	Score(){}
	
}//end score
public class ClassEx006 {
	public static void main(String[] args) {
		Score  s1= new Score("std1234", 100, 100, 99 ); 
		s1.info();
		Score s2 = new Score("std1111", 80, 80, 80);
		s2.info();

	}
}
/*
-- 생성자 작성하시오.
class Score{
   //상태-멤버변수  :  String stdid; int kor,eng,math,total,avg;   
   //행위-멤버함수  :  void total() 총점구해주기
   //               void avg()  평균구하기
   //                      void info()   학생정보출력   
}
public class ClassEx005{
   public static void main(String[] args) {
   Score  s1= new Score("std1234" , 100, 100 , 99 ); 
   s1.info();
   }
}

출력내용 :
학번   kor   eng   math   total   avg
std1234   100   100   99   299   99.67 				*/