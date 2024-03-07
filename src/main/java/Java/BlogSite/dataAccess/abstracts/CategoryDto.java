package Java.BlogSite.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Java.BlogSite.entities.concretes.Category;

public interface CategoryDto extends JpaRepository<Category, Integer>{

}
