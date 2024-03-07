package Java.BlogSite.business.abstracts;

import java.util.List;

import Java.BlogSite.core.utilities.result.Result;
import Java.BlogSite.entities.concretes.Category;

public interface CategoryService {
	
	Result addCategory(Category category);
	
	Result updateCategory(Category category);
	
	List<Category> getAllCategory();
	
	Category getByCategoryId(int categoryId);
	
	Result deleteByCategoryId(int categoryId);
}
