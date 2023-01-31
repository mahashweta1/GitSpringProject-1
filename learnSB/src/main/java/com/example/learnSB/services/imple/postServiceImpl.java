package com.example.learnSB.services.imple;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learnSB.entities.Category;
import com.example.learnSB.entities.Post;
import com.example.learnSB.entities.User;
import com.example.learnSB.exceptions.ResourceNotFoundException;
import com.example.learnSB.payload.categoryDto;
import com.example.learnSB.payload.postDto;
import com.example.learnSB.payload.userDto;
import com.example.learnSB.repositories.categoryRepo;
import com.example.learnSB.repositories.postRepo;
import com.example.learnSB.repositories.userRepo;
import com.example.learnSB.services.categoryService;
import com.example.learnSB.services.postService;
import com.example.learnSB.services.userService;

@Service
public class postServiceImpl implements postService {
	
	@Autowired
	postRepo pr;
	
	@Autowired
	ModelMapper getModalMapper;
	
	@Autowired
	userRepo ur;
	
	@Autowired
	categoryRepo catRepo;
	
	@Autowired
	userService userSer;
	@Autowired
	categoryService catService;
	
	@Override
	public postDto createPost(postDto p, Integer userId, Integer catId) throws  ResourceNotFoundException{
		User user = this.ur.findById(userId).orElseThrow(() -> new ResourceNotFoundException(404, "Resource Not Found", userId));
		Category cat = this.catRepo.findById(catId).orElseThrow(() -> new ResourceNotFoundException(404, "Resource Not Found", userId));
		Post post = this.getModalMapper.map(p, Post.class);
		post.setCategory(cat);
		post.setUser(user);
		Post postSaved = this.pr.save(post);
		System.out.println(postSaved);
		return  this.getModalMapper.map(postSaved, postDto.class);
		
		//mycode
//		userDto user = this.userSer.getUserById(userId);
//		categoryDto catDto = this.catService.getCategoryById(catId);
//		Post post = this.getModalMapper.map(p, Post.class);
//		post.setCategory(this.categoryDtoToCategory(catDto));
//		post.setUser(this.userDtoToUser(user));
//		Post postSaved = pr.save(post);
//		return this.posttoPostDto(postSaved);
	}
	
	@Override
	public void deletePost(int id) throws ResourceNotFoundException{
		Post post = pr.findById(id).orElseThrow(() ->  new ResourceNotFoundException(404, "No Post Found", id));
		pr.delete(post);
	}
	
	@Override
	public List<postDto> getAllPost(){
		List<Post> postList = pr.findAll();
		return postList.stream().map((p) -> this.posttoPostDto(p)).collect(Collectors.toList());
	}
	
	@Override
	public postDto getPostById(int id) throws ResourceNotFoundException{
		Post post = pr.findById(id).orElseThrow(() -> new ResourceNotFoundException(404, "No Post Found", id));
		return this.posttoPostDto(post);
	}
	
//	private Post postDtotoPost(postDto p) {
//		Post post = getModalMapper.map(p, Post.class);
//		return post;
//	}
	
	private postDto posttoPostDto(Post p) {
		postDto post = getModalMapper.map(p, postDto.class);
		return post;
	}

	@Override
	public List<postDto> getPostByUser(Integer userId) {
		User user  = this.ur.findById(userId).orElseThrow(() -> new ResourceNotFoundException(404, "No Post Found", userId));
		List<Post> postList = this.pr.findByUser(user);
		return postList.stream().map(e  -> this.posttoPostDto(e)).collect(Collectors.toList());
	}

	@Override
	public List<postDto> getPostByCategory(Integer catId) {
		Category category  = this.catRepo.findById(catId).orElseThrow(() -> new ResourceNotFoundException(404, "No Post Found", catId));
		List<Post> postList = this.pr.findByCategory(category);
		return postList.stream().map(e  -> this.posttoPostDto(e)).collect(Collectors.toList());
	}
	public userDto userTouserDto(User u) {
		userDto dto = this.getModalMapper.map(u, userDto.class);
		return dto;
	}
	
	public User userDtoToUser(userDto u) {
		User user = this.getModalMapper.map(u, User.class);
		return user;
	}
	public Category categoryDtoToCategory(categoryDto cat) {
		Category category = getModalMapper.map(cat, Category.class);
		return category;
	}
	
	public categoryDto categoryToCategoryDto(Category cat) {
		categoryDto catogory = getModalMapper.map(cat, categoryDto.class);
		return catogory;
	}
}


