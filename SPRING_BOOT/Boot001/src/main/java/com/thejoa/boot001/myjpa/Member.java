package com.thejoa.boot001.myjpa;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	//name="USERNAME" 필드명 수정 not null 설정
	//@Column(name="USERNAME", nullable = false) 
	//@Transiend 컬럼인식못하게
	private LocalDateTime datetime=LocalDateTime.now();
	private String name;
	private int age;
	
	/*
	 * @ManyToOne private Team team; // 멤버는 하나의 팀을 가진다. //team_id 컬럼 자동으로 생성
	 */	
	@ManyToMany(mappedBy = "members")
	private Set<ChatRoom> chatRooms = new HashSet<>();
	
}
/*
	관계1 팀은 많은 멤버를 가진다
	멤버는 하나의 팀을 가진다
	
	team - | -------------- ∈ member
*/