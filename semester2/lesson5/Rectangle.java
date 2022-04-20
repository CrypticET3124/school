package lesson5;

public class Rectangle extends Square{
	public Double width;

	public Rectangle(Double l, Double w) {
		super(l);

		this.width = w;
	}

	public Rectangle(int l, int w) {
		super(l);

		this.width = (double)w;
	}
	
	public Double getArea() {
		return this.length * this.width;
	}
	
	public static void main(String[] args) {

	}
}
