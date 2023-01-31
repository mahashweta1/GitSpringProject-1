package com.example.learnSB.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	private String user_name;
	private String email;
	private String password;

//	List<Contact> contactList = new ArrayList<>();
	@OneToMany(mappedBy = "user")
	public List<Post> post;

	//	@Override
//	public String toString() {
//		return "User [user_id=" + user_id + ", user_name=" + user_name + ", email=" + email + ", password=" + password
//				+ ", post=" + post + "]";
//	}
}
