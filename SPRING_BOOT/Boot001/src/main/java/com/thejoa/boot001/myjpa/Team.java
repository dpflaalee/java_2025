package com.thejoa.boot001.myjpa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Team {
	@Id // 기본키
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 숫자자동증가
	private Long id;
	private String name;
	
	@Column(updatable = false) // 수정못하게
	private LocalDateTime createDate=LocalDateTime.now();
	
	//@Transient // 칼럼 인식못하게
	//private String eamil;
	
	@OneToMany
	List<Member> user = new ArrayList<>(); // 팀은 많은 멤버를 가진다

}

/*
관계1 팀은 많은 멤버를 가진다
멤버는 하나의 팀을 가진다

team - | -------------- ∈ member
*/
