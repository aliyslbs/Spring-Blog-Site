package Java.BlogSite.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="super_users")
@AllArgsConstructor
@NoArgsConstructor
public class SuperUser{
	
	@Id
	@Column(name="super_user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int superUserId;
	
	@Column(name="super_user_name", nullable = false, unique = true)
	private String superUserName;
	
	@Column(name="super_user_password", nullable = false, unique = true)
	private String superUserPassword;
}
