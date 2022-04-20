package lesson4.privatePerson;

public class Person {
	private String fName;
	private String lName;
	private int age;
	private Double height;
	private String eyeColor;
	private String maritalStatus;

	public Person(String fn, String ln, int a, String ms) {
		this.fName = fn;
		this.lName = ln;
		this.age = a;
		this.maritalStatus = ms;
	}

	public String getFName() { // fName
		return this.fName;
	}
	
	public void setFName(String x) {
		this.fName = x;
	}

	public String getLName() { // lName
		return this.lName;
	}
	
	public void setLName(String x) {
		this.lName = x;
	}

	public int getAge() { // age
		return this.age;
	}
	
	public void setAge(int x) {
		this.age = x;
	}

	public Double getHeight() { //height
		return this.height;
	}
	
	public void setHeight(Double x) {
		this.height = x;
	}

	public String getEyeColor() { // eyeColor
		return this.eyeColor;
	}
	
	public void setEyeColor(String x) {
		this.eyeColor = x;
	}

	public String getMaritalStatus() { // maritalStatus
		return this.maritalStatus;
	}
	
	public void setMaritalStatus(String x) {
		this.maritalStatus = x;
	}
	
	public static void main(String[] args) {
		Person p1 = new Person("John", "Doe", 27, "Single");
		
		System.out.println(p1.getAge());
	}
}
