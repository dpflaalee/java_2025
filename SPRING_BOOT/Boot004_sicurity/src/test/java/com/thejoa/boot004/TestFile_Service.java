package com.thejoa.boot004;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thejoa.boot004.member.Member;
import com.thejoa.boot004.member.MemberRepository;
import com.thejoa.boot004.member.MemberService;

@SpringBootTest
class TestFile_Service {
	@Autowired MemberRepository memberRepository; 
	@Autowired MemberService memberService;

	/*
	insert update  >> save
	select         >> findAll findById
	delete         >> delete
	*/
	
	@Disabled 
	@Test
	void insert() {
		Member member = new Member();
		member.setPassword("t333");
		member.setUsername("third");
		member.setEmail("third@gmail.com");
		System.out.println(memberService.insertMember(member));
	}
	
	@Disabled 
	@Test void findAll() {
		List<Member> list = memberRepository.findAll();
		System.out.println(list);
	}
	
	@Disabled 
	@Test void findId() {
		System.out.println(memberRepository.findById(1L).get());
	}
	
	@Disabled 
	@Test void findUsername() {
		System.out.println(memberRepository.findByUsername("first").get());
	}
	
	@Disabled 
	@Test void update() {
		Optional<Member> findMember = memberRepository.findById(1L);
		if(findMember.isPresent()) {
			Member member = findMember.get();
			member.setUsername("one");
//			member.setEamil("one@gmail.com");
//			member.setPassword("o111");
			memberRepository.save(member);
		}
	}
	
	@Disabled 
	@Test void updatePassword() {
		memberRepository.updateByIdAndPassword("1234", "o111", 1L);
		
		/*		Optional<Member> findMember = memberRepository.findById(2L);
		if(findMember.isPresent()) { Member member = findMember.get(); member.setPassword("2222"); memberRepository.save(member); } */
	}

	@Disabled 
	@Test void delete() {
		Optional<Member> findMember = memberRepository.findById(3L);
		if(findMember.isPresent()) { Member member = findMember.get(); memberRepository.delete(member); }
	}
	
}
