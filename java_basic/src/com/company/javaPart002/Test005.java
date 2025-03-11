//넓>좁 접근자
//public protected package private
package com.company.javaPart002;
class Score{
  //데이터를 받아서 전달
  String name, pass;
  int kor, eng, math;
  double avg;
  //생성자
}

class ScoreProcess{
  //데이터를 받아 처리
  //생성자... 멤버함수
  public void process_avg(Score[]std){} //평균처리
  public void process_pass(Score[]std){} //합격처리 평균 60이상, 각 과목 40이상
}

class ScorePrint{
  //멤버함수 클래스한개 받아서 출력
  public void show(Score std){}
  //클래스배열을 받아서 출력
  public void show(Score[]std){}
  //타이틀 출력
  public void show_title(){}
}

public class Test005 {
  public static void main(String[] args) {
    Score[]std = new Score[3];
    std[0]= new Score("아이언맨",100,100,100);
    std[1]= new Score("헐크",90,60,80);
    std[2]= new Score("블랙팬서",20,60,90);

    ScoreProcess process = new ScoreProcess();
    process.process_avg(std);
    process.process_pass(std);

    ScorePrint print = new ScorePrint();
    print.show(std);
  }
}
