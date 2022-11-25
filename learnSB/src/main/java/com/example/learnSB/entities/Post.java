package com.example.learnSB.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int pid;
	String caption;
	String location;
	String date;
	
	public Post(int id, String caption, String location, String date) {
		super();
		this.pid = id;
		this.caption = caption;
		this.location = location;
		this.date = date;
	}
}
