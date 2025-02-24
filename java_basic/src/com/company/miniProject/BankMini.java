package com.company.miniProject;

import java.util.HashMap;
import java.util.Scanner;

public class BankMini {
	public static void main(String[]args) {
		
		HashMap<String, String>NameMap = new HashMap<>();
		HashMap<String, String>PasswordMap = new HashMap<>();
		HashMap<String, String>AgeMap = new HashMap<>();
		HashMap<String, Integer>BalanceMap = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		PasswordMap.put("dff", "fff");
		BalanceMap.put("dff", 3000);
		
		String id=null, pass=null, name=null, age=null;
		int service, balance; char answer;
		
		for(;;) {
			//기본 출력창
			System.out.println("WELLCOME! (주)DOG&CAT_BANK");
			System.out.println("=====BANK=====\n*1. 추가\n*2. 조회\n*3. 입금\n*4. 출금\n*5. 삭제\n*9. 종료");
			System.out.print("입력>>>");
			service=sc.nextInt();
			
			if(service==9) {System.out.println("종료기능입니다."); break;}
			switch (service) {
			//1.추가 > 만약 서비스 번호가 1이라면, 아이디·비밀번호·나이·잔액 입력하여 변수에 저장
			case 1:
				System.out.print("이름:"); name=sc.next();
				
				System.out.print("아이디:"); id=sc.next();
				if(NameMap.containsKey(id)) {System.out.println("사용중인 아이디"); continue;}
				
				System.out.print("비밀번호:"); pass=sc.next();
				
				System.out.print("나이:"); age=sc.next();
				
				System.out.print("잔액:"); balance=sc.nextInt();
				
				PasswordMap.put(id, pass);
				NameMap.put(id, name);
				AgeMap.put(id, age);
				BalanceMap.put(id, balance);
				break;
								
			//2.조회  
			case 2:
				System.out.print("ID:"); id=sc.next();
				System.out.print("PW:"); pass=sc.next();
//				if(PasswordMap.get(id).equals(pass)) {
//					//일치 시 출력 ===계좌조회 id/pass/나이/잔액
//					System.out.println("===계좌조회");
//					System.out.println("ID:"+id+"\nPW:"+pass+"\n나이"+AgeMap.get(id)+"\n잔액:"+BalanceMap.get(id));
//				}else {System.out.println("일치하지 않는 회원정보입니다."); continue;}
				//이렇게 적용하면 아예 가입하지 않은 회원이 조회했을 때 오류 발생함 >> 해결책:containsKey를 사용하여 조건 하나 더 추가! 
				
				//1. 아이디가 존재하는지 조회
				if(PasswordMap.containsKey(id)==false) {System.out.println("존재하지 않는 회원입니다.");}
				//2. 아이디와 비밀번호가 일치하는지 조회
				//2-1. 불일치 시 다시 확인하라는 문구 출력
				else if(PasswordMap.get(id).equals(pass)==false) {System.out.println("일치하지 않는 회원정보입니다."); continue;}
				//2-2. 일치 시 정보 조회
				else if(PasswordMap.get(id).equals(pass)) {
					System.out.println("===계좌조회");
					System.out.println("ID:"+id+"\nPW:"+pass+"\n나이"+AgeMap.get(id)+"\n잔액:"+BalanceMap.get(id));
				}
				
				break;
				
			//입금
			case 3:
				System.out.print("ID:"); id=sc.next();
				System.out.print("PW:"); pass=sc.next();
				if(PasswordMap.containsKey(id)==false) {System.out.println("존재하지 않는 회원입니다.");}
				else if(PasswordMap.get(id).equals(pass)) {
					//일치 시 입금창 출력
					System.out.print("입금액:"); balance=sc.nextInt();
					//입금창에 추가...
					BalanceMap.put(id, BalanceMap.get(id)+balance);
					//최종 출력 ===입금완료 잔액 
					System.out.println("===입금완료");
					System.out.println("잔액:"+BalanceMap.get(id));
				}else {System.out.println("일치하지 않는 회원정보입니다."); continue;}
				break;
				
			//출금
			case 4 :
				System.out.print("ID:"); id=sc.next();
				System.out.print("PW:"); pass=sc.next();
				if(PasswordMap.containsKey(id)==false) {System.out.println("존재하지 않는 회원입니다.");}
				else if(PasswordMap.get(id).equals(pass)) {
					//일치 시 출금창 출력
					System.out.println("출금액:"); balance = sc.nextInt();
					//BalanceMap에 변동값 반영
					BalanceMap.put(id,BalanceMap.get(id)-balance);
					//최종 출력 ===출금완료 잔액:
					System.out.println("===출금완료");
					System.out.println("잔액:"+BalanceMap.get(id));
				}else {System.out.println("일치하지 않는 회원정보입니다.");continue;}
				break; //end case4
				
			//삭제
			case 5 : 
				//아이디 패스워드 입력
				System.out.print("ID:"); id=sc.next();
				System.out.print("PW:"); pass=sc.next();
				if(PasswordMap.containsKey(id)==false) {System.out.println("존재하지 않는 회원입니다.");}
				else if(PasswordMap.get(id).equals(pass)) {
					//일치 시 확인 문구 출력
					System.out.println("계좌를 삭제하시겠습니까? (Y/N)>"); answer = sc.next().charAt(0);
					if(answer=='y'|| answer=='Y') {
						//정보 삭제, 탈퇴 완료 메세지 출력
						NameMap.remove(id);
						PasswordMap.remove(id);
						AgeMap.remove(id);
						BalanceMap.remove(id);
						System.out.println("탈퇴처리가 완료되었습니다.");
					}
					else {System.out.println("취소되었습니다.");}
					
					
				}else {System.out.println("일치하지 않는 회원정보입니다.");continue;}
				break;//end case5
				
			}//end switch
			
		}//end for		
		sc.close();
		
		
	}//end main
}//end class



/*
* 기본 출력창
WELLCOME! (주)CODEJOHNS_BANK
=====BANK=====
 *1. 추가
 *2. 조회
 *3. 입금
 *4. 출금
 *5. 삭제
 *9. 종료

 *입력>>> ( 서비스 번호 입력 ) 

* 1.추가 - 계좌 추가
	아이디 입력:
	비밀번호 입력:
	나이 입력:
	잔액 입력:
	>>입력된 값은 이후 서비스에 다 쓰이기 때문에, 저장되어야 함
	
* 2.조회 - 계좌 조회
 	id : 
 	pass : 
 	>>불일치 시 "다시 확인해주세요" 출력
 	>>일치 시 
 	==계좌조회
 	ID / PASS / 나이 / 잔액 출력 
 	
 * 3.입금
 	id : 
 	pass : 
 	입금액 : 
 	==입금완료
 	잔액 : 초기설정값+입금액
 	
 * 4.출금
 	id : 
 	pass : 
 	출금액 : 
 	==출금완료
 	잔액 : 잔액-출금값
 	
 * 5.삭제 - 계좌 삭제
 	id : 
 	pass : 
 	계좌를 삭제하시겠습니까? (Y/N) : 
 	N입력 시 > 별다른 출력 없이 종료
 	Y입력 시 > `` + 이후 타 서비스 선택하고 로그인 시도 하면 "다시 확인해주세요" 출력

 * 9.종료
	"종료기능 입니다."
*/