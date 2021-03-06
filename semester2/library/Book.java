package library;

import java.time.LocalDate;

public class Book {
	private String title, author, genre, isbn;
	private double rating;
	private boolean checkedOut;
	LocalDate dueDate;

	public Book(String t, String a, String g, Double r, String i) {
		this.title = t;
		this.author = a;
		this.genre = g;
		this.rating = r;
		this.isbn = i;
		this.checkedOut = false;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() { // author
		return author;
	}

	public String getGenre() { // genre
		return genre;
	}

	public String getISBN() { // ISBN
		return isbn;
	}

	public void setRating(double r) { // rating
		this.rating = r;
	}

	public void setRating(int r) { // rating
		this.rating = r;
	}

	public double getRating() { // return rating
		return Double.valueOf(String.format("%.2f", this.rating));
	}

	public void checkOut() { // check out copy
		this.checkedOut = true;
	}

	public void checkIn() { // check in copy
		this.checkedOut = false;
	}

	public boolean isCheckedOut() { // return if a copy is checked out
		return checkedOut;
	}

	public void setDueDate(LocalDate plusWeeks) {
		this.dueDate = plusWeeks;
	}

	@Override
	public String toString() {
		String c = isCheckedOut() ? "Checked out" : "Available";

		return System.lineSeparator() + getTitle() + " - " + getAuthor() + System.lineSeparator() + getRating()
				+ "/10 | " + getGenre() + " - " + c + System.lineSeparator();
	}
}
