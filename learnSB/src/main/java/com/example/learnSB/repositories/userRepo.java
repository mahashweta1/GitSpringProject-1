package com.example.learnSB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.learnSB.entities.User;

@Repository
public interface userRepo extends JpaRepository<User, Integer>{

}
