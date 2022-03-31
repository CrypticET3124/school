package library;

public class Book {
	public String title;
	public String author;
	public String genre;
	public String isbn;
	private double rating;
	private boolean checkedOut; // if a copy is checked out

	public Book(String t, String a, String g, Double r, String i) {
		this.title = t;
		this.author = a;
		this.genre = g;
		this.rating = r;
		this.isbn = i;
		this.checkedOut = false;
	}

	public String getTitle() { // title
		return this.title;
	}

	public String getAuthor() { // author
		return this.author;
	}

	public String getGenre() { // genre
		return this.genre;
	}

	public String getISBN() { // ISBN
		return this.isbn;
	}

	public void setRating(double r) { // rating
		this.rating = r;
	}

	public void setRating(int r) { // rating
		this.rating = (double) r;
	}

	public double getRating() { // return rating
		return Double.valueOf(String.format("%.2f", this.rating));
	}

	public void checkOut() { // check out copy
		this.checkedOut=true;
	}

	public void checkIn() { // check in copy
		this.checkedOut=false;
	}

	public boolean isCheckedOut() { // return if a copy is checked out
		return this.checkedOut;
	}
	
	@Override
	public String toString() {
		return title + "[author=" + author + ", genre=" + genre + ", rating=" + rating + "]";
	}

	public static void main(String[] args) {
		
	}
}
