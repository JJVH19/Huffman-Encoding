import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * File: DataInput.java
 * Author: Amelia Matheson
 * Purpose: Reads input data from a file, or from the console and stores it in a file
 *  for the rest of the program to use
 */

public class DataInput {
    private static File file;
    private static File fromConsole;

    public static void main(String[] args) {
        System.out.println("Welcome! This is a program designed to accept textual input, and encode it using Huffman Encoding.");
        System.out.println("Is the data coming from a file? (Y/N/yes/no)");
        Scanner input = new Scanner(System.in);
        String isFile = input.next();
        while (true) {
            if (isFile.equals("Y") || isFile.equals("yes") || isFile.equals("Yes") || isFile.equals("YES")) {
                System.out.print("Please enter the file name: ");
                String filename = input.next();
                file = new File(filename);
                if (!file.canRead()) {
                    System.out.println("Unable to open file, please try again");
                    System.out.println("Is the data coming from a file? (Y/N/yes/no");
                }
                else {
                    break;
                }
            }
            else {
                System.out.println("Begin entering input. Type 'QUIT' when you are finished");
                Scanner reading = new Scanner(System.in);
                String info = reading.nextLine();
                fromConsole = new File("InfoFromConsole.txt");
                try {
                    FileWriter writer = new FileWriter(fromConsole);
                    while (!info.equals("QUIT")) {
                        writer.write(info + System.lineSeparator());
                        info = reading.nextLine();
                    }
                    writer.close();
                    reading.close();
                    break;
                }
                catch (IOException exc) {
                    System.out.println("An error occured");
                    File toDelete = new File("InfoFromConsole.txt");
                    toDelete.delete();
                    reading.close();
                }
            }
        }
        input.close();
    }
}
