package Java.BlogSite.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import Java.BlogSite.core.entities.Image;

public interface ImageDao extends JpaRepository<Image, Long>{

}
