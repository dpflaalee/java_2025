package com.company.service;

import java.util.List;

import com.company.dao.MyDao;
import com.company.dto.UserDto;

@MyDao
public interface UserService {
	public int insert(UserDto dto);
	public int update(UserDto dto);
	public int delete(int no);
	public UserDto selectOne(int no);
	public List<UserDto> selectAll();
	
}
