package src.driver;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class Driver {
	
	public static final Bundle state = new Bundle();
	
	public static void main(String[] args) {
		
		args = new String[] {"compare", "/home/guninvalid/Pictures", "--debug", "--nogui"};
		
		try {
			
			switch (args[0].toLowerCase()) {
				
				case "compare":
					state.command = Command.COMPARE;
					break;
				
			}
			
			LinkedList<File> filepaths = new LinkedList<File>();
			ListIterator<String> fetcher = Arrays.asList(args).listIterator();
			fetcher.next();
			
			while (fetcher.hasNext()) {
				
				String elem = fetcher.next();
				
				switch (elem) {
					
					case "--debug": 
						state.debug = true;
						break;
						
					case "--nogui":
						state.gui = false;
						break;
						
					default:
						filepaths.add(new File(elem));
						
					
				}
				
			}
			
			switch (state.command) {
				
				case COMPARE:
					Comparator.compare(filepaths);
					break;
				default:
					break;
				
			}
			
		} catch (BadArgumentException ex) {
			
			ex.printStackTrace();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
			
		}
		
	}
	
	public static class Bundle {
		
		public boolean gui = true;
		public boolean debug = false;
		public Command command;
		
	}
	
	public static enum Command {
		
		DL, MV, CP, CONVERT, HASH, COMPARE,
		
		;
		
	}
	
	public static class BadArgumentException extends RuntimeException {
		
		
		
	}
	
}