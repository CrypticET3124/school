public class Square {
	public Double length;
	
	public Square(Double l) {
		length = l;
	}

	public Square(int l) {
		length = (double) l;
	}
	
	public Double getArea() {
		return length * length;
	}

	public static void main(String[] args) {
		Square s1 = new Square(5);

		System.out.println("Area: " + s1.getArea());
	}
}
