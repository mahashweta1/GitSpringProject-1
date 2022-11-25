package com.example.learnSB.services.imple;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.learnSB.entities.Category;
import com.example.learnSB.exceptions.ResourceNotFoundException;
import com.example.learnSB.payload.categoryDto;
import com.example.learnSB.repositories.categoryRepo;
import com.example.learnSB.services.categoryService;

@Service
public class categoryServiceImpl implements categoryService{

	@Autowired
	ModelMapper getModalMapper;
	
	@Autowired
	categoryRepo cr;
	
	@Override
	public categoryDto createCategory(categoryDto cat) {
		Category category = cr.save(this.categoryDtoToCategory(cat));
		return this.categoryToCategoryDto(category);
	}

	@Override
	public categoryDto updateCategory(categoryDto cat, int id) throws ResourceNotFoundException {
		Category category = cr.findById(id).orElseThrow(() -> new  ResourceNotFoundException(404, "No Post Found", id));
		category.setCid(cat.getCid());
		category.setType(cat.getType());
		Category newCategory = cr.save(category);
		return this.categoryToCategoryDto(newCategory);
	}

	@Override
	public void deleteCategory(int id) throws ResourceNotFoundException {
		Category category = cr.findById(id).orElseThrow(() -> new  ResourceNotFoundException(404, "No Post Found", id));
		cr.delete(category);
	}

	@Override
	public categoryDto getCategoryById(int id) throws ResourceNotFoundException {
		Category category = cr.findById(id).orElseThrow(() -> new  ResourceNotFoundException(404, "No Post Found", id));
		return this.categoryToCategoryDto(category);
	}
	
	@Override
	public List<categoryDto> getCategories(){
		List<Category> categoryList = cr.findAll();
		return categoryList.stream().map(element -> this.categoryToCategoryDto(element)).collect(Collectors.toList());
		
	};
	private Category categoryDtoToCategory(categoryDto cat) {
		Category category = getModalMapper.map(cat, Category.class);
		return category;
	}
	
	private categoryDto categoryToCategoryDto(Category cat) {
		categoryDto catogory = getModalMapper.map(cat, categoryDto.class);
		return catogory;
	}

	
}
