package library;

import java.util.ArrayList;

public class Interface {
	
	static ArrayList<Book> library = new ArrayList<>();
	
	
	public static void getLib() {
		new Library();
		Library.refreshLib();
		library = Library.library;
	}
	
	
	public static void login() {
		
	}
	
	public static ArrayList<String> search(int t, String s) {
		ArrayList<String> results = new ArrayList<>();
		s = s.toLowerCase().replaceAll("'|\"|\||:|;|,", replacement);
		
		switch(t) {
			case 1: // title search
				for(Book b : library) {
					if(b.title.toLowerCase().contains(s)) {
						results.add(b.title);
					}
				}
				break;
				
			case 2: // author search
				for(Book b : library) {
					if(b.author.toLowerCase().contains(s)) {
						results.add(b.title);
					}
				}
				break;
				
			case 3: // genre search
				for(Book b : library) {
					if(b.genre.toLowerCase().contains(s)) {
						results.add(b.title);
					}
				}
				break;
			
			case 4: // isbn search
				for(Book b : library) {
					if(b.isbn.toLowerCase().contains(s)) {
						results.add(b.title);
					}
				}
				break;
				
			case 5: // search all
				for(Book b : library) {
					if(b.title.toLowerCase().contains(s)) {
						results.add(b.title);
					} else if(b.author.toLowerCase().contains(s)) {
						results.add(b.title);
					} else if(b.genre.toLowerCase().contains(s)) {
						results.add(b.title);
					} else if(b.isbn.toLowerCase().contains(s)) {
						results.add(b.title);
					}
				}
				break;
				
			default: results.add("Not a search type");
		}
		
		return results;
	}

	public static void main(String[] args) {
		
	}
}
