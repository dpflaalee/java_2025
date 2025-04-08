package com.thejoa.boot003.myjpa;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Board {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 200)
	private String btitle;
	
	@Column(columnDefinition = "text")
	private String bcontent;
	
	private String bfile;
	private String bip;
	private String bpass;
	private Long bhit=0L;
	
	@Column(updatable = false)
	private LocalDateTime createData = LocalDateTime.now();
	
	@ManyToOne private Member member;
}
