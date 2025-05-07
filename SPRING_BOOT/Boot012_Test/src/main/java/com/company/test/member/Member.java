package com.company.test.member;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.company.test.board.Board;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)  
	private String username;
	private String password;
	
	@Column(unique = true) 
	private String email;

	@Column(updatable = false)
	private LocalDateTime udate=LocalDateTime.now();
	
	@OneToMany(mappedBy="member", fetch=FetchType.EAGER)
	List<Board> board = new ArrayList<>();
}
