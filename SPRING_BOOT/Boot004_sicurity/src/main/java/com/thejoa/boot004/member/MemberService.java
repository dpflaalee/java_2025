package com.thejoa.boot004.member;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class MemberService {
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	
	//insert
	public Member insertMember(Member member) {
		member.setPassword(passwordEncoder.encode(member.getPassword())); 
		//세팅               암호화                   비밀번호
		return memberRepository.save(member);}
	
	//select all
	public List<Member> selectMemberAll(){
		return memberRepository.findAll();	}
	
	//select
	public Member selectMember(Long id) {
		return memberRepository.findById(id).get();	}
	
	//update / updatePass
	public int updateByPass(Member member, String old) {
		return memberRepository.updateByIdAndPassword(member.getPassword(), old, member.getId());	}
	
	public Member updateByEmail(Member member) {
		Member find = memberRepository.findById(member.getId()).get();
		find.setEmail(member.getEmail());
		return memberRepository.save(find);}
		
	//delete
	public void deleteMember(Long id) {
		Member find = memberRepository.findById(id).get();
		memberRepository.delete(find);
	}
}
