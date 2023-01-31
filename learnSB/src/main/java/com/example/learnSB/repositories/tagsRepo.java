package com.example.learnSB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.learnSB.entities.tags;

@Repository
public interface tagsRepo extends JpaRepository<tags, Integer> {
	
	public tags findByName(String name);

}
