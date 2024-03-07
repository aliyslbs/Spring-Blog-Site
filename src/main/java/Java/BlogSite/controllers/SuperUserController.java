package Java.BlogSite.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Java.BlogSite.business.abstracts.SuperUserService;
import Java.BlogSite.core.utilities.result.Result;
import Java.BlogSite.entities.concretes.SuperUser;

@RestController
@RequestMapping("/superUser")
@CrossOrigin
public class SuperUserController {
	
	private SuperUserService superUserService;

	@Autowired
	public SuperUserController(SuperUserService superUserService) {
		super();
		this.superUserService = superUserService;
	}
	
	@PostMapping("/addSuperUser")
	public Result addSuperUser(@RequestBody @Validated SuperUser superUser) {
		return this.superUserService.addSuperUser(superUser);
	}
	
	@GetMapping("/getBySuperUserName/{superUserName}")
	public SuperUser getBySuperUserName(@PathVariable String superUserName) {
		return this.superUserService.getBySuperUserName(superUserName);
	}
	
	@GetMapping("/getBySuperUserId/{superUserId}")
	public SuperUser getBySuperUserId(@PathVariable int superUserId) {
		return this.superUserService.getBySuperUserId(superUserId);
	}
	
	@GetMapping("/getAllSuperUser")
	public List<SuperUser> getAllSuperUser(){
		return this.superUserService.getAllSuperUser();
	}
	
	@DeleteMapping("/deleteSuperUser/{superUserId}")
	public Result deleteSuperUser(@PathVariable int superUserId) {
		return this.superUserService.deleteSuperUser(superUserId);
	}
	
	@PutMapping("/updateSuperUser/{superUserId}")
	public Result updateSuperUser(@PathVariable int superUserId, @RequestBody SuperUser superUser) {
		SuperUser existingSuperUser = this.superUserService.getBySuperUserId(superUserId);
		existingSuperUser.setSuperUserName(superUser.getSuperUserName());
		existingSuperUser.setSuperUserPassword(superUser.getSuperUserPassword());
		return this.superUserService.updateSuperUser(existingSuperUser);
	}
}
