package com.company.java013;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Collection004_Map {
	public static void main(String[] args) {
		//  key		value
		Map<String, String> map = new HashMap<>();
		map.put("one", "하나");
		map.put("two", "둘");
		map.put("one", "셋"); //키값 동일하면 덮어씀
		map.put("three", "셋");
		
		System.out.println(map);
		System.out.println(map.get("one"));
		System.out.println(map.size());
		System.out.println(map.remove("three"));
		System.out.println(map.containsKey("one"));
		System.out.println(map.keySet()); // key 값만 모으기
		System.out.println(map.values()); // value 값만 모으기
		System.out.println(map.entrySet()); // key value 한번에
		
		//출력 - 향상된 for
//		for( Entry < String, String> e : map.entrySet() ){
//			System.out.println(e.getKey()+"/"+e.getValue);
//		}
		
		//iter ver1
		// key 모으기 > 처리대상확인 > 꺼내기
		Iterator<String> iter = map.keySet().iterator(); // iter> one, two
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(key+"/"+map.get(key));
		}
		
		//ver2
		Iterator <Entry <String, String>> eter = map.entrySet().iterator(); // iter>[one=셋, two=둘]
		while(eter.hasNext()) {
			Entry<String,String> temp=eter.next();
			System.out.println(temp.getKey()+temp.getValue());
			}
		
		
		
	}
}
