package com.example.learnSB.cntrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learnSB.payload.categoryDto;
import com.example.learnSB.services.imple.categoryServiceImpl;

@RestController
@RequestMapping(name = "api/category")
public class categoryController {
	
	@Autowired
	categoryServiceImpl catService;

	@PostMapping("createCategory")
	public ResponseEntity<categoryDto> createCategory(@RequestBody categoryDto cat){
		categoryDto catReceived = catService.createCategory(cat);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(catReceived);
	}
	
}
