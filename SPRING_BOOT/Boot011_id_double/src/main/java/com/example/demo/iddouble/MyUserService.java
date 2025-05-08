package com.example.demo.iddouble;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyUserService {
	private final MyUserRepository myUserRepository;
	public MyUser insertUser(MyUser myUser) {return myUserRepository.save(myUser);}
	
	public MyUser selectUserName(String username) {
		return myUserRepository.findByUsername(username).get();
	}
	
	public MyUser selectUserEmail(String email) {
		return myUserRepository.findByUsername(email).get();
		
	}
}
