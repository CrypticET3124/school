package lesson5;

public class Cylinder extends Circle {
	public Double height;
	
	public Cylinder(Double r, Double h) {
		super(r);
		this.height = h;
	}
	
	public Cylinder(int r, int h) {
		super(r);
		this.height = (double)h;
	}
	
	public Double getArea() {
		return 2 * Math.PI * this.radius * (this.height + this.radius); // 2πr (h + r)
	}

	public static void main(String[] args) {

	}
}
