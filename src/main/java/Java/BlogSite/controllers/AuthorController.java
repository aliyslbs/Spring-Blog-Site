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

import Java.BlogSite.business.abstracts.AuthorService;
import Java.BlogSite.business.abstracts.ImageService;
import Java.BlogSite.core.entities.Image;
import Java.BlogSite.core.utilities.result.Result;
import Java.BlogSite.core.utilities.result.SuccessResult;
import Java.BlogSite.entities.concretes.Author;

@CrossOrigin
@RestController
@RequestMapping("/author")
public class AuthorController {
	
	private AuthorService authorService;
	private ImageService imageService;
	
	@Autowired
	public AuthorController(AuthorService authorService, ImageService imageService) {
		super();
		this.authorService = authorService;
		this.imageService = imageService;
	}
	
	@PostMapping("/addAuthor")
	public Result addAuthor(@RequestParam("author") String authorJson, @RequestParam("image") MultipartFile image) throws IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		Author uploadAuthor = objectMapper.readValue(authorJson, Author.class);
		Image uploadImage = imageService.uploadImage(image);		
		uploadAuthor.setImage(uploadImage);
		return this.authorService.addAuthor(uploadAuthor);
	}
	
	@GetMapping("/getByAuthorId")
	public Author getByAuthorId(@RequestParam int authorId) {
		return this.authorService.getByAuhtorId(authorId);
	}
	
	@GetMapping("/getByAuthorId/{authorId}")
	public Author getByAuthorIdPath(@PathVariable int authorId) {
		return this.authorService.getByAuhtorId(authorId);
	}
	
	@GetMapping("/getAllAuthor")
	public List<Author> getAllAuthor(){
		return this.authorService.getAllAuthor();
	}
	
	@DeleteMapping("/deleteByAuthorId/{authorId}")
	public Result deleteByAuthorId(@PathVariable int authorId) {
		this.authorService.deleteByAuthorId(authorId);
		return new SuccessResult("deleted successfully");
	}
	
	@PutMapping("/updateAuthor/{authorId}")
	public Result updateAuthor(@PathVariable int authorId, @RequestBody Author author){
		Author existingAuthor = this.authorService.getByAuhtorId(authorId);
		existingAuthor.setAuthorName(author.getAuthorName());
		return this.authorService.updateAuthor(existingAuthor);
	}

}
