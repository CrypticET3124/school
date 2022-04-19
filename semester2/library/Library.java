package library;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
	static String workDIR = "semester2\\library\\"; //! workDIR is the working directory

	public static final List<Book> lib = new ArrayList<>();
	
	public static void refreshLib() {

		try (Scanner bin = new Scanner(new File(workDIR, "books.txt"))) {
			while(bin.hasNextLine()) { // Title, Author, Genre, Rating, ISBN
				lib.add(new Book(bin.next().replace("_", " "), bin.next().replace("_", " "), bin.next().replace("_", " "), bin.nextDouble(), bin.next()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		refreshLib();
		
		for(Book b : lib) {
			System.out.println(b);
		}

		System.out.println(lib.get(0).title);
	}
}
