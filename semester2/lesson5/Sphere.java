package lesson5;

public class Sphere extends Circle{
	public Sphere(Double r) {
		super(r);
	}
	
	public Sphere(int r) {
		super(r);
	}
	
	public Double getArea() {
		return 4 * Math.PI * Math.pow(this.radius, 2); //4πr^2
	}

	public static void main(String[] args) {

	}
}
