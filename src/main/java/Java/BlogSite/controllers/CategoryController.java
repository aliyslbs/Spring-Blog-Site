package Java.BlogSite.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Java.BlogSite.business.abstracts.CategoryService;
import Java.BlogSite.core.utilities.result.Result;
import Java.BlogSite.core.utilities.result.SuccessResult;
import Java.BlogSite.entities.concretes.Category;

@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {
	private CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	@PostMapping("/addCategory")
	public Result addCategory(@RequestBody Category category) {
		return this.categoryService.addCategory(category);
	}
	
	@GetMapping("/getByCategoryId")
	public Category getByCategoryId(@RequestParam int categoryId) {
		return this.categoryService.getByCategoryId(categoryId);
	}
	
	@GetMapping("/getByCategoryId/{categoryId}")
	public Category getByCategoryIdPath(@PathVariable int categoryId) {
		return this.categoryService.getByCategoryId(categoryId);
	}
	
	@GetMapping("/getAllCategory")
	public List<Category> getAllCategory(){
		return this.categoryService.getAllCategory();
	}
	
	@DeleteMapping("/deleteByCategoryId/{categoryId}")
	public Result deleteByCategoryId(@PathVariable int categoryId) {
		this.categoryService.deleteByCategoryId(categoryId);
		return new SuccessResult("deleted successfully");
	}
	
	@PutMapping("/updateCategory/{categoryId}")
	public Result updateCategory(@PathVariable int categoryId, @RequestBody Category category) {
		Category existingCategory = this.categoryService.getByCategoryId(categoryId);
		existingCategory.setCategoryName(category.getCategoryName());
		return this.categoryService.updateCategory(existingCategory);
	}

}
