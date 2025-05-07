package com.company.test.board;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.company.test.member.Member;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Board {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 200)
	private String btitle;
	@Column(columnDefinition = "text")
	private String bcontent;
	private String bpass;
	
	private Long bhit = 0L;
	private String bip;
	
	@Column(updatable = false)
	private LocalDateTime create_date = LocalDateTime.now();
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID")
	private Member member;
}
