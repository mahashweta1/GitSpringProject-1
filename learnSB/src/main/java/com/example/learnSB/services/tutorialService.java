package com.example.learnSB.services;

import java.util.List;
import java.util.Set;

import com.example.learnSB.entities.tags;
import com.example.learnSB.entities.tutorial;

public interface tutorialService {
	
	public tutorial addTutorial(tutorial data);
	public Set<tags> addTagsToTutorial(Integer id, List<tags> tagList);
	public List<tutorial> getTutorial();
	public tutorial getTutorialById(Integer id);
	public Set<tags> getTagsByTutorialId(Integer id);

}
