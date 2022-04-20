package lesson5;

public class Square {
	public Double length;
	
	public Square(Double l) {
		this.length = l;
	}

	public Square(int l) {
		this.length = (double)l;
	}
	
	public Double getArea() {
		return this.length * this.length;
	}

	public static void main(String[] args) {
		
	}
}
