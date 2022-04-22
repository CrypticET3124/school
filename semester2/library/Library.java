package library;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Library {
	static String workDIR = "semester2\\library\\"; // ! workDIR is the working directory, must be changed each system

	public static final List<Book> lib = new ArrayList<>();
	public static final List<Client> clients = new ArrayList<>();

	private static String attributeSep = "\\[\\"; // ! attribute separator

	public static void refreshLib() {
		try (Scanner bin = new Scanner(new File(workDIR, "books.txt"))) {
			while (bin.hasNextLine()) {
				String[] attr = bin.nextLine().split(Pattern.quote(attributeSep));

				lib.add(new Book(attr[0], attr[1], attr[2], Double.parseDouble(attr[3]), attr[4]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writeClient(Client c) {
		// add client to a file using printwriter
		try (PrintWriter pw = new PrintWriter(new File(workDIR, "clients.txt"))) {
			pw.println(c.username + attributeSep + c.fname + attributeSep + c.lname + attributeSep + c.password + attributeSep + c.bday.getYear() + attributeSep
					+ c.bday.getMonthValue() + attributeSep + c.bday.getDayOfMonth());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void refreshClients() {
		try (Scanner bin = new Scanner(new File(workDIR, "clients.txt"))) {
			while (bin.hasNextLine()) {
				String[] attr = bin.nextLine().split(Pattern.quote(attributeSep));

				clients.add(new Client(attr[0], attr[1], attr[2], attr[3], Integer.parseInt(attr[4]),
						Integer.parseInt(attr[5]), Integer.parseInt(attr[6])));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		refreshLib();

		for (Book b : lib) {
			System.out.println(b);
		}

		System.out.println(lib.get(0).getTitle());
	}
}
