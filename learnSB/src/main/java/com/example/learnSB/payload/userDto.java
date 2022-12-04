package com.example.learnSB.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class userDto {
	private int user_id;
	
	@NotNull
	private String user_name;
	
	@Email
	private String email;
	
	@NotNull
	@Min(value = 3)	
	@Max(value = 8)

	private String password;

}
