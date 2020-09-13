package com.nagappa.dao;

import java.util.List;

import com.nagappa.model.UserEntity;

public interface UserEntityDAO {

	public List<UserEntity> getUser(String username);
	public void updateUser(UserEntity user);
	public void deleteUser(UserEntity user);
}
