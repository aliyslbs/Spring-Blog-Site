package Java.BlogSite.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Java.BlogSite.business.abstracts.ArticleService;
import Java.BlogSite.core.utilities.result.Result;
import Java.BlogSite.core.utilities.result.SuccessResult;
import Java.BlogSite.dataAccess.abstracts.ArticleDao;
import Java.BlogSite.entities.concretes.Article;
import Java.BlogSite.entities.concretes.Author;

@Service
public class ArticleManager implements ArticleService {
	private ArticleDao articleDao;
	
	@Autowired
	public ArticleManager(ArticleDao articleDao) {
		super();
		this.articleDao = articleDao;
	}

	@Override
	public List<Article> getAllArticle() {
		return this.articleDao.findAll();
	}

	@Override
	public Result addArticle(Article article) {
		this.articleDao.save(article);
		return new SuccessResult("added succesfully");
	}

	@Override
	public Result deleteByArticleId(int articleId) {
		this.articleDao.deleteById(articleId);
		return new SuccessResult("deleted succesfully"); 
    }

	@Override
	public Result getByArticleTitle(String articleTitle) {
		this.articleDao.getByArticleTitle(articleTitle);
		return new SuccessResult();
	}

	@Override
	public Result getByAuthor(Author author) {
		this.articleDao.getByAuthor(author);
		return new SuccessResult();
	}

	@Override
	public Article getByArticleId(int articleId) {
		return this.articleDao.findById(articleId).orElseThrow();
	}

	@Override
	public Result updateArticle(Article article) {
		this.articleDao.save(article);
		return new SuccessResult("updated successfully");
	}

}
