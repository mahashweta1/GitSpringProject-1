package com.example.learnSB.services.imple;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learnSB.entities.User;
import com.example.learnSB.exceptions.ResourceNotFoundException;
import com.example.learnSB.payload.userDto;
import com.example.learnSB.repositories.userRepo;
import com.example.learnSB.services.userService;

@Service
public class userServiceImple implements userService {
	
	@Autowired
	userRepo ur;
	
	@Autowired
	public ModelMapper getModalMapper;

	@Override
	public userDto createUser(userDto u) {
		User user = ur.save(this.userDtoToUser(u));
		return this.userTouserDto(user);
	}

	@Override
	public userDto updateUser(userDto u, int userId) throws ResourceNotFoundException  {
		User u1 = ur.findById(userId).orElseThrow(() -> new ResourceNotFoundException(404, "Resource Not Found", userId));
		u1.setEmail(u.getEmail());
		u1.setPassword(u.getPassword());
		u1.setUser_id(u.getUser_id());
		u1.setUser_name(u.getUser_name());
		User savedUser = ur.save(u1);
		return this.userTouserDto(savedUser);
	}

	@Override
	public userDto getUserById(int userId) throws ResourceNotFoundException {
		User user = ur.findById(userId).orElseThrow(() -> new ResourceNotFoundException(404, "Resource Not Found", userId));
		return this.userTouserDto(user);
	}
	@Override
	public List<userDto> getUsers(){
		List<User> userList = ur.findAll();
		List<userDto> userDtoList = userList.stream().map(u -> this.userTouserDto(u)).collect(Collectors.toList());
		if(userDtoList ==  null) {
			return null;
		}
		return userDtoList;
	}

	@Override
	public void deleteUser(int uid) throws ResourceNotFoundException{
		User user = ur.findById(uid).orElseThrow(() -> new ResourceNotFoundException(404, "Resource Not Found", uid));
		ur.delete(user);
	}
	
	public userDto userTouserDto(User u) {
		userDto dto = this.getModalMapper.map(u, userDto.class);
		return dto;
	}
	
	public User userDtoToUser(userDto u) {
		User user = this.getModalMapper.map(u, User.class);
		return user;
	}

}
