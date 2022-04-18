package library;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
	public static List<Book> library = new ArrayList<>();
	
	public static void refreshLib() {
		try (Scanner bin = new Scanner(new File("books.txt"))) {
			while(bin.hasNextLine()) { //Title, Author, Genre, Rating, ISBN
				Book temp = new Book(bin.next().replace("_", " "), bin.next().replace("_", " "), bin.next().replace("_", " "), bin.nextDouble(), bin.next());
				
				library.add(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		refreshLib();
		
		for(Book b : library) {
			System.out.println(b);
		}

		System.out.println(library.get(1));
	}
}
