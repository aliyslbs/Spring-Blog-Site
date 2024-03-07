package Java.BlogSite.controllers;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import Java.BlogSite.business.abstracts.ArticleService;
import Java.BlogSite.business.abstracts.AuthorService;
import Java.BlogSite.business.abstracts.CategoryService;
import Java.BlogSite.business.abstracts.ImageService;
import Java.BlogSite.core.entities.Image;
import Java.BlogSite.core.utilities.result.Result;
import Java.BlogSite.entities.concretes.Article;
import Java.BlogSite.entities.concretes.Author;
import Java.BlogSite.entities.concretes.Category;

@CrossOrigin
@RestController
@RequestMapping("/article")
public class ArticleController {
	private ArticleService articleService;
	private CategoryService categoryService;
	private AuthorService authorService;
	private ImageService imageService;

	@Autowired
	public ArticleController(ArticleService articleService, CategoryService categoryService,
			AuthorService authorService, ImageService imageService) {
		super();
		this.articleService = articleService;
		this.categoryService = categoryService;
		this.authorService = authorService;
		this.imageService = imageService;
	}

	@GetMapping("/getAllArticle")
	public List<Article> getAllArticle() {
		return this.articleService.getAllArticle();
	}

	@PostMapping("/addArticle/{categoryId}/{authorId}")
	public Result addArticle(
			@RequestParam("article") String articleJson, 
			@PathVariable int categoryId, 
			@PathVariable int authorId,
			@RequestParam("image") MultipartFile image) throws IOException 
	{		
		ObjectMapper objectMapper = new ObjectMapper();
		Article uploadArticle = objectMapper.readValue(articleJson, Article.class);
		
		Category category = this.categoryService.getByCategoryId(categoryId);
		Author author = this.authorService.getByAuhtorId(authorId);
		Image uploadImage = this.imageService.uploadImage(image);
		
		uploadArticle.setCategory(category);
		uploadArticle.setAuthor(author);
		uploadArticle.setImage(uploadImage);
		return this.articleService.addArticle(uploadArticle);
	}

	@PutMapping("/updateArticle/{articleId}/{categoryId}/{authorId}")
	public Result updateArticle(@PathVariable int articleId, @PathVariable int categoryId, @PathVariable int authorId,
			@RequestBody Article article) {
		Article existingArticle = this.articleService.getByArticleId(articleId);
		Category category = this.categoryService.getByCategoryId(categoryId);
		Author author = this.authorService.getByAuhtorId(authorId);
		existingArticle.setArticleTitle(article.getArticleTitle());
		existingArticle.setContent(article.getContent());
		existingArticle.setPublicationDate(article.getPublicationDate());
		existingArticle.setAuthor(author);
		existingArticle.setCategory(category);
		return this.articleService.updateArticle(existingArticle);
	}

	@DeleteMapping("/deleteByArticleId/{articleId}")
	public Result deleteArticle(@PathVariable int articleId) {
		return this.articleService.deleteByArticleId(articleId);
	}

	@GetMapping("/getByArticleTitle")
	public Result getByArticleTitle(@RequestParam String articleTitle) {
		return this.articleService.getByArticleTitle(articleTitle);
	}

	@GetMapping("/getByArticleId/{articleId}")
	public Article getByArticleId(@PathVariable int articleId) {
		return this.articleService.getByArticleId(articleId);
	}

	@GetMapping("/getByAuthor")
	public Result getByAuthor(@RequestBody Author author) {
		return this.articleService.getByAuthor(author);
	}

}
