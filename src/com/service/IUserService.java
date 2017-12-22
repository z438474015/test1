package com.service;

import java.util.List;

import com.entity.UserEntity;

public interface IUserService {

	void addUser(UserEntity u);
	void deleteUser(String id);
	void updateUser(UserEntity u);
	List<UserEntity> findAll();
	UserEntity findById(String id);
	UserEntity login(UserEntity u);
}
