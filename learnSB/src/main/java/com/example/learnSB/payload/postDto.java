package com.example.learnSB.payload;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.example.learnSB.entities.Category;
import com.example.learnSB.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class postDto {

	int post_id;
	
	@NotNull
	String caption;
	
	@NotNull
	String location;
	
	@NotNull
	Date date;
	
	Category categoryData;
	
	User userData;
}
