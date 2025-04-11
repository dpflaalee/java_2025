package com.thejoa.boot001;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thejoa.boot001.myjpa.Member;
import com.thejoa.boot001.myjpa.Team;
import com.thejoa.boot001.myjpa.TeamRepository;
import com.thejoa.boot001.myjpa.UserRepository;

@SpringBootTest
class Test002_user {
/*	@Autowired TeamRepository  teamRepository;
	@Autowired UserRepository userRepository;
	
	@Disabled //@Test
	public void insert() {
		Team team = new Team();
		team.setId(1L);
		
		Member user = new Member();
		user.setName("third");
		user.setAge(33);
		user.setTeam(team);
		userRepository.save(user);
	}
	
	//findAll 출력
	@Test
	public void selectAll() {
		List<Member> list = userRepository.findAll();
		for(Member u:list) {System.out.println(u.getName());}
	}
	
	//update로 1L 데이터값 수정
	@Disabled //@Test
	public void update() {
		Optional<Member> findUser = userRepository.findById(4L);
		System.out.println(findUser.isPresent());
		
		Member user = findUser.get();
		user.setName("Didi");
		userRepository.save(user);
	}
	
	
	@Disabled //@Test
	public void delete() {
		Optional<Member> findUser = userRepository.findById(1L);
		Member user = findUser.get();
		userRepository.delete(user);
	}
*/	
}
/*
+----------+--------------+------+-----+---------+----------------+
| Field    | Type         | Null | Key | Default | Extra          |
+----------+--------------+------+-----+---------+----------------+
| id       | bigint       | NO   | PRI | NULL    | auto_increment |
| age      | int          | NO   |     | NULL    |                |
| datetime | datetime(6)  | YES  |     | NULL    |                |
| name     | varchar(255) | YES  |     | NULL    |                |
| team_id  | bigint       | YES  | MUL | NULL    |                |
+----------+--------------+------+-----+---------+----------------+
*/