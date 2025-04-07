package com.thejoa.boot001;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thejoa.boot001.myjpa.Team;
import com.thejoa.boot001.myjpa.TeamRepository;
import com.thejoa.boot001.myjpa.User;
import com.thejoa.boot001.myjpa.UserRepository;

@SpringBootTest
class Boot001ApplicationTests {
	@Autowired TeamRepository  teamRepository;
	
	@Disabled //@Test
	void insert() {
		Team team = new Team();
		team.setName("caelus");
		teamRepository.save(team);
		//teamRepository sava ( insert update ) delete -delete
		//teamRepository.findAll select / teamRepository.findByUd Select
	}
	@Disabled //@Test 
	public void selectAll() {
		List<Team> list=  teamRepository.findAll();
		System.out.println(list.size());
		System.out.println(list.get(0).getName());	}
	@Disabled //@Test
	public void update() {
		//1. 수정할 팀찾기
		//Optional 있을수도 있고 없을수도 있고
		Optional<Team> findTeam = teamRepository.findById(1L);
		System.out.println(findTeam.isPresent()); // 존재합니까?
		//2. 이름 변경해서 수정
		Team team = findTeam.get();
		team.setName("choco");
		teamRepository.save(team); // save : insert, update
	}
	
	@Disabled //@Test
	public void delete() {
		Optional<Team> findTeam = teamRepository.findById(3L);
		System.out.println(findTeam.isPresent()); // 존재합니까?
		Team team = findTeam.get();
		teamRepository.delete(team);		}
	
}
