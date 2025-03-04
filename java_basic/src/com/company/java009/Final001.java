package com.company.java009;
//final 변경하지마
//부품객체 (멤버변수 + 멤보함수_
//상속x 		상수 		Override X
//4.final class FinalEx extends Object 상속받지마
class FinalEx extends Object{ 
	// extends Object>생략가능 | 1.Object : 자바팀이 객체틀 만들어놓음!  2.extends : 상속(앞의 객체 그대로 사용)
	//
	//static String tree="4-5"; // 3.식목일-나무심는날
	final static String tree="4-5"; // 3-3.static, final 주로 같이 사용됨
	String name;
	final void show() {System.out.println(FinalEx.tree+"/"+name);}
}

class MyDate extends FinalEx{
	//@Override void show() {super.show();} //5. 오버라이드 자식클래스에서 메서드 재수정
}

public class Final001 {
	public static void main(String[] args) {
		//FinalEx.tree="4-6"; //3-2.static 공용... 아래에서 변경 가능 
							 //3-4.변경되면 안되는 값일 시 final 추가 cannot be assigned
		System.out.println("식목일(공유, 변경 불가 값):"+FinalEx.tree);
	}
}
