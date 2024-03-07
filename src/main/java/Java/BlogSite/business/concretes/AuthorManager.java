package Java.BlogSite.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Java.BlogSite.business.abstracts.AuthorService;
import Java.BlogSite.core.utilities.result.Result;
import Java.BlogSite.core.utilities.result.SuccessResult;
import Java.BlogSite.dataAccess.abstracts.AuthorDao;
import Java.BlogSite.entities.concretes.Author;

@Service
public class AuthorManager implements AuthorService  {
	
	private AuthorDao authorDao;
	
	@Autowired
	public AuthorManager(AuthorDao authorDao) {
		super();
		this.authorDao = authorDao;
	}

	@Override
	public Result addAuthor(Author author) {
		this.authorDao.save(author);
		return new SuccessResult("add succecfuly");
	}

	@Override
	public Author getByAuhtorId(int authorId) {
		return this.authorDao.findById(authorId).orElseThrow();
	}

	@Override
	public List<Author> getAllAuthor() {
		return this.authorDao.findAll();
	}

	@Override
	public Result deleteByAuthorId(int authorId) {
		this.authorDao.deleteById(authorId);
		return new SuccessResult("deleted successfully");
	}

	@Override
	public Result updateAuthor(Author author) {
		this.authorDao.save(author);
		return new SuccessResult("updated successfully");
	}

}
