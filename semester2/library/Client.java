package library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client {
	public String username, password;
	String fname, lname;
	LocalDate bday;
	List<String> books = new ArrayList<>();

	public Client(String u, String fn, String ln, String p, int y, int m, int d) {
		this.username = u;
		this.fname = fn;
		this.lname = ln;
		this.password = p;

		this.bday = LocalDate.of(y, m, d);
	}

	public static void main(String[] args) {

	}
}
