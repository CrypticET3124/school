public class PersonClass {	
	public static void main(String[] args) {
		person p1 = new person("John", "Doe", 27, "Single");
		
		System.out.println(p1.age);
	}
}

class person {
	String fName;
	String lName;
	int age;
	Double height;
	String eyeColor;
	String maritalStatus;

	person(String fn, String ln, int a, String ms) {
		fName = fn;
		lName = ln;
		age = a;
		maritalStatus = ms;
	}
}
