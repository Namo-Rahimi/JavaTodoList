package org.namo;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Functions {
    // Created a Figlet Function it's easier if it's a function
    public static void Figlet(String text) {
        try {
            String asciiArt = FigletFont.convertOneLine(text);
            System.out.println(asciiArt);
        } catch (final Exception e) {
            System.out.println("An error has occurred can't print figlet. ");
        }
    }
    // Creates the todolist file
    public static void FileCreate() {
        File myFile = new File("todolist.txt");
        try {
            if (myFile.createNewFile()) {
                //The file has been created.
            }
        } catch (IOException e) {
            System.out.println("An error has occurred can't make the file");
        }
    }
    // Asks for the input
    public static String Input(String input) {
        Scanner scan = new Scanner(System.in);
        System.out.print("\n" + input);
        String value = scan.nextLine();
        return value;
    }
    // Clears the Cmd/Terminal
    public static void ClearScreen() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            System.out.println("An error has occurred cannot clear screen");
        }
    }
    // Quits the program
    public static void Quit() {
        try {
            System.out.println("C ya");
            Thread.sleep(500);
            System.exit(0);
        } catch (InterruptedException e) {
            System.out.println("An error has occurred cannot quit program");
        }
    }
    // Add a task to the todolist.txt
    public static void AddTask(String task) {
        try {

            BufferedWriter write = new BufferedWriter(new FileWriter("todolist.txt", true));
            write.write(task + "\n");
            write.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    // Prints content of the text file to the screen
    public static void ShowTasks()  {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("todolist.txt"));
            int lines = 1;
            for (String line = reader.readLine(); line !=null; line=reader.readLine()) {
                System.out.println(lines++ + ". " + line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error has occurred I/O error");
        }
    }
    // Shows how many lines in the text file
    public static int GetLines() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("todolist.txt"));
        int lines = 1;
        int textLine = 0;
        for (String line = reader.readLine(); line !=null; line=reader.readLine()) {
            textLine = lines++;
        }
        return textLine;
    }
    // Removes an item from the list
    public static void RemoveFromList(int lineNumber) {
        try {
            int textNumbers = GetLines();
            if (textNumbers == lineNumber) {
                String line = Files.readAllLines(Paths.get("todolist.txt")).get(lineNumber - 1);
                File inputFile = new File("todolist.txt");
                File tempFile = new File("tempFile.txt");

                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                String lineToRemove = line;
                String currentLine;

                while ((currentLine = reader.readLine()) != null) {
                    // trim newline when comparing with lineToRemove
                    String trimmedLine = currentLine.trim();
                    if (trimmedLine.equals(lineToRemove)) continue;
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
                writer.close();
                reader.close();
                boolean successful = tempFile.renameTo(inputFile);
                System.out.println("Removed");
            } else {
                System.out.println("This is not an option please try again");
            }
        } catch (IOException e) {
            System.out.println("An error has occurred I/O error");
        }
    }
}
