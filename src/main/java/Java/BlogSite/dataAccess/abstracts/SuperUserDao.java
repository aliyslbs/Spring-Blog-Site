package Java.BlogSite.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Java.BlogSite.entities.concretes.SuperUser;

public interface SuperUserDao extends JpaRepository<SuperUser, Integer>{
	
	SuperUser getBySuperUserName(String superUserName);
}
