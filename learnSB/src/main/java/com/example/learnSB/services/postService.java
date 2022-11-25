package com.example.learnSB.services;

import java.util.List;

import com.example.learnSB.payload.postDto;

public interface postService {

	public postDto createPost(postDto p);
	public void deletePost(int id);
	public List<postDto> getAllPost();
	public postDto getPostById(int id);
}
