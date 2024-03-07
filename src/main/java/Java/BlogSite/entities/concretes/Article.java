package Java.BlogSite.entities.concretes;

import Java.BlogSite.core.entities.Image;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "articles")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "article_id")
	private int articleId;
	
	@Column(name="article_title")
	private String articleTitle;

	@Column(name="content", columnDefinition = "TEXT")
	private String content;
	
	@ManyToOne()
	@JoinColumn(name = "author_id")
	private Author author;
	
	@Column(name="publication_date")
	private String publicationDate;
	
	@ManyToOne()
	@JoinColumn(name = "category_id")
	private Category category;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "image_id")
	private Image image;
	
}
