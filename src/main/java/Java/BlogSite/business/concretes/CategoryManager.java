package Java.BlogSite.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Java.BlogSite.business.abstracts.CategoryService;
import Java.BlogSite.core.utilities.result.Result;
import Java.BlogSite.core.utilities.result.SuccessResult;
import Java.BlogSite.dataAccess.abstracts.CategoryDto;
import Java.BlogSite.entities.concretes.Category;

@Service
public class CategoryManager implements CategoryService{
	
	private CategoryDto categoryDto;
	
	@Autowired
	public CategoryManager(CategoryDto categoryDto) {
		super();
		this.categoryDto = categoryDto;
	}

	@Override
	public Result addCategory(Category category) {
		this.categoryDto.save(category);
		return new SuccessResult("başarıyla kaydedildi");
	}

	@Override
	public Category getByCategoryId(int categoryId) {
		return this.categoryDto.findById(categoryId).orElseThrow();
	}

	@Override
	public List<Category> getAllCategory() {
		return this.categoryDto.findAll();
	}

	@Override
	public Result deleteByCategoryId(int categoryId) {
		this.categoryDto.deleteById(categoryId);
		return new SuccessResult("deleted successfully");
	}

	@Override
	public Result updateCategory(Category category) {
		this.categoryDto.save(category);
		return new SuccessResult("updated successfully");
	}

}
