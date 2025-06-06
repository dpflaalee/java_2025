package com.thejoa.boot3.member;
//Enum file

import lombok.Getter;

@Getter
public enum MemberRole {

	ADMIN("ROLE_ADMIN"), MEMBER("ROLE_MEMBER");
	private String value;
	
	private MemberRole(String value) {this.value=value;}
	
}
