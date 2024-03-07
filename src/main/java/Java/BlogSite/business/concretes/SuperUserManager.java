package Java.BlogSite.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Java.BlogSite.business.abstracts.SuperUserService;
import Java.BlogSite.core.utilities.result.Result;
import Java.BlogSite.core.utilities.result.SuccessResult;
import Java.BlogSite.dataAccess.abstracts.SuperUserDao;
import Java.BlogSite.entities.concretes.SuperUser;

@Service
public class SuperUserManager implements SuperUserService{
	
	private SuperUserDao superUserDao;	
	
	@Autowired
	public SuperUserManager(SuperUserDao superUserDao) {
		super();
		this.superUserDao = superUserDao;
	}


	@Override
	public Result addSuperUser(SuperUser superUser) {
		this.superUserDao.save(superUser);
		return new SuccessResult("super user added successfully");
	}


	@Override
	public SuperUser getBySuperUserName(String superUserName) {
		return this.superUserDao.getBySuperUserName(superUserName);
	} 


	@Override
	public List<SuperUser> getAllSuperUser() {
		return this.superUserDao.findAll();
	}


	@Override
	public Result deleteSuperUser(int superUserId) {
		this.superUserDao.deleteById(superUserId);
		return new SuccessResult("deleted successfully");
	}


	@Override
	public SuperUser getBySuperUserId(int superUserId) {
		return this.superUserDao.findById(superUserId).orElseThrow();
	}


	@Override
	public Result updateSuperUser(SuperUser superUser) {
		this.superUserDao.save(superUser);
		return new SuccessResult("updated successfully");
	}

}
