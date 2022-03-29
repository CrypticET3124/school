package library;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
	

	public static void main(String[] args) throws FileNotFoundException {
		File bookFile = new File("books.txt");
		Scanner bin = new Scanner(bookFile);
		
		ArrayList<Book> library = new ArrayList<>();
		
		while(bin.hasNextLine()) {
			Book temp = new Book(bin.next(), bin.next(), bin.next(), bin.nextDouble(), bin.next());
			
			library.add(temp);			
		}
		
		for(Book b : library) {
			System.out.println(b);
		}
	}
}
