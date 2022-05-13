package library;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Library {
    static String workDIR = "semester2\\library\\"; // ! workDIR

    public static final List<Book> lib = new ArrayList<>();
    public static final List<Client> clients = new ArrayList<>();

    private static String attributeSep = "\\[\\"; // ! attribute separator: \[\

    public static void retrieveLib() { // load library from file into memory
        try (Scanner bin = new Scanner(new File(workDIR, "books.txt"))) {
            while (bin.hasNextLine()) {
                String[] attr = bin.nextLine().split(Pattern.quote(attributeSep));

                lib.add(new Book(attr[0], attr[1], attr[2], Double.parseDouble(attr[3]), attr[4]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeClients() { // add client to a file using printwriter
        try (PrintWriter pw = new PrintWriter(new File(workDIR, "clients.txt"))) {
            for (Client c : clients) {
                String books = "";
                for (Integer b : c.books) {
                    books += b + "/" + lib.get(b).dueDate + ".";
                }

                pw.println(c.username + attributeSep + c.fname + attributeSep + c.lname + attributeSep + c.password
                        + attributeSep + c.bday.getYear() + attributeSep + c.bday.getMonthValue() + attributeSep
                        + c.bday.getDayOfMonth() + attributeSep + books);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void retrieveClients() { // load clients from file into memory
        try (Scanner bin = new Scanner(new File(workDIR, "clients.txt"))) {
            while (bin.hasNextLine()) {
                String[] attr = bin.nextLine().split(Pattern.quote(attributeSep));

                List<Integer> tempBooks = new ArrayList<>();

                for (String s : attr[7].split(Pattern.quote("."))) {
                    int index = Integer.parseInt(s.split("/")[0]);
                    LocalDate due = LocalDate.parse(s.split("/")[1]);
                    tempBooks.add(index);
                    lib.get(index).dueDate = due;
                }

                clients.add(new Client(attr[0], attr[1], attr[2], attr[3], Integer.parseInt(attr[4]),
                        Integer.parseInt(attr[5]), Integer.parseInt(attr[6]), tempBooks));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Interface.loadLibrary();

        for (Book b : lib) {
            System.out.println(b);
        }

        System.out.println(lib.get(0).getTitle());
    }
}
