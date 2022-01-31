import java.util.Scanner;

public class FirstThreeLetters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a word:");

        String word = in.nextLine();

        System.out.println("The first three letters are: " + word.substring(0, 3));
    }
}
