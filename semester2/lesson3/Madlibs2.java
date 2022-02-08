import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class Madlibs2 {
	static Random random = new Random();

	// Words from https://icebreakerideas.com/mad-libs/
	public static String getAdjective() throws FileNotFoundException, IOException {
		ArrayList<String> adjs = new ArrayList<>(Files.readAllLines(Paths.get("Madlibs2Adjectives.txt")));

		return adjs.get(random.nextInt(adjs.size()));
	}

	public static String getNoun() throws FileNotFoundException, IOException {
		ArrayList<String> nouns = new ArrayList<>(Files.readAllLines(Paths.get("Madlibs2Nouns.txt")));

		return nouns.get(random.nextInt(nouns.size()));
	}
	
	public static String getVerb() throws FileNotFoundException, IOException {
		ArrayList<String> verbs = new ArrayList<>(Files.readAllLines(Paths.get("Madlibs2Verbs.txt")));

		return verbs.get(random.nextInt(verbs.size()));
	}

	public static String getAdverb() throws FileNotFoundException, IOException {
		ArrayList<String> adverbs = new ArrayList<>(Files.readAllLines(Paths.get("Madlibs2Adverbs.txt")));

		return adverbs.get(random.nextInt(adverbs.size()));
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {	
		System.out.println("The " + getAdjective() + " " + getNoun() + " "+ getVerb()+ " the " + getNoun() + " " + getAdverb());
	}
}
