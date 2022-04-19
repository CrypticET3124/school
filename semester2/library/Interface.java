package library;

import java.util.ArrayList;
import java.util.List;

public class Interface {
	public static Client currentUser;
	public static int currentUserIndex;
	
	static List<Book> library = new ArrayList<>();
	
	public static void getLib() {
		Library.refreshLib();
		library = Library.lib;
	}
	
	public static void login(String u, String p) {
		for(Client c : Library.clients) {
			if(c.username.equals(u) && c.password.equals(p)) {
				currentUser = c;
				currentUserIndex = Library.clients.indexOf(c);
				System.out.println("Welcome, " + c.fname + "!");
				return;
			}
			System.out.println("Invalid username or password.");
		}
	}

	public static void signUp() {
		String uname, fname, lname, password;
		int year, month, day;

		// get info
		System.out.println("Enter your first name: ");
		fname = System.console().readLine();
		System.out.println("Enter your last name: ");
		lname = System.console().readLine();
		System.out.println("Enter your password: ");
		password = System.console().readLine();
		System.out.println("Enter your birth year: ");
		year = Integer.parseInt(System.console().readLine());
		System.out.println("Enter your birth month: ");
		month = Integer.parseInt(System.console().readLine());
		System.out.println("Enter your birth day: ");
		day = Integer.parseInt(System.console().readLine());

		// uname = first letter of first name + last name
		uname = fname.substring(0, 1) + lname;

		// if username already exists, add a number to the end
		boolean notUnique = true;
		int counter = 0;
		String tempName = uname;
		while(notUnique) {
			counter++;
			notUnique = false;

			for (Client c : Library.clients) {
				if (c.username.equals(uname)) {
					tempName = uname + counter;
					notUnique = true;
				}
			}
		}
		uname = tempName;

		// add client to list
		Client newUser = new Client(uname, fname, lname, password, year, month, day);
		Library.clients.add(newUser);
		System.out.println("You have successfully signed up!");
		System.out.println("Your username is: " + uname);

		login(uname, password);
	}

	public static String searchFormat(String s) {
		return s.toLowerCase().replaceAll("[a-zA-Z0-9]", "");
	}
	
	public static List<String> search(int t, String s) { //? returns results+index
		List<String> results = new ArrayList<>();
		List<Integer> rNum = new ArrayList<>();
		s = searchFormat(s);
		
		switch(t) {
			case 1: // title search
				for(Book b : library) {
					if(searchFormat(b.title).contains(s)) {
						results.add(b.title + library.indexOf(b));
					}
				}
				break;
				
			case 2: // author search
				for(Book b : library) {
					if(searchFormat(b.author).contains(s)) {
						results.add(b.title + library.indexOf(b));
					}
				}
				break;
				
			case 3: // genre search
				for(Book b : library) {
					if(searchFormat(b.genre).contains(s)) {
						results.add(b.title + library.indexOf(b));
					}
				}
				break;
			
			case 4: // isbn search
				for(Book b : library) {
					if(searchFormat(b.isbn).contains(s)) {
						results.add(b.title + library.indexOf(b));
					}
				}
				break;
				
			case 5: // search all
				for(Book b : library) {
					if(searchFormat(b.title).contains(s) || searchFormat(b.author).contains(s) || searchFormat(b.genre).contains(s) || searchFormat(b.isbn).contains(s)) {
						results.add(b.title + library.indexOf(b));
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
