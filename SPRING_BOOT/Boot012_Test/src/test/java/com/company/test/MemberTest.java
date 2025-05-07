package com.company.test;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.test.member.Member;
import com.company.test.member.MemberRepositroy;
import com.company.test.member.MemberService;

@SpringBootTest
public class MemberTest {
	@Autowired MemberRepositroy memberRepositroy;
	@Autowired MemberService service;
	
	@Disabled @Test void insert2() { //암호화 확인
		Member member = new Member();
		member.setUsername("fitst");
		member.setEmail("first@com");
		member.setPassword("1111");
		System.out.println(service.insertMember(member));
	}
	
	@Disabled @Test void insert() {
		Member member = new Member();
		member.setUsername("fitst");
		member.setEmail("first@com");
		member.setPassword("1111");
		memberRepositroy.save(member);
	}
	@Disabled @Test void findAll() {
		List<Member> list = memberRepositroy.findAll();
		System.out.println(list);
	}
	@Disabled @Test void findId(){
		System.out.println(memberRepositroy.findById(1L).get());
	}
	
	@Disabled @Test void update() {
		Member member = memberRepositroy.findById(1L).get();
		member.setUsername("one");
		memberRepositroy.save(member);
	}
	@Disabled @Test void updatePass() {memberRepositroy.updateByIdAndPassword("1234", "1111", 1L);}
	@Disabled @Test void delete() {Member member = memberRepositroy.findById(1L).get(); memberRepositroy.delete(member);}
}
