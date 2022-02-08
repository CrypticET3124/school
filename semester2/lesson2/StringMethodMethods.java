import java.util.Scanner;

public class StringMethodMethods {
	public static void firstThreeLetters() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a word:");

        String word = in.nextLine();

        System.out.println("The first three letters are: " + word.substring(0, 3));
		in.close();
    }

	public static void flip() {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter your name:");
        String name = in.nextLine();

		int spacePos = name.indexOf(" ");

        String firstName = name.substring(0, spacePos);
        String lastName = name.substring(spacePos + 1);

        System.out.println("Your name flipped is: " + lastName + ", " + firstName);
		in.close();
    }
	
    private static void pluralize() {
		Scanner in = new Scanner(System.in);
		String plural = "";

        System.out.println("Enter a word:");

        String word = in.nextLine();

        String lcWord = word.toLowerCase();

        if (lcWord.endsWith("ay") || lcWord.endsWith("ey") || lcWord.endsWith("iy") || lcWord.endsWith("oy") || lcWord.endsWith("uy")) { // ay, ey, iy, oy, uy
            plural = word + "s";
        } else if (lcWord.endsWith("us")) { // us
            plural = word.substring(0, word.length() - 2) + "i";
        } else if (lcWord.endsWith("ch") || lcWord.endsWith("sh") || lcWord.endsWith("ss")) { // ch, sh, ss
            plural = word + "es";
        } else if (lcWord.endsWith("y")) { // y
            plural = word.substring(0, word.length() - 1) + "ies";
        } else if (lcWord.endsWith("fe")) { // fe
            plural = word.substring(0, word.length() - 2) + "ves";
        } else if (lcWord.endsWith("s")) { // s
            plural = word + "es";
        } else { // everything else
            plural = word + "s";
        }

        System.out.println("The plural of " + word + " is " + plural);
		in.close();
    }

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("You can: ");
		System.out.println("(1) Get the first 3 letters of a word");
		System.out.println("(2) Flip a given name");
		System.out.println("(3) Pluralize a word");

		int option = 0;

		boolean done = false;
		while (!done) {
			System.out.println("Select an option (1, 2, 3):");
			while(!in.hasNextInt()) {
				System.out.println("That's not a number.");
				in.nextLine();
			}
			option = in.nextInt();
			in.nextLine();

			if (option < 1 || option > 3) {
				System.out.println("That's not an option.");
			} else {
				done = true;
			}
		}

		if (option == 1) {
			firstThreeLetters();
		} else if (option == 2) {
			flip();
		} else if (option == 3) {
			pluralize();
		}

		in.close();
    }
}
