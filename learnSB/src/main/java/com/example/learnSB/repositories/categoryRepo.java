package com.example.learnSB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learnSB.entities.Category;

public interface categoryRepo extends JpaRepository<Category, Integer> {
	
}
