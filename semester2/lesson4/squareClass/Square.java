public class Square {
	public Double length;
	
	public Square(Double l) {
		this.length = l;
	}

	public Square(int l) {
		this.length = (double) l;
	}
	
	public Double getArea() {
		return this.length * this.length;
	}

	public static void main(String[] args) {
		Square s1 = new Square(5);

		System.out.println("Area: " + s1.getArea());
	}
}
