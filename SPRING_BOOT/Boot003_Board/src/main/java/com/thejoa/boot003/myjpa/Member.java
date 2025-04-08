package com.thejoa.boot003.myjpa;

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
public class Member {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private int age;
	private String name;
	
	@Column(updatable = false)
	private LocalDateTime createDate=LocalDateTime.now();
	
	
	@OneToMany(mappedBy = "member")
	List<Board> board=new ArrayList<>();
}
