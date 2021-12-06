import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Not a valid argument\nPlease enter only one Character argument");
        }

//		Check arguments
        else if (args[0].equals("a")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader file = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String line = file.readLine();
                String words[] = line.split(",");
                for (String word : words) {
                    System.out.println(word);
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("r")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader file = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String line = file.readLine();
//			System.out.println(line);
                String words[] = line.split(",");
                Random x = new Random();
                int idx = x.nextInt(words.length - 1);
                System.out.println(words[idx]);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter file = new BufferedWriter(
                        new FileWriter("students.txt", true));
                String targetWord = args[0].substring(1);
                Date d = new Date();
                String df = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(df);
                String fd = dateFormat.format(d);
                file.write(", " + targetWord + "\nList last updated on " + fd);
                file.close();
            } catch (Exception e) {
            }

            System.out.println("Data Loaded.");
        } else if (args[0].contains("f")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader file = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String line = file.readLine();
                String words[] = line.split(",");
                boolean done = false;
                String targetWord = args[0].substring(1);
                for (int idx = 0; idx < words.length && !done; idx++) {
                    if (words[idx].equals(targetWord)) {
                        System.out.println("We found it!");
                        done = true;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader file = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String line = file.readLine();
                char charArray[] = line.toCharArray();
                boolean in_word = false;
                int count = 0;
                for (char c : charArray) {
                    if (c == ' ') {
                        if (!in_word) {
                            count++;
                            in_word = true;
                        } else {
                            in_word = false;
                        }
                    }
                }
                System.out.println(count + " word(s) found ");
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else {
            System.out.printf("Please enter valid arguments !");
        }
    }
}