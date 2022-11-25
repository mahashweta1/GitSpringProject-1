package com.example.learnSB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.learnSB.entities.Post;

@Repository
public interface postRepo extends JpaRepository<Post, Integer> {

}
