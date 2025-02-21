package com.company.miniProject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Map {
	public static void main(String[] args) {
		/*
		 * HashMap을 사용하여 회원 정보 만들기, HashMap을 두개 만들어서 구성. 1. 회원등록 : id, password, name
		 * 3개의 정보를 등록함. id는 key로 password, name은 value로 지정 2. 회원검색 : id를 key로 사용 중이기 때문에
		 * id를 이용하여 회원정보 검색하여 출력 3. 회원삭제 : id를 key로 사용 중이기 때문에 id를 이용하여 회원정보 검색하여 삭제함.
		 * 4. 회원 모두 보기 : 모든 정보 출력 5. 비밀번호 수정 : id를 key로 사용 중이기 때문에 id를 이용하여 비밀번호 수정 6.
		 * 프로그램 종료 : 종료
		 */
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> map = new HashMap<>();
		HashMap<String, String> map2 = new HashMap<>();
		String id = null;
		String pass = null;
		String name = null;

		while (true) {
			System.out.println("회원 정보 입력 프로그램");
			System.out.println("\n1. 회원 등록");
			System.out.println("2. 회원 검색");
			System.out.println("3. 회원 삭제");
			System.out.println("4. 모든 회원 정보 보기");
			System.out.println("5. 비밀번호 수정");
			System.out.println("6. 프로그램 종료");
			System.out.print(">>> ");
			String select = sc.nextLine();

			switch (select) {

			case "1":
				System.out.println("회원등록을 진행합니다.");
				System.out.println("\n회원님의 이름을 입력해주세요.");
				System.out.print("이름 : ");
				name = sc.nextLine();

				System.out.println("회원님이 사용할 아이디를 입력해주세요.");
				System.out.print("ID : ");
				id = sc.nextLine();
				if (map.containsKey(id) == true) {
					System.out.println("사용중인 아이디입니다.");
					continue;
				}
				System.out.println("사용 가능한 아이디입니다.");
				System.out.println("\n회원님이 사용할 비밀번호를 입력해주세요.");
				System.out.print("PW : ");
				pass = sc.nextLine();

				map.put(id, pass);
				map2.put(id, name);
				System.out.println("등록 완료되었습니다.");
				System.out.println("회원님의 ID : " + id + " 입니다.");
				break;

			case "2":
				System.out.println("아이디로 회원님을 검색합니다.");
				System.out.println("\n회원님의 아이디를 입력해주세요.");
				System.out.print("ID : ");
				id = sc.nextLine();

				if (map.containsKey(id) == false) {
					System.out.println("검색하신 아이디는 없는 정보입니다.");
					continue;
				} else {
					System.out.println("회원님의 정보입니다.");
					System.out.println("ID : " + id + " / PW : " + map.get(id) + " / 이름 : " + map2.get(id) + " 입니다.");
				}
				break;

			case "3":
				System.out.println("아이디로 회원님을 검색합니다.");
				System.out.println("\n회원탈퇴할 아이디를 입력해주세요.");
				System.out.print("ID : ");
				id = sc.nextLine();

				if (map.containsKey(id) == false) {
					System.out.println("검색하신 아이디는 없는 정보입니다.");
					continue;
				} else {
					map.remove(id);
					map2.remove(id);
					System.out.println("회원탈퇴가 완료되었습니다. 이용해 주셔서 감사합니다.");
				}
				break;

			case "4":
				System.out.println("모든 회원 정보를 불러옵니다.");
				Iterator<String> itk = map.keySet().iterator();
				while (itk.hasNext()) {
					String key = itk.next();
					System.out.println("PW : " + map.get(key));
					System.out.println("이름 : " + map2.get(key));
				}
				break;

			case "5":
				System.out.println("현재 등록 되어있는 회원님의 아이디는 " + map.keySet() + "입니다.");
				System.out.println("\n아이디를 입력해주세요.");
				System.out.print("ID : ");
				id = sc.nextLine();
				if (map.containsKey(id) == false) {
					System.out.println("검색하신 아이디는 없는 정보입니다.");
					continue;
				} else {
					System.out.println("회원님의 이름을 입력해주세요.");
					System.out.print("이름 : ");
					name = sc.nextLine();
					System.out.println("\n회원님의 비밀번호를 입력해주세요.");
					System.out.print("PW : ");
					pass = sc.nextLine();
					map.put(id, pass);
					map2.put(id, name);
					// map.replace(); 기존 값을 추가하는 게 아닌 수정하는 거라면 가능함.
					System.out
							.println(id + " : " + map.get(id) + " / 이름 : " + map2.get(id) + " / 비밀번호 : " + map.get(id));
					System.out.println("수정되었습니다.");

				}
				break;

			case "6":
				System.out.println("종료합니다.");
				System.exit(0);

			default:
				System.out.println("메뉴 확인 후 다시 입력해 주세요.");

			}
			sc.close();
		}
	}
}

