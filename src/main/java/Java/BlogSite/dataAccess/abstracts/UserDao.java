package Java.BlogSite.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Java.BlogSite.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	User getByEmail( String email);
}
