package com.example.learnSB.services;

import java.util.List;

import com.example.learnSB.payload.categoryDto;

public interface categoryService {
	categoryDto createCategory(categoryDto cat);
	categoryDto updateCategory(categoryDto cat, int id);
	void deleteCategory(int id);
	categoryDto getCategoryById(int id);
	List<categoryDto> getCategories();
}
