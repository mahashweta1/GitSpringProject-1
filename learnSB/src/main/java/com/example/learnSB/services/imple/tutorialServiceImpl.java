package com.example.learnSB.services.imple;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learnSB.entities.tags;
import com.example.learnSB.entities.tutorial;
import com.example.learnSB.exceptions.ResourceNotFoundException;
import com.example.learnSB.repositories.tagsRepo;
import com.example.learnSB.repositories.tutorialRepo;
import com.example.learnSB.services.tutorialService;

@Service
public class tutorialServiceImpl implements tutorialService{

	@Autowired
    tutorialRepo tRepo;

    @Autowired
    tagsRepo tagRepo;
    
    @Override
    public tutorial addTutorial(tutorial data) {
        tutorial savedData = tRepo.save(data);
        return savedData;
    }

    
    @Override
    public Set<tags> addTagsToTutorial(Integer id, List<tags> tagList) {
        tutorial data = tRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(404, "No Tutorial found", id));
        tagList.forEach((tag) -> {
            tags tagData = tagRepo.findByName(tag.getName());
            if(tagData != null) {
            	data.setTagData(tag);
            }else {
            	tagRepo.save(tag);
            	data.setTagData(tag);
            }
        });
        
        tutorial savedData = tRepo.save(data);
        return savedData.getTagList();
    }

	@Override
	public List<tutorial> getTutorial() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public tutorial getTutorialById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<tags> getTagsByTutorialId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
