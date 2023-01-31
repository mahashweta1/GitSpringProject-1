package com.example.learnSB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learnSB.entities.tutorial;

public interface tutorialRepo extends JpaRepository<tutorial, Integer> {

}
