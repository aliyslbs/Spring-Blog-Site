package Java.BlogSite.business.concretes;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Java.BlogSite.business.abstracts.ImageService;
import Java.BlogSite.core.dataAccess.ImageDao;
import Java.BlogSite.core.entities.Image;
@Service
public class ImageManager implements ImageService {

	@Autowired
	private ImageDao imageDao;

	public ImageManager(ImageDao imageDao) {
		super();
		this.imageDao = imageDao;
	}

	@Override
	public Image uploadImage(MultipartFile image) throws IOException {
		Image uploadImage = new Image();
		uploadImage.setImageName(image.getOriginalFilename());
		uploadImage.setData(image.getBytes());
		this.imageDao.save(uploadImage);
		return uploadImage;
	}

	@Override
	public byte[] getByImageId(Long imageId) {
		Optional<Image> image = this.imageDao.findById(imageId);
		return image.get().getData();
	}
}
