package com.example.learnSB.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.learnSB.entities.Category;
import com.example.learnSB.entities.Post;
import com.example.learnSB.entities.User;

@Repository
public interface postRepo extends JpaRepository<Post, Integer> {
	
	public List<Post> findByUser(User user);
	public List<Post> findByCategory(Category cat);

}
