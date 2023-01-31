package com.example.learnSB.cntrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.learnSB.payload.ApiResponse;
import com.example.learnSB.payload.categoryDto;
import com.example.learnSB.services.categoryService;

@RestController
@RequestMapping("api/category")
public class categoryController {
	
	@Autowired
	categoryService catService;

	@PostMapping("/addCategory")
	public ResponseEntity<categoryDto> addCategory(@Valid @RequestBody categoryDto cat){
		categoryDto catReceived = catService.createCategory(cat);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(catReceived);
	}
	
	@PutMapping("/updateCategory/{id}")
	public ResponseEntity<categoryDto> updateCategory(@RequestBody categoryDto c, @PathVariable int id){
		categoryDto c1 = catService.updateCategory(c, id);
		return ResponseEntity.status(201).body(c1);
	}
	
	@GetMapping(value = "/getCategory/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getCatgoryById(@PathVariable int id){
		categoryDto c = catService.getCategoryById(id);
		return ResponseEntity.status(200).body(c);
	}
	@GetMapping("/getCategories")
	public ResponseEntity<?> getCategories(){
		List<categoryDto> categoryList = catService.getCategories();
		if(categoryList == null) {
			return ResponseEntity.status(404).body(null);
		}
		return ResponseEntity.status(200).body(categoryList);
	}
	
	@DeleteMapping("/deleteCategories/{id}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable int id){
		catService.deleteCategory(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("category Deleted", false), HttpStatus.OK);//		return ResponseEntity.status(200).body(Map.of("message", "User Deleted Successfully"));
	}
}
