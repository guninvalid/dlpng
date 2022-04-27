package src.driver;

import src.Logger;
import src.dlpng.Image;
import src.dlpng.ImageChecksum;
//import src.gui.ComparatorWindow;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeMap;

public class Comparator {
	
	public static void compare(Collection<File> paths) throws IOException {
		
		LinkedList<Image> images = new LinkedList<Image>();
		
		for (File elem: paths) {
			
			if (elem.isDirectory()) {
				
				for (File child: elem.listFiles()) {
					
					Image i = new Image(child);
					
					if (i != null && !i.isDirectory() && i.imageType() != null) {
						
						Logger.d(i.toString());
						Logger.d(String.valueOf(images.size()));
						images.add(i);
						
					}
					
				}
				
			} else {
				
				Image i = new Image(elem);
				
				if (i != null && i.imageType() != null) {
					
					Logger.d(i.toString());
					Logger.d(String.valueOf(images.size()));
					images.add(i);
					
				}
				
			}
			
		}
		
		TreeMap<ImageChecksum, Image> map = new TreeMap<ImageChecksum, Image>();
		LinkedList<Collision> collisions = new LinkedList<Collision>();
		
		for (Image i: images) {
			
			if (i == null) {
				
				continue;
				
			}
			
			ImageChecksum checksum = i.checksum();
			Logger.d("Image " + i.getName() + " has checksum " + checksum.sum);
			
			if (map.containsKey(checksum)) {
				
				collisions.add(new Collision(map.get(checksum), i));
				
			} else {
				
				map.put(checksum, i);
				
			}
			
		}
		
		if (Driver.state.gui) {
			
			//TODO
			
		} else {
			
			Logger.i(collisions.size() + " collisions found.");
			
			for (Collision c: collisions) {
				
				Logger.i(c.original.toString() + " collides with " + c.duplicate.toString());
				
			}
			
		}
		
	}
	
	public static class Collision {
		
		public final Image original;
		public final Image duplicate;
		
		public Collision(Image original, Image duplicate) {
			
			Logger.d("Found collision between " + original + " and " + duplicate);
			this.original = original;
			this.duplicate = duplicate;
			
		}
		
	}
	
}