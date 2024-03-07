package Java.BlogSite.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Java.BlogSite.entities.concretes.Article;
import Java.BlogSite.entities.concretes.Author;

public interface ArticleDao extends JpaRepository<Article, Integer> {
	Article getByArticleTitle(String articleTitle);
	
	Article getByAuthor(Author author);
	
	
}
