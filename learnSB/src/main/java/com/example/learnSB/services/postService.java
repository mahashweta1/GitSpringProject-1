package com.example.learnSB.services;

import java.util.List;

import com.example.learnSB.entities.Post;
import com.example.learnSB.payload.postDto;

public interface postService {
	public postDto createPost(postDto p, Integer userId, Integer catId);
	public void deletePost(int id);
	public List<postDto> getAllPost();
	public postDto getPostById(int id);
	public List<postDto> getPostByUser(Integer userId);
	public List<postDto> getPostByCategory(Integer catId);
}
