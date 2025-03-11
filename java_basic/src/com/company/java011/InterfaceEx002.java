package com.company.java011;
/*
			Vehicle
			↑		↑
	MotorCycle 		Car
*/

interface Vehicle{ public void run(); }

class MotorCycle implements Vehicle{
 @Override public void run() { System.out.println("오토바이가 달립니다."); } 
}

class Car implements Vehicle{
	 @Override public void run() { System.out.println("자동차가 달립니다.");  } 
	}

class Driver{
	void drive(Vehicle v) {v.run();}
}

public class InterfaceEx002 {
	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Car car = new Car();
		MotorCycle mo = new MotorCycle();
		//리턴값 메서드명 (파라미터)
		driver.drive(car); 
		driver.drive(mo);
	}
}
/*
-----------------------------------------------------
[method : 정보] Vehicle.class , MotorCycle , Car, Driver , public InterfaceEx003  //##1 설계도
-----------------------------------------------------
[heap : 동적]               | [stacks: 지역]

3번지      MotorCycle{run}    ← mo     3번지 
2번지      Car    {run}        ← car    2번지
1번지      Driver {drive}      ← driver 1번지
                     | main  //##2
-----------------------------------------------------
*/