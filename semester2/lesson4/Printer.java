package lesson4;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;

public class Printer {
	public static Scanner in = new Scanner(System.in);
	public static Random r = new Random();

	public static List<Integer> docIDs = new ArrayList<>();
	public static List<String> docBodys = new ArrayList<>();

	public static List<Integer> scanIDs = new ArrayList<>();
	public static List<String> scanBodys = new ArrayList<>();

	String ipAddr;
	int numPaper;
	double numInk;
	int numDocs;
	String currentDocInfo;

	public Printer(int x) {
		ipAddr = "192.168.1." + x;
		numPaper = 100;
		numInk = 400;
	}

	public void printItem(int docID) {
		int id = docIDs.indexOf(docID);
		currentDocInfo = docBodys.get(id);

		System.out.println(docIDs.get(id) + ":");
		System.out.println(currentDocInfo);

		docIDs.remove(id);
		docBodys.remove(id);
		currentDocInfo = "";
		numPaper--;
		numInk--;
	}

	public void scanItem() {
		int id = r.nextInt(1000) + 1;
		scanIDs.add(id);
		scanBodys.add(in.nextLine());

		int index = scanIDs.indexOf(id);

		sendDocument(id, index);
	}

	public void addDocument() {
		int id = r.nextInt(1000) + 1;
		docIDs.add(id);
		docBodys.add(in.nextLine());
	}

	public void sendDocument(int id, int index) {
		try (PrintWriter pw = new PrintWriter("Scan - " + id);) {
			pw.println(scanBodys.get(index));

			scanIDs.remove(index);
			scanBodys.remove(index);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void randomlyBreak() {
		// :P
	}

	public static void main(String[] args) {
		
	}
}
