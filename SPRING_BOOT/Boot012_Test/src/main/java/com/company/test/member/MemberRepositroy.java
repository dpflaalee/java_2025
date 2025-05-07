package com.company.test.member;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MemberRepositroy  extends JpaRepository<Member, Long>{
	Optional<Member> findByUsername(String username);
	
	@Modifying @Transactional
	@Query("update Member m set m.password=:password where m.id=:id and m.password=:old")
	int updateByIdAndPassword(String password, String old, Long id);
	
	@Query("select m from Member m order by id desc")
	List <Member> findAllByOrderByIddesc();
	
	@Modifying @Transactional
	@Query("delete from Member m where m.id=:id and m.password=:password")
	int deleteByIdAndPassword();
	
	//중복검사
	boolean existsByUsername(String username);
}
