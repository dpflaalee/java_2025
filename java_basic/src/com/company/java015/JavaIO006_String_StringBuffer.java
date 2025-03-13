package com.company.java015;

public class JavaIO006_String_StringBuffer {
	public static void main(String[] args) {
		// String 문자열 누적
		String str = "ABC";
		System.out.println("String str의 주소"+str+" "+System.identityHashCode(str)); //주소925858445
		
		str += "D";
		System.out.println("String str의 주소"+str+" "+System.identityHashCode(str)); //주소989110044
		
		//StringBuffer 문자열 누적
		StringBuffer sb = new StringBuffer();
		sb.append("ABC");
		System.out.println("StringBuffer sb의 주소"+sb+" "+System.identityHashCode(sb)); //142257191
		
		sb.append("D");
		System.out.println("StringBuffer sb의 주소"+sb+" "+System.identityHashCode(sb)); //142257191
		
		//네트워크상에서 사용한다 하면... StringBuffer을 권장. 일반 String 문자열 누적은 계속해서 주소가 바뀌기 때문에 heap area 에 부하가 큼
		
	}//E.M
}//E.C
