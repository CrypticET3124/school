import java.io.File;
import java.util.Scanner;

public class TeamRoster {
	public static void main(String[] args) {
		try {
			Scanner nameS = new Scanner(new File("TeamRosterNames.txt"));
			Scanner numS = new Scanner(new File("TeamRosterNumbers.txt"));
			
			while (nameS.hasNextLine()) {
				System.out.println(nameS.nextLine() + " - " + numS.nextLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
