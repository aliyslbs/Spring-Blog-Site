package Java.BlogSite.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Java.BlogSite.business.abstracts.UserService;
import Java.BlogSite.core.utilities.result.Result;
import Java.BlogSite.core.utilities.result.SuccessResult;
import Java.BlogSite.dataAccess.abstracts.UserDao;
import Java.BlogSite.entities.concretes.User;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result addUser(User user) {
		this.userDao.save(user);
		return new SuccessResult("user added successfully");
	}

	@Override
	public User getByEmail(String email) {
		return 	this.userDao.getByEmail(email);
	}

	@Override
	public List<User> getAllUser() {
		return this.userDao.findAll();
	}

	@Override
	public Result deleteByUserId(int userId) {
		this.userDao.deleteById(userId);
		return new SuccessResult("deleted successfully");
	}

}
