package Java.BlogSite.business.abstracts;

import java.util.List;

import Java.BlogSite.core.utilities.result.Result;
import Java.BlogSite.entities.concretes.Article;
import Java.BlogSite.entities.concretes.Author;

public interface ArticleService {
	List<Article> getAllArticle();
	
	Result addArticle(Article article);
	
	Result updateArticle(Article article);
	
	Article getByArticleId(int articleId);
	
	Result deleteByArticleId(int articleId);
	
	Result getByArticleTitle(String articleTitle);
	
	Result getByAuthor(Author author);
}
