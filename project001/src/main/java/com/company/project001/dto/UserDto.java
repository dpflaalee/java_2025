package com.company.project001.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor  // NonNull 필수 Constructor 만들때만 추가
public class UserDto {
	
	@NonNull private String userid;
	@NonNull private String pw;
	private char   enabled;
	
	private List<AuthDto> authList;
}
