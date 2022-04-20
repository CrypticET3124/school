package lesson4.personClass;

public class Person {
	String fName;
	String lName;
	int age;
	Double height;
	String eyeColor;
	String maritalStatus;

	public Person(String fn, String ln, int a, String ms) {
		fName = fn;
		lName = ln;
		age = a;
		maritalStatus = ms;
	}
	
	public static void main(String[] args) {
		Person p1 = new Person("John", "Doe", 27, "Single");
		
		System.out.println(p1.age);
	}
}
