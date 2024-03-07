package Java.BlogSite.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import Java.BlogSite.business.abstracts.ImageService;
import Java.BlogSite.business.abstracts.UserService;
import Java.BlogSite.core.entities.Image;
import Java.BlogSite.core.utilities.result.Result;
import Java.BlogSite.core.utilities.result.SuccessResult;
import Java.BlogSite.entities.concretes.User;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	private ImageService imageService;
	
	@Autowired
	public UserController(UserService userService, ImageService imageService) {
		super();
		this.userService = userService;
		this.imageService = imageService;
	}
	
	@PostMapping("/addUser")
	public Result addUser(@Validated @RequestParam("user") String userJson, @RequestParam("image") MultipartFile image) throws IOException{	
		ObjectMapper objectMapper = new ObjectMapper();
		User user = objectMapper.readValue(userJson, User.class); 
		Image uploadImage = this.imageService.uploadImage(image);
		user.setImage(uploadImage);
		return this.userService.addUser(user);  
	}
	
	@GetMapping("/getByEmail/{email}")
	public User findByEmail(@PathVariable String email) {
		return this.userService.getByEmail(email);
	}
	
	@GetMapping("/getAllUser")
	public List<User> getAllUser(){
		return this.userService.getAllUser();
	}
	
	@DeleteMapping("/deleteByUserId/{userId}")
	public Result deleteByUserId(@PathVariable int userId) {
		this.userService.deleteByUserId(userId);
		return new SuccessResult("deleted successfully");
	}
}
