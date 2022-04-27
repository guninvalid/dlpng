package src.dlpng;

import java.io.File;
import java.io.IOException;

import org.apache.tika.Tika;

public class Image extends File {
	
	private ImageType imageType;
	private ImageChecksum sum;
	private static final Tika tika = new Tika();
	
	public Image(String pathname) {
		
		super(pathname);
		
	}
	
	public Image(File parent, String path) {
		
		super(parent, path);
		
	}
	
	public Image(File file) {
		
		this(file.toString());
		
	}
	
	public ImageType imageType() throws IOException {
		
		if (imageType == null) {
			
			String type = tika.detect(this);
			
			switch (type) {
				
				case "image/png":
					this.imageType = ImageType.PNG;
					break;
					
				case "image/jpeg":
					this.imageType = ImageType.JPG;
					break;
					
				case "image/webp":
					this.imageType = ImageType.WEBP;
					break;
					
				case "image/gif":
					this.imageType = ImageType.GIF;
					break;
					
				default:
//					throw new IOException(toString() + " is not an image, it is a " + type + ".");
					
			}
			
		}
		
		return imageType;
		
	}
	
	public ImageChecksum checksum() throws IOException {
		
		if (sum == null) {
			
			sum = ImageChecksum.checksum(ImageConverter.convert(this));
			
		}
		
		return sum; 
		
	}
	
	public static enum ImageType {
		
		PNG, JPG, WEBP, GIF;
		
	}
	
}