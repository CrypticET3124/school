package lesson2;

import java.util.Scanner;

public class Pluralizer {
    private static String pluralize(String word) {
        String plural = "";
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

        return plural;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a word:");

        String word = in.nextLine();

        System.out.println("The plural of " + word + " is " + pluralize(word));

        in.close();
    }
}
