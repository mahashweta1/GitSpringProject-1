package com.example.learnSB.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Post  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", caption=" + caption + ", location=" + location + ", date=" + date
				+ ", category=" + category + ", user=" + user + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pid")
	int post_id;
	String caption;
	String location;
	Date date;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	Category category;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	User user;
	
	public Post(int pid, String caption, String location, Date date) {
		super();
		this.post_id = pid;
		this.caption = caption;
		this.location = location;
		this.date = date;
	}

	public Post(int post_id, String caption, String location, Date date, Category category, User user) {
		super();
		this.post_id = post_id;
		this.caption = caption;
		this.location = location;
		this.date = date;
		this.category = category;
		this.user = user;
	}
	
	
}
