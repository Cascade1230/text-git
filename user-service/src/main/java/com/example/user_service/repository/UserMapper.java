package com.example.user_service.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.user_service.dto.UserDto;

@Mapper
public interface UserMapper {
	UserDto findUserById(String id);
}
