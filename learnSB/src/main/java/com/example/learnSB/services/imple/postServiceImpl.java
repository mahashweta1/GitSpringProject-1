package com.example.learnSB.services.imple;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.learnSB.entities.Post;
import com.example.learnSB.exceptions.ResourceNotFoundException;
import com.example.learnSB.payload.postDto;
import com.example.learnSB.repositories.postRepo;
import com.example.learnSB.services.postService;

@Service
public class postServiceImpl implements postService {
	
	@Autowired
	postRepo pr;
	
	@Autowired
	ModelMapper getModalMapper;
	
	@Override
	public postDto createPost(postDto p) {
		Post post = this.postDtotoPost(p);
		Post postSaved = pr.save(post);
		return this.posttoPostDto(postSaved);
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
	
	private Post postDtotoPost(postDto p) {
		Post post = getModalMapper.map(p, Post.class);
		return post;
	}
	
	private postDto posttoPostDto(Post p) {
		postDto post = getModalMapper.map(p, postDto.class);
		return post;
	}
}


