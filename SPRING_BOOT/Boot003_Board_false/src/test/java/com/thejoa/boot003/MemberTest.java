package com.thejoa.boot003;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thejoa.boot003.myjpa.Member;
import com.thejoa.boot003.myjpa.MemberRepository;

@SpringBootTest
public class MemberTest {
	@Autowired MemberRepository memberRepository;
	
	@Disabled //@Test
	public void insert() {
		Member member = new Member();
		member.setName("second");
		member.setAge(20);
		memberRepository.save(member);
	}
	
	@Disabled
	public void selectAll() {
		
	}
	
	@Disabled
	public void update() {
		Optional<Member> findMember = memberRepository.findById(1L);
		System.out.println(findMember.isPresent()); //존재확인
		Member member = findMember.get();
		member.setName(null);
		
		memberRepository.save(member);
	}
	
	@Disabled
	public void delete() {
		Optional<Member> findMember = memberRepository.findById(1L);
		Member member = findMember.get();
		memberRepository.delete(member);
	}
}
