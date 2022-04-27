package src.dlpng;

import src.dlpng.Image.ImageType;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageConverter {
	
	public static Image convert(Image i) throws IOException {
		
		ImageType t = i.imageType();
		
		if (t == null) {
			
			return null;
			
		}
		
		switch (t) {
			
			case PNG:
				return i;
				
			case JPG:
				File out = File.createTempFile("tmp", "png");
				ImageIO.write(ImageIO.read(i), "png", out);
				return new Image(out);
				
			case WEBP:
				return i;
				
			case GIF:
				return i;
			
		}
		
		throw new CouldNotConvertException("How the hell did I get here?");
		
	}
	
	public static class CouldNotConvertException extends IOException {
		
		public CouldNotConvertException(String err) {
			
			super(err);
			
		}
		
	}
	
}