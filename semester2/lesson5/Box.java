package lesson5;

public class Box extends Rectangle {
	public Double height;

	public Box(Double l, Double w, Double h) {
		super(l, w);

		this.height = h;
	}

	public Box(int l, int w, int h) {
		super(l, w);

		this.height = (double)h;
	}
	
	public Double getArea() {
		return (2 * this.height * this.width) + (2 * this.height * this.length) + (2 * this.length * this.width);
	}
	
	public static void main(String[] args) {
		Box b = new Box(5, 5, 5);

		System.out.println(b.getArea());
	}
}
