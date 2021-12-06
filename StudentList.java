import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    // Method for opening file in read mode.
    public static BufferedReader creatFileReadMode() {
        try {
            BufferedReader file = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(Constants.fileName)));
            return file;
        } catch (Exception e) {
            return null;
        }
    }

    // Method for opening file in write mode.
    public static BufferedWriter creatFileWriteMode() {
        try {
            BufferedWriter file = new BufferedWriter(
                    new FileWriter(Constants.fileName, true));
            return file;
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        // Check whether the argument is multiple word.
        // Valid argumets = {a, r, c, f, +}
        if (args.length != 1) {
            System.out.println(Constants.agrsWorngflag);
        }

        // functions for argument of 'a' (showing whole file)
        else if (args[0].equals(Constants.a)) {
            System.out.println(Constants.loading);
            try {
                BufferedReader file = creatFileReadMode();
                String line = file.readLine();
                String words[] = line.split(Constants.comma);
                for (String word : words) {
                    System.out.println(word);
                }
            } catch (Exception e) {
            }
            System.out.println(Constants.loaded);
        }

        // functions for argument of 'r' (showing a random word)
        else if (args[0].equals(Constants.r)) {
            System.out.println(Constants.loading);
            try {
                BufferedReader file = creatFileReadMode();
                String line = file.readLine();
                String words[] = line.split(",");
                Random x = new Random();
                int idx = x.nextInt(words.length - 1);
                System.out.println(words[idx]);
            } catch (Exception e) {
            }
            System.out.println(Constants.loaded);
        }

        // functions for argument of '+' (adding a word)
        else if (args[0].contains(Constants.plus)) {
            System.out.println(Constants.loading);
            try {
                BufferedWriter file = creatFileWriteMode();
                String targetWord = args[0].substring(1);
                Date d = new Date();
                String df = Constants.dateFormat;
                DateFormat dateFormat = new SimpleDateFormat(df);
                String fd = dateFormat.format(d);
                file.write(Constants.comma + targetWord);
                file.write(Constants.lastUpdate + fd);
                file.close();
            } catch (Exception e) {
            }

            System.out.println(Constants.loaded);
        }

        // functions for argument of 'f' (checking for a word)
        else if (args[0].contains(Constants.f)) {
            System.out.println(Constants.loading);
            try {
                BufferedReader file = creatFileReadMode();
                String line = file.readLine();
                String words[] = line.split(Constants.comma);
                boolean done = false;
                String targetWord = args[0].substring(1);
                for (int idx = 0; idx < words.length && !done; idx++) {
                    if (words[idx].equals(targetWord)) {
                        System.out.println(Constants.weFound);
                        done = true;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println(Constants.loaded);
        }

        // functions for arguments for c (counting words)
        else if (args[0].contains(Constants.c)) {
            System.out.println(Constants.loading);
            try {
                BufferedReader file = creatFileReadMode();
                String line = file.readLine();
                char charArray[] = line.toCharArray();
                boolean in_word = false;
                int count = 0;
                for (char c : charArray) {
                    if (c == Constants.commaChar) {
                        if (!in_word) {
                            count++;
                            in_word = true;
                        } else {
                            in_word = false;
                        }
                    }
                }
                System.out.println(count + Constants.wordFound);
            } catch (Exception e) {
            }
            System.out.println(Constants.loaded);
        }

        // Check whether the argument is multiple character.
        else {
            System.out.printf(Constants.entervalidArgs);
        }
    }
}