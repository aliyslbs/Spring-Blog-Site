package Java.BlogSite.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Java.BlogSite.entities.concretes.Author;

public interface AuthorDao extends JpaRepository<Author, Integer> {

}
