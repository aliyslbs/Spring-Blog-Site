package Java.BlogSite.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import Java.BlogSite.business.abstracts.ImageService;

@RestController
@CrossOrigin
@RequestMapping("/image")
public class ImageController {
	
	@Autowired
	private ImageService imageService;

	public ImageController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}
	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadImage(@RequestParam MultipartFile image) {
		try {
			this.imageService.uploadImage(image);
			return ResponseEntity.ok("image added successfully");
		}catch(IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("throw error during uploaded file");
		}
	}
	
	@GetMapping("/getImage/{imageId}")
	public ResponseEntity<byte[]> getImageData(@PathVariable Long imageId) {
		byte[] image = imageService.getByImageId(imageId);
		return ResponseEntity.ok().body(image);
	}
}
