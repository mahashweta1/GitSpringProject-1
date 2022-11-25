package com.example.learnSB.services;

import java.util.List;
import com.example.learnSB.payload.userDto;


public interface userService {

	userDto createUser(userDto u);
	userDto updateUser(userDto u, int userId);
	userDto getUserById(int userId);
	List<userDto> getUsers();
	void deleteUser(int uid);
}
