package Java.BlogSite.business.abstracts;


import java.util.List;

import Java.BlogSite.core.utilities.result.Result;
import Java.BlogSite.entities.concretes.User;


public interface UserService {
	
	Result addUser(User user);
	
	User getByEmail(String email);
	
	List<User> getAllUser();
	
	Result deleteByUserId(int userId);
}
