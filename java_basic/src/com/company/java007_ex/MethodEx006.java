package com.company.java007_ex;

import java.util.Arrays;
import java.util.Scanner;

public class MethodEx006 {

	public static void who_are_you(String [][] users) {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력하세요: ");
		String id = sc.next();
		// id에 입력받은 값이... 배열의... 0번값이랑 동일한지 확인하고 동일하면 2번값을 출력
		//만약 id.equals(users[0][i]) 맞으면 출력 : users[0][i2]
		for(int i=0; i<users.length; i++) {if (id.equals(users[i][0])) {System.out.println(users[i][2]);}}
	}
	
	public static void who_pass_change(String [][] users) {
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력하세요: "); String temp_id = sc.next();
		System.out.println("비밀번호를 입력하세요: "); String temp_pw = sc.next();
		
		//id/pw 모두 일치 시 비번변경 출력-변경
		for(int i=0; i<users.length; i++) {
			if(temp_id.equals(users[i][0])&&temp_pw.equals(users[i][1])) {
				System.out.print("새 비밀번호를 입력하세요:"); String pwNew = sc.next();
				users[i][1]=pwNew;
			}
		}
		
	}
	
	///////////////////////////////////
public static void main(String[] args) {
		String [][] users = {
								{"aaa","111","한국"}, //00 01 02
								{"bbb","222","호주"}, //10 11 12
								{"ccc","333","중국"}	//20 21 22
							};
		
		//who_are_you(users);
		who_pass_change(users); 
		System.out.print(Arrays.deepToString(users));
		
	}//main
	///////////////////////////////////
	
}//class
/*
// 변수
String [][] users = {{ "aaa"  , "111"   , "한국"     } ,     // 00 01 02
                    { "bbb" , "222"   , "호주"       } ,       // 10 11 12
                    { "ccc"  , "333"   , "중국"      }};      // 20 21 22
// 입력
who_are_you(users);    
//  public static void who_are_you(String [][] users){  아이디를 입력받아서 나라 조회 }
who_pass_change(users); 
//  public static void who_pass_change(String [][] users){ 아이디,비밀번호가 맞으면 비밀번호 바꾸기}
}
*/