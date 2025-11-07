package com.example.user_service.service;

import org.springframework.stereotype.Service;

import com.example.user_service.config.UserErrorMessagePropertySource;
import com.example.user_service.dto.UserDto;
import com.example.user_service.excption.UserNotFoundException;
import com.example.user_service.repository.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	private final UserMapper userMapper;
	private final UserErrorMessagePropertySource userErrorMessagePropertySource;

	@Override
	public UserDto getUser(String id) {
		UserDto user = userMapper.findUserById(id);
		
		if(user == null) {
			 throw new UserNotFoundException(userErrorMessagePropertySource.getUserNotFoundMessage());
		}
		
		return userMapper.findUserById(id);
	}

}
