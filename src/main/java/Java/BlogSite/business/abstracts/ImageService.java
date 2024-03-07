package Java.BlogSite.business.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import Java.BlogSite.core.entities.Image;

public interface ImageService {
	
	Image uploadImage(MultipartFile image) throws IOException;
	
	byte[] getByImageId(Long imageId);

}
