package library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client {
	public String username, password;
	String fname, lname;
	LocalDate bday;
	List<Integer> books = new ArrayList<>();

	public Client(String u, String fn, String ln, String p, int y, int m, int d) {
		this.username = u;
		this.fname = fn;
		this.lname = ln;
		this.password = p;

		this.bday = LocalDate.of(y, m, d);
		this.books.add(-1);
	}

	public Client(String u, String fn, String ln, String p, int y, int m, int d, List<Integer> b) {
		this.username = u;
		this.fname = fn;
		this.lname = ln;
		this.password = p;

		this.bday = LocalDate.of(y, m, d);
		this.books = b;
	}
}
