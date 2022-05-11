package library;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Interface {
	static Client currentUser;
	static int currentUserIndex;

	static List<Book> library = new ArrayList<>();

	public static void bookInterface(int index) {
		// selected book is
		Book currentBook = library.get(index);
		System.out.println(currentBook.toString());

		if (!currentBook.isCheckedOut()) {
			System.out.println("1. Check out");
		}
		if (currentBook.isCheckedOut() && currentUser.books.contains(index)) {
			System.out.println("2. Return");
		}
		System.out.println("3. Back");
		System.out.print("Enter your choice: ");

		int selection;
		while (true) { // get user's selection and check if it's valid
			try {
				selection = Integer.parseInt(System.console().readLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Invalid selection." + System.lineSeparator());
			}
		}

		switch (selection) {
			case 1:
				if (!currentBook.isCheckedOut()) {
					currentBook.checkOut();
					
					if (currentUser.books.contains(-1)) {
						currentUser.books.remove(currentUser.books.indexOf(-1));
					}
					currentUser.books.add(index);

					System.out.println("Book checked out." + System.lineSeparator());

				} else {
					System.out.println("Book already checked out." + System.lineSeparator());
				}
				break;
			case 2:
				if (currentBook.isCheckedOut() && currentUser.books.contains(Integer.toString(index))) {
					currentBook.checkIn();
					currentUser.books.remove(index);

					if (currentUser.books.isEmpty()) {
						currentUser.books.add(-1);
					}

					System.out.println("Book returned." + System.lineSeparator());

				} else {
					System.out.println("Book not returned." + System.lineSeparator());
				}
				break;
			case 3:
				break;
			default:
				System.out.println("Invalid selection." + System.lineSeparator());
				break;
		}
	}

	public static void loadLibrary() {
		Library.retrieveLib(); // tell the program to refresh the library
		library = Library.lib; // set local library to library
		Library.retrieveClients(); // tell the program to refresh the clients

		for (Client c : Library.clients) {
			if (c.books.get(0) != -1) {
				for (Integer b : c.books) {
					library.get(b).checkOut();
				}
			}
		}
	}

	public static void login(String u, String p) { // check credentials
		for (Client c : Library.clients) {
			if (c.username.equals(u) && c.password.equals(p)) { // if the username and password match
				currentUser = c;
				currentUserIndex = Library.clients.indexOf(c); // set the current user index
				System.out.println("You're logged in now, " + c.fname + "." + System.lineSeparator());
				return;
			}
			System.out.println(System.lineSeparator() + "Invalid username or password." + System.lineSeparator());
		}
	}

	public static void loginInterface() { // login interface
		if (Library.clients.isEmpty()) {
			System.out.println("No users have been created yet." + System.lineSeparator());
		} else {
			System.out.println("Please enter your username: ");
			String u = System.console().readLine();
			System.out.println("Please enter your password: ");
			String p = System.console().readLine();
			login(u, p);
		}
	}

	public static void logout() { // logout
		currentUser = null;
		currentUserIndex = -1;
		System.out.println("You have been logged out.");
	}

	public static void signUp() { // create a new user
		String uname, fname, lname, password, bday;
		int year, month, day;

		// get info
		System.out.println("Enter your first name: "); // * first name
		while (true) {
			fname = System.console().readLine();
			if (Pattern.matches("[a-zA-Z]+", fname)) {
				break;
			} else {
				System.out.println("Invalid first name.");
			}
		}

		System.out.println("Enter your last name: "); // * last name
		while (true) {
			lname = System.console().readLine();
			if (Pattern.matches("[a-zA-Z]+", lname)) {
				break;
			} else {
				System.out.println("Invalid last name.");
			}
		}

		System.out.println("Enter your password: "); // * password
		while (true) {
			password = System.console().readLine();
			if (!password.isEmpty()) {
				break;
			} else {
				System.out.println("Empty password.");
			}
		}

		// string to title case
		fname = fname.substring(0, 1).toUpperCase() + fname.substring(1).toLowerCase(); // ? first letter capitalized
		lname = lname.substring(0, 1).toUpperCase() + lname.substring(1).toLowerCase(); // ? first letter capitalized

		// get birthday
		while (true) {
			System.out.println("Enter your birthday (YYYY/MM/DD): ");
			bday = System.console().readLine();

			try {
				Pattern pattern = Pattern.compile("^[0-9]{4}/(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])$"); // regex

				if (pattern.matcher(bday).matches()) { // if the date is valid
					year = Integer.parseInt(bday.split("/")[0]); // set the variables
					month = Integer.parseInt(bday.split("/")[1]);
					day = Integer.parseInt(bday.split("/")[2]);
					break; // ! break the loop
				} else {
					System.out.println("Invalid date format.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// uname = first letter of first name + last name
		uname = fname.substring(0, 1).toLowerCase() + lname.toLowerCase();

		// if username already exists, add a number to the end
		boolean notUnique = true;
		int counter = 0;
		String tempName = uname;
		while (notUnique) {
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
		Library.writeClients();
		System.out.println("You have successfully signed up!");
		System.out.println(System.lineSeparator() + "Your username is: " + uname + System.lineSeparator());

		login(uname, password);
	}

	public static String searchFormat(String s) { // standardize search strings
		return s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
	}

	public static List<String> searchLibrary(int t, String s) { // ? returns list of results+█+trueIndex
		List<String> results = new ArrayList<>();
		s = searchFormat(s);

		switch (t) {
			case 1: // search all
				for (Book b : library) {
					if (searchFormat(b.getTitle()).contains(s) || searchFormat(b.getAuthor()).contains(s)
							|| searchFormat(b.getGenre()).contains(s) || searchFormat(b.getISBN()).contains(s)) {
						results.add(b.getTitle() + "█" + library.indexOf(b));
					}
				}
				break;

			case 2: // title search
				for (Book b : library) {
					if (searchFormat(b.getTitle()).contains(s)) {
						results.add(b.getTitle() + "█" + library.indexOf(b));
					}
				}
				break;

			case 3: // author search
				for (Book b : library) {
					if (searchFormat(b.getAuthor()).contains(s)) {
						results.add(b.getTitle() + "█" + library.indexOf(b));
					}
				}
				break;

			case 4: // genre search
				for (Book b : library) {
					if (searchFormat(b.getGenre()).contains(s)) {
						results.add(b.getTitle() + "█" + library.indexOf(b));
					}
				}
				break;

			case 5: // isbn search
				for (Book b : library) {
					if (searchFormat(b.getISBN()).contains(s)) {
						results.add(b.getTitle() + "█" + library.indexOf(b));
					}
				}
				break;

			default:
				results.add("Not a search type, (select 1-5)");
		}

		return results;
	}

	public static void searchInterface() { // search interface
		int t;
		String s;
		// options 1-5 of search + exit
		System.out.println("1. Search All");
		System.out.println("2. Search by Title");
		System.out.println("3. Search by Author");
		System.out.println("4. Search by Genre");
		System.out.println("5. Search by ISBN");
		System.out.println("6. Exit");

		// get search type
		while (true) {
			try {
				System.out.println("Enter search type: ");
				t = Integer.parseInt(System.console().readLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Invalid selection." + System.lineSeparator());
			}
		}

		if (t == 6) {
			return;
		}

		// get search term
		System.out.println("Enter search term: ");
		s = System.console().readLine();

		// search
		List<String> results = searchLibrary(t, s);

		// print results
		if (results.isEmpty()) {
			System.out.println("No results found.");
		} else {
			System.out.println("Results:");
			int counter = 0;
			for (String r : results) { // ? "index+1 ) title"
				counter++;
				String title = r.split("█")[0];

				System.out.println(counter + ") " + title);
			}

			int trueIndex = -1;

			// Select book
			boolean notBook = true;
			while (notBook) {
				System.out.println("Select book: ");
				int tempIndex;
				while (true) {
					try {
						tempIndex = Integer.parseInt(System.console().readLine()) - 1;
						break;
					} catch (NumberFormatException e) {
						System.out.println("Invalid selection." + System.lineSeparator());
					}
				}

				if (tempIndex >= 0 && tempIndex <= results.size()) {
					notBook = false;
					trueIndex = Integer.parseInt(results.get(tempIndex).split("█")[1]);
				} else {
					System.out.println("Invalid selection." + System.lineSeparator());
				}
			}

			// open book interface
			bookInterface(trueIndex);
		}
	}

	public static void printMainMenu() {
		if (currentUser != null) {
			System.out.println("Welcome " + currentUser.fname + "!");
			System.out.println("3. Search");
			System.out.println("4. Logout");
		} else {
			System.out.println("1. Login");
			System.out.println("2. Sign up");
			System.out.println("3. Search (login required)");
			System.out.println("4. Logout (login required)");
		}
		System.out.println("5. Exit");

		System.out.println("Enter selection: ");
	}

	public static void main(String[] args) {
		// load library
		loadLibrary();

		// main menu
		boolean running = true;
		while (running) {
			printMainMenu();

			int selection;
			while (true) {
				try {
					selection = Integer.parseInt(System.console().readLine());
					break;
				} catch (NumberFormatException e) {
					System.out.println("Invalid selection." + System.lineSeparator());
					printMainMenu();
				}
			}

			switch (selection) {
				case 1:
					if (currentUser == null) {
						loginInterface();
					} else {
						System.out.println("You are already logged in.");
					}
					break;
				case 2:
					if (currentUser == null) {
						signUp();
					} else {
						System.out.println("You are already logged in.");
					}
					break;
				case 3:
					if (currentUser != null) {
						searchInterface();
					} else {
						System.out.println("You must be logged in to search.");
					}
					break;
				case 4:
					if (currentUser != null) {
						logout();
					} else {
						System.out.println("You are not logged in.");
					}
					break;
				case 5:
					Library.writeClients();
					running = false;
					break;
				default:
					System.out.println("Invalid selection.");
			}
		}
	}
}