package com.example.learnSB.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int cid;
	String type;
	
	@OneToMany(mappedBy = "category")
	public List<Post> post;
	
	public Category(int cid, String type) {
		super();
		this.cid = cid;
		this.type = type;
	}

//	@Override
//	public String toString() {
//		return "Category [cid=" + cid + ", type=" + type + ", post=" + post + "]";
//	}
	
}
