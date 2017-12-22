package com.dao;

import java.util.List;

import com.entity.UserEntity;

public interface IUserDao {

	void addUser(UserEntity u);
	void deleteUser(String id);
	void updateUser(UserEntity u);
	List<UserEntity> findAll();
	UserEntity findById(String id);
	UserEntity login(UserEntity u);
}
