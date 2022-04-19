package library;

import java.util.ArrayList;
import java.util.List;

public class Interface {
	
	static List<Book> library = new ArrayList<>();
	
	public static void getLib() {
		Library.refreshLib();
		library = Library.lib;
	}
	
	public static void login() {
		// TODO implement login thread
	}

	public static String searchFormat(String s) {
		return s.toLowerCase().replaceAll("[a-zA-Z0-9]", "");
	}
	
	public static List<String> search(int t, String s) {
		ArrayList<String> results = new ArrayList<>();
		s = searchFormat(s);
		
		switch(t) {
			case 1: // title search
				for(Book b : library) {
					if(searchFormat(b.title).contains(s)) {
						results.add(b.title);
					}
				}
				break;
				
			case 2: // author search
				for(Book b : library) {
					if(searchFormat(b.author).contains(s)) {
						results.add(b.title);
					}
				}
				break;
				
			case 3: // genre search
				for(Book b : library) {
					if(searchFormat(b.genre).contains(s)) {
						results.add(b.title);
					}
				}
				break;
			
			case 4: // isbn search
				for(Book b : library) {
					if(searchFormat(b.isbn).contains(s)) {
						results.add(b.title);
					}
				}
				break;
				
			case 5: // search all
				for(Book b : library) {
					if(searchFormat(b.title).contains(s) || searchFormat(b.author).contains(s) || searchFormat(b.genre).contains(s) || searchFormat(b.isbn).contains(s)) {
						results.add(b.title);
					}
				}
				break;
				
			default: results.add("Not a search type, (select 1-5)");
		}
		
		return results;
	}

	public static void main(String[] args) {
		// TODO implement main thread
	}
}
