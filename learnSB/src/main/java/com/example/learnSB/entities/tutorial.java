package com.example.learnSB.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class tutorial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tutorial_id")
	private int tutId;
	private String subject;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "tutorial_tags",
		joinColumns = {@JoinColumn(name = "tutorial_id")},
		inverseJoinColumns = {@JoinColumn(name = "tag_id")}
			)
	Set<tags> tagList = new HashSet<>();
	
	public void setTagData(tags tagData){
		this.tagList.add(tagData);
	}
	
}
