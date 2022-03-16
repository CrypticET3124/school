public class Circle {
	public Double radius;
	
	public Circle(Double r) {
		radius = r;
	}
	
	public Circle(int r) {
		radius = (double)r;
	}
	
	public Double getArea() {
		return Math.PI * Math.pow(this.radius, 2);
	}

	public static void main(String[] args) {

	}
}
