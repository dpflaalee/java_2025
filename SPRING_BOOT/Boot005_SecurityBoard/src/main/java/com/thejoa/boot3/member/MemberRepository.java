package com.thejoa.boot3.member;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MemberRepository extends JpaRepository<Member, Long> {

	Optional<Member>  findByUsername(String username);

	//update
	@Modifying @Transactional
	@Query("update from Member m set m.password=:password where m.id=:id and m.password=:old")
	int updateByIdAndPassword(String password, String old, Long id);
	
	//select all
	@Query("select m from Member m order by id desc")
	List<Member> findAllByOrderBydesc();
	
/*	//select
	
	//delete
	@Modifying @Transactional
	@Query("delete from Member m where m.id=:id and m.password=:password")
	int deleteByIdAndPassword();
*/	
}
/*
1. crud sql 구문만들기
insert into memeber (username, password, email) values (???) -- save
select*from member                                         --findAll
select*from memeber where id=?                             --findById
update member set email=?,username=?,password=? where id=? --save
delete from member where id=?

2. 아이디와 비번이 같은 유저의 비밀번호 변경
2-1 @Modifying @Transctional @Query
*/