package com.example.learnSB.payload;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class postDto {

	int post_id;
	
	@NotNull
	String caption;
	
	@NotNull
	String location;
	
	@NotNull
	String date;
}
