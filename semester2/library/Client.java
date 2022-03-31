package library;

import java.time.LocalDate;
import java.util.ArrayList;

public class Client {
	public String name;
	public LocalDate bday;
	public ArrayList<String> books = new ArrayList<>();
	
	public Client(String n, int y, int m, int d) {
		this.name = n;
		bday = LocalDate.of(y, m, d);
	}

	public static void main(String[] args) {
		
	}
}
