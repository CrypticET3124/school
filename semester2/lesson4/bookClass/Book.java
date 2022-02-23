public class Book {
	public String title;
	public String author;
	public String genre;
	public String isbn;
	private double rating;
	private boolean checkedOut; // if a copy is checked out
	private int numCopy; // total copies
	private int outCopy; // checked out copies

	public Book(String t, String a, String g, String i) {
		this.title = t;
		this.author = a;
		this.genre = g;
		this.isbn = i;
		this.checkedOut = false;
		this.numCopy = 1;
		this.outCopy = 0;
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

	public double getRating() { // return rating
		return Double.valueOf(String.format("%.2f", this.rating));
	}

	public void checkOut() { // check out copy
		if(this.numCopy > this.outCopy) {
			this.checkedOut = true;
			this.outCopy++;
		}
	}

	public void checkIn() { // check in copy
		this.outCopy--;
		if(this.outCopy == 0) {
			this.checkedOut = false;
		}
	}

	public boolean isCheckedOut() { // return if a copy is checked out
		return this.checkedOut;
	}

	public int getCopy() { // return total copies
		return this.numCopy;
	}

	public int getOutCopy() { // return checked out copies
		return this.outCopy;
	}

	public boolean canCheckOut() { // return if can checkout
		return this.numCopy > this.outCopy ? true : false;
	}

	public void addCopy() { // increase total copies
		this.numCopy++;
	}

	public void removeCopy() { // decrease total copies
		this.numCopy--;
	}
	
	public static void main(String[] args) {
		Book b1 = new Book("a", "b", "c", "d");

		b1.setRating(5.3215);

		System.out.println(b1.getRating());
	}
}
