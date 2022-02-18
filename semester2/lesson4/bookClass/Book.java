public class Book {
	private String title;
	private String author;
	private String genre;
	private String isbn;
	private double rating;
	private boolean checkedOut;

	public Book(String t, String a, String g, String i) {
		title = t;
		author = a;
		genre = g;
		isbn = i;
		checkedOut = false;
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

	public String getISBN() { // isbn
		return this.isbn;
	}

	public void setRating(double r) { // rating
		this.rating = r;
	}

	public void setRating(int r) { // rating
		this.rating = (double) r;
	}

	public double getRating() {
		return Double.valueOf(String.format("%.2f", this.rating));
	}

	public void checkOut() { // check in/out
		this.checkedOut = true;
	}

	public void checkIn() {
		this.checkedOut = false;
	}

	public boolean isCheckedOut() {
		return this.checkedOut;
	}
	
	public static void main(String[] args) {
		Book b1 = new Book("a", "b", "c", "d");

		b1.setRating(5.3215);

		System.out.println(b1.getRating());
	}
}
