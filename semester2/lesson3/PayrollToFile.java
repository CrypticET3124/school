package lesson3;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PayrollToFile {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);

		// Name
		System.out.println("Enter your name:");
		String name = in.nextLine();
		// Rate
		System.out.println("Enter your hourly rate:");
		while (!in.hasNextDouble()) {
			System.out.println("That's not a number.");
			in.nextLine();
		}
		double rate = in.nextDouble();
		in.nextLine();
		// Hours
		System.out.println("Enter the number of hours worked:");
		while (!in.hasNextDouble()) {
			System.out.println("That's not a number.");
			in.nextLine();
		}
		double hours = in.nextDouble();
		in.nextLine();

		PrintWriter pw = new PrintWriter("Payroll.txt");

		pw.println("NAME: " + name);
		pw.println("RATE: " + rate);
		pw.println("HOURS: " + hours);
		pw.println("PAY: " + rate * hours);

		pw.close();
	}
}
