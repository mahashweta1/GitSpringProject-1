package com.example.learnSB.cntrollers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learnSB.entities.tags;
import com.example.learnSB.entities.tutorial;
import com.example.learnSB.services.tutorialService;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("api/tutorial")
public class tutorialController {
	
	@Autowired
	tutorialService tService;
	
	@PostMapping("/")
	public ResponseEntity<tutorial> addTutorial(@RequestBody tutorial tData){
		tutorial tDataSaved = this.tService.addTutorial(tData);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(tDataSaved);
	}
	
	@PostMapping("/{tutorialId}/tags")
	public ResponseEntity<Set<tags>> addTagsToTutorial(@PathVariable Integer tutorialId, @RequestBody List<tags> tData){
		Set<tags> tagsSaved = this.tService.addTagsToTutorial(tutorialId, tData);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(tagsSaved);
	}

}
