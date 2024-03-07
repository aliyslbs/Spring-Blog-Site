package Java.BlogSite.business.abstracts;

import java.util.List;

import Java.BlogSite.core.utilities.result.Result;
import Java.BlogSite.entities.concretes.SuperUser;

public interface SuperUserService {
	Result addSuperUser(SuperUser superUser);
	
	SuperUser getBySuperUserName(String superUserName);
	
	Result updateSuperUser(SuperUser superUser);
	
	SuperUser getBySuperUserId(int superUserId);
	
	Result deleteSuperUser(int superUserId);
	
	List<SuperUser> getAllSuperUser();
}
