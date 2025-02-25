package com.company.miniProject;

import java.util.HashMap;
import java.util.Scanner;

public class BankMini_re1 {
	//HashMap 이름 소문자로
	//continue 보다는 break 필요없는 구간은 삭제할 수 있도록 확인
	//변수...는 그때그때 선언하고 삭제하는걸로?
	//입금 / 출금 시 마이너스 불가능하게
	public static void main(String[] args) {
		HashMap<String, String>pwmap = new HashMap<>();
		HashMap<String, String>namemap = new HashMap<>();
		HashMap<String, String>agemap = new HashMap<>();
		HashMap<String, Integer>balancemap = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		
		for(;;) {
			//기본출력창
			System.out.println("WELLCOME! (주)DOG&CAT_BANK");
			System.out.println("=====BANK=====\n*1. 추가\n*2. 조회\n*3. 입금\n*4. 출금\n*5. 삭제\n*9. 종료");
			System.out.print("입력>>>");
			int service=sc.nextInt();
			
			//종료코드
			if(service==9) {System.out.println("종료 기능입니다."); break;}
			
			switch( service ) {
			case 1 : // 1. 추가 :: 아이디·비밀번호·나이·잔액 입력하여 변수에 저장
				System.out.print("이름: "); String name = sc.next();
				System.out.print("아이디: "); String id = sc.next();
				//사용중인 아이디일 경우 사용불가 경고창
				if(namemap.containsKey(id)) {System.out.println("사용중인 아이디입니다"); break;}
				System.out.print("비밀번호: "); String pw = sc.next();
				System.out.print("나이: "); String age = sc.next();
				System.out.print("잔액: "); int balance = sc.nextInt();
				//마이너스 금액 입력 불가능하게?
				if(balance<0) {System.out.println("입력값을 다시 확인해주세요."); break;}
				
				pwmap.put(id, pw);
				namemap.put(id, name);
				agemap.put(id, age);
				balancemap.put(id, balance);
				break; //end case1 
				
			case 2 : //조회
				System.out.print("ID: "); id = sc.next();
				System.out.print("PW: "); pw = sc.next();
				//1. 아이디 존재여부 확인 2. 일치/불일치 확인 3. 일치 시 출력 불일치 시 확인문구
				if(!pwmap.containsKey(id)) {System.out.println("존재하지 않는 회원입니다.");}
				else if(pwmap.get(id).equals(pw)) {
					System.out.println("===계좌조회");
					System.out.println("ID:"+id+"\nPW:"+pw+"\n나이:"+agemap.get(id)+"\n잔액:"+balancemap.get(id));
				}else {System.out.println("회원정보가 일치하지 않습니다.");}
				break; // end case2
			
			case 3 : //입금 >> 마이너스 입금 불가능하게
				System.out.print("ID: "); id = sc.next();
				System.out.print("PW: "); pw = sc.next();
				//1. 아이디 존재여부 확인 2. 일치 불일치 확인 
				//3. 일치 시 입금창 출력 > 마이너스 입금 시 경고문 || 입금 후 잔액 출력
				if(!pwmap.containsKey(id)) {System.out.println("존재하지 않는 회원입니다.");}
				else if (pwmap.get(id).equals(pw)) {
					System.out.print("입금액: "); balance = sc.nextInt();
					if(balance<0) {System.out.println("잘못된 입력값입니다.");}
					else {
						balancemap.put(id, balancemap.get(id)+balance);
						System.out.println("===입금완료");
						System.out.println("잔액"+balancemap.get(id));}					}
				else {System.out.println("회원정보가 일치하지 않습니다.");}
				break; //end case 3
				
			case 4 : //출금 >> 잔액보다 큰 금액 출금 불가능하게
				System.out.print("ID: "); id = sc.next();
				System.out.print("PW: "); pw = sc.next();
				// 1. 회원여부 확인 2. 일치불일치 확인
				// 3. 일치시 출금창 출력 > 잔액보다 큰 금액 인출 불가능 || 출금 후 잔액 출력
				if(!pwmap.containsKey(id)) {System.out.println("존재하지 않는 회원입니다.");}
				else if(pwmap.get(id).equals(pw)) {
					System.out.print("출금액: "); balance = sc.nextInt();
					if(balancemap.get(id)<balance) {System.out.println("잔액이 부족합니다.");}
					else {
						balancemap.put(id, balancemap.get(id)-balance);
						System.out.println("===출금완료");
						System.out.println("잔액: "+balancemap.get(id));
					}
				}
				else {System.out.println("회원정보가 일치하지 않습니다.");}
				break; //end case 4
				
			case 5: //정보 삭제
				System.out.print("ID: "); id = sc.next();
				System.out.print("PW: "); pw = sc.next();
				// 1. 회원여부 확인 2. 일치불일치 확인
				// 3. 일치 시 계좌를 삭제하시겠습니까? (Y/N) N:취소되었습니다 Y:처리 완료되었습니다
				if(!pwmap.containsKey(id)) {System.out.println("존재하지 않는 회원입니다.");}
				else if(pwmap.get(id).equals(pw)) {
					System.out.print("계좌를 삭제하시겠습니까?(Y/N): "); char answer = sc.next().charAt(0);
					if(answer=='y' || answer=='Y') {
						pwmap.remove(id);
						namemap.remove(id);
						agemap.remove(id);
						balancemap.remove(id);
						System.out.println("계좌가 삭제되었습니다.");}
					else if (answer=='n'||answer=='N') {System.out.println("취소되었습니다.");}
					else {System.out.println("잘못된 입력값입니다.");}
				}
				else {System.out.println("회원정보가 일치하지 않습니다.");}
				break; // end case 5
			
			}//end switch
		}//end for
		
		
	}//end main
}//end class
