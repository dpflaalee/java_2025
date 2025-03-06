package com.company.java011;
class Score{
	private String name;
	private int kor, eng, math;
	private int total;
	private double avg;
}
class ScoreDto extends Score{
	private String jang;
	private String Star;
	private String pass;
}
/////////////////////////////////////////////////////////////////
// Total 총점 / Avg 평균 / Jang 95이상 / Star 평균점수당 별 / Pass 60이상 합격
abstract class Process{ 
	abstract double exec(int kor, int eng, int math);
	abstract double exec(int total);
	abstract String exec(double avg);	}
class Total extends Process{
	@Override double exec(int kor, int eng, int math) { return 0; }

	@Override double exec(int total) { return 0; }

	@Override String exec(double avg) { return null; }				}
//class Avg extends Process{}
//class Jang extends Process{}
//class Star extends Process{}
//class Pass extends Process{}
/////////////////////////////////////////////////////////////////
abstract class Print{abstract void show(ScoreDto std); abstract void show(ScoreDto[]std);}
class StdPrint extends Print{
	@Override void show(ScoreDto std) {  }

	@Override void show(ScoreDto[] std) {  }
	}
/////////////////////////////////////////////////////////////////
public class AbstractEx001 {
	public static void main(String[] args) {
		//ScoreDto std = new ScoreDto("헐크", 100,100,99);
		Process process = null;
		Print print = null;
		//print = new StdPrint(); print.show(std);
	}
}
/*
출력화면
=======================================================
이름		국어		영어		수학		총점		평균			합격		장학생	랭킹
=======================================================
헐크		100		100		99		299		99.67		합격		장학생	별9


데이터를 input 클래스				데이터 처리					데이터 출력
Score							Process					Print
↑								↑						↑
ScoreDto	 			Total Avg Jang Star Pass		StdPrint
*/