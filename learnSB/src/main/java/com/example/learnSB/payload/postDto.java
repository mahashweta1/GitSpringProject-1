package com.example.learnSB.payload;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class postDto {

	private int post_id;
	
	@NotNull
	private String caption;
	
	@NotNull
	private String location;
	
	@NotNull
	private Date date;
	
	categoryDto category;
	
	userDto user;
}
