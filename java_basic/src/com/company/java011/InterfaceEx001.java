package com.company.java011;
interface Board{String PAN = "게시판"; public void exec();}
class BoardInsert implements Board{
	@Override public void exec() { System.out.println(PAN+" 삽입기능입니다."); }
}
class BoardDelete implements Board{
	@Override public void exec() { System.out.println(PAN+" 삭제기능입니다."); }
}
class BoardSelect implements Board{
 @Override public void exec() { System.out.println(PAN+" 선택기능입니다."); }
}
class BoardUpdate implements Board{
 @Override public void exec() { System.out.println(PAN+" 수정기능입니다."); } 
}

public class InterfaceEx001 {
	public static void main(String[] args) {
		Board board = null;
		board = new BoardInsert(); board.exec();
		board = new BoardDelete(); board.exec();
		board = new BoardSelect(); board.exec();
		board = new BoardUpdate(); board.exec();
	}
}
/*게시판
삽입기능 입니다.
삭제기능 입니다.
선택기능 입니다.
수정기능 입니다.
*/