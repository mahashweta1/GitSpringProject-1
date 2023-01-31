package com.example.learnSB.cntrollers;

import java.util.List;

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

import com.example.learnSB.payload.categoryDto;
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
	
	
	@GetMapping("user/{userId}/post")
	public ResponseEntity<List<postDto>> findPostByUserId(@PathVariable Integer userId){
		List<postDto> postList = this.ps.getPostByUser(userId);
		return new ResponseEntity<List<postDto>>(postList, HttpStatus.OK);
		
	}
	
	@GetMapping("category/{categoryId}/post")
	public ResponseEntity<List<postDto>> findPostByCategoryId(@PathVariable Integer categoryId){
		System.out.println(categoryId	+ "----------------------------------------");
		List<postDto> postList = this.ps.getPostByCategory(categoryId);
		return new ResponseEntity<List<postDto>>(postList, HttpStatus.OK);
	}
	
//	@DeleteMappping("deletePost/{id}")
//	
//	@GetMapping("getAllPost")
	
	

}
