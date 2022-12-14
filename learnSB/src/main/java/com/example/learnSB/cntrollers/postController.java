package com.example.learnSB.cntrollers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learnSB.payload.postDto;
import com.example.learnSB.services.postService;

@RestController
@RequestMapping("api/posts")
public class postController {
	
	@Autowired
	postService ps;
	
	@GetMapping(value = "getPost/{id}")
	public ResponseEntity<postDto> getPostById(@PathVariable int id){
		postDto post = ps.getPostById(id);
		return new ResponseEntity<postDto>(post, HttpStatus.OK);
	}
	
	@PostMapping("user/{userId}/category/{categoryId}/post")
	public ResponseEntity<postDto> addPost(@Valid @RequestBody postDto post, 
			@PathVariable Integer userId,
			@PathVariable Integer categoryId){
		postDto newPost = ps.createPost(post, userId, categoryId);
		return new ResponseEntity<postDto>(newPost, HttpStatus.CREATED);
	}
	
//	@DeleteMappping("deletePost/{id}")
//	
//	@GetMapping("getAllPost")
	
	

}
