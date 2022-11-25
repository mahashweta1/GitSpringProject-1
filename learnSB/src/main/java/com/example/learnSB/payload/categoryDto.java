package com.example.learnSB.payload;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class categoryDto {

	@NotNull
	int cid;
	
	@NotNull
	String type;
}
