package com.company.test.member;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepositroy memberRepositroy;
	private final PasswordEncoder passwordEncoder;
	
	//insert
	public Member insertMember(Member member) {
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		return memberRepositroy.save(member);
	}
	
	//select-all, id
	public List<Member> selectMemberAll(){
		return memberRepositroy.findAll();
	}
	public Member selectMember(Long id) {
		return memberRepositroy.findById(id).get();
	}
	
	//update
	public int updateByPass(Member member, String old) {
		return memberRepositroy.updateByIdAndPassword(member.getPassword(), old, member.getId());
	}
	public Member updateByEmail (Member member) {
		Member find = memberRepositroy.findById(member.getId()).get();
		find.setEmail(member.getEmail());
		return memberRepositroy.save(find);
	}
	
	//delete
	public void deleteMember(Long id) {
		Member find = memberRepositroy.findById(id).get();
		memberRepositroy.delete(find);
	}
	
	//중복검사
	/*
	 * public Object overlay(String username) { return }
	 */
	public boolean isUsernameExist(String username) {
		return memberRepositroy.existsByUsername(username);
	}
	
}
