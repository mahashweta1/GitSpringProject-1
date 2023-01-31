package com.example.learnSB.cntrollers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learnSB.payload.ApiResponse;
//import com.example.learnSB.entities.User;
import com.example.learnSB.payload.userDto;
import com.example.learnSB.services.userService;

@RestController
@RequestMapping("api/users")
public class userController {

	@Autowired
	userService us;
	
	
	@PostMapping("/addUser")
	public ResponseEntity<userDto> createUser(@Valid @RequestBody userDto u){
		userDto user = us.createUser(u);
//		ResponseEntity.status(200).body(null);
// 		ResponseEntity.status(HttpStatus.OK).body(null);
		HttpHeaders header = new HttpHeaders();
		header.add("testHeader", "my test header");
		return new ResponseEntity<>(user, header, HttpStatus.OK);
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body(user).getHeaders(header);
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<userDto> updateUser(@RequestBody userDto u, @PathVariable int id){
		userDto u1 = us.updateUser(u, id);
		return ResponseEntity.status(201).body(u1);
	}
	
	@GetMapping(value = "/getUser/{id}")
	public ResponseEntity<?> getUserById(@PathVariable int id){
		userDto u = us.getUserById(id);
		return ResponseEntity.status(200).body(u);
	}
	@GetMapping("/getUsers")
	public ResponseEntity<?> getUsers(){
		List<userDto> userDtoList = us.getUsers();
		if(userDtoList == null) {
			return ResponseEntity.status(404).body(null);
		}
		return ResponseEntity.status(200).body(userDtoList);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable int id){
		us.deleteUser(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted", false), HttpStatus.OK);
//		return ResponseEntity.status(200).body(Map.of("message", "User Deleted Successfully"));
	}
}
