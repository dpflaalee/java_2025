package com.company.javaPart002;
//abstract vs interface

interface Vehicle1b{public void run();}
class MotorCycle1b implements Vehicle1b{
  @Override
  public void run() { System.out.println("오토바이가 달립니다."); }
  public void helmet(){System.out.println("헬멧을 착용합니다.");}
}
class Car1b implements Vehicle1b{
  @Override
  public void run() { System.out.println("자동차가 달립니다."); }
}

public class Test008 {
  public static void main(String[] args) {
    Driver1b driver1b = new Driver1b();
    MotorCycle1b MotorCycle1b = new MotorCycle1b();
    Car1b Car1b = new Car1b();

    driver1b.drive(Car1b);

    System.out.println("\n\n>>자동차가 고장나서 교통수단을 바꿉니다!");
    driver1b.drive(MotorCycle1b);
  }
}
