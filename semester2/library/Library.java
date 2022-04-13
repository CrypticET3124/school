package library;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
	public static ArrayList<Book> library = new ArrayList<>();
	
	public static void refreshLib() {
		Scanner bin;
		try {
			bin = new Scanner(new File("books.txt"));
			
			while(bin.hasNextLine()) { //Title, Author, Genre, Rating, ISBN
				Book temp = new Book(bin.next().replace("_", " "), bin.next().replace("_", " "), bin.next().replace("_", " "), bin.nextDouble(), bin.next());
				
				library.add(temp);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		refreshLib();
		
		for(Book b : library) {
			System.out.println(b);
		}
	}
}
