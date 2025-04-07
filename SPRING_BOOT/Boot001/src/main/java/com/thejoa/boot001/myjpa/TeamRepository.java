package com.thejoa.boot001.myjpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long>{
	//JpaRepository<Team, Long> 테이블, 기본값자료형
}
/*
 * crud1. insert into team (name) values ('milk')
 * crud2. select-*from team / select*from team / select*froma where id=:\?
 * crud3. 
 * crud4. delete*from del=
 */