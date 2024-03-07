package Java.BlogSite.business.abstracts;

import java.util.List;

import Java.BlogSite.core.utilities.result.Result;
import Java.BlogSite.entities.concretes.Author;

public interface AuthorService {
	Result addAuthor(Author author);
	
	Result updateAuthor(Author author);
	
	Author getByAuhtorId(int authorId);
	
	List<Author> getAllAuthor();
	
	Result deleteByAuthorId(int authorId);
}
