import java.util.Scanner;

public class NameFlipper {
    public static String flip(String name) {
        int spacePos = name.indexOf(" ");

        String firstName = name.substring(0, spacePos);
        String lastName = name.substring(spacePos + 1);

        return lastName + ", " + firstName;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter your name:");

        String name = in.nextLine();

        System.out.println("Your name flipped is: " + flip(name));
    }
}
