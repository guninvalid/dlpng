package src.dlpng;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ImageChecksum implements Comparable<ImageChecksum> {
	
	public final String sum;
	
	private ImageChecksum(String sum) {
		
		this.sum = sum;
		
	}
	
	public int compareTo(ImageChecksum i) {
		
		return sum.toString().compareTo(i.toString());
		
	}
	
	public String toString() {
		
		return this.sum;
		
	}
	
	public static ImageChecksum checksum(Image i) {
		
		return new ImageChecksum(checksum(i.toString()));
		
	}
	
	public static String checksum(String filename) {
		
		try (FileInputStream fis = new FileInputStream(filename)) {
			
			StringBuilder sb = new StringBuilder();
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] dataBytes = new byte[1024];
			int nread = 0; 
			
			while((nread = fis.read(dataBytes)) != -1) {
				
				md.update(dataBytes, 0, nread);
				
			}
			
			byte[] mdbytes = md.digest();
			
			for(int i=0; i<mdbytes.length; i++) {
				
				sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100 , 16).substring(1));
				
			}
			
			return sb.toString();
			
		} catch (NoSuchAlgorithmException ex) {
			
			ex.printStackTrace();
			return null;
			
		} catch (IOException ex) {
			
			ex.printStackTrace();
			return null;
			
		}
		
	}
	
}