
/**
 * File : Main
 * Author: Caleb Rasmussen
 * This file contains the MAIN implementation.
 */


import java.util.Scanner;
import java.io.*;

/**
 * main() runs the menu allowing the user to choose from
 * various options. 
 */
public class Main {
    public static void main(String[] args) {

        // Variables
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        String file_name = "data.txt";
        Paragraph lines = new Paragraph();

        // Runs the menu until the user chooses 6
        while (option != 6) {
            print_menu();

            // Get option number from user
            option = get_num(scanner);

            // Runs the functions based on option 
            switch (option) {
                // Prints the lines
                case 1: 
                        print_lines(lines);
                        break;
                // Adds a line
                case 2: 
                        add_line(scanner, lines);
                        break;
                // Removes last line
                case 3: 
                        undo(lines);
                        break;
                // Saves lines to file
                case 4: 
                    write(lines, file_name);
                        break;
                // Loads line of a file
                case 5: 
                    load(lines, file_name);
                    break;
                // Quits: closes scanner and object
                case 6: 
                        System.out.println("\nExiting...\n");
                        scanner.close();
                        lines = null;
                        break;
                // Catches invalid characters
                default: 
                        System.out.println("\nPlease enter a valid number.");
                        break;
            }
        }
    }

    /**
     * print_menu() displays the 6 menu options for the user to
     * see the different of operations this program offers. 
     */
    public static void print_menu(){
        System.out.println( "\nPlease Choose an Option:"
                            + "\n\t1. Print lines"
                            + "\n\t2. Add a line"
                            + "\n\t3. Undo"
                            + "\n\t4. Save to file"
                            + "\n\t5. Load from file"
                            + "\n\t6. Quit");
    }

    /**
     * print_lines() displays the current lines saved in memory. 
     * @param lines
     */
    public static void print_lines(Paragraph lines){
        // If there are not any lines
        if (lines.length() == 0) {
            System.out.println("\nPlease input lines to display them.");
        }

        // Prints the lines on the screen
        else {
            System.out.println("\nText: ");

            // Loops through lines and prints them 
            for (int i = 1; i <= lines.length(); i++){
                System.out.println(lines.get(i));
            }
        }
    }

    /**
     * get_num() returns an integer obtained from user input.
     * @param scanner
     * @return
     */
    public static int get_num(Scanner scanner) {
        System.out.print("> ");

        // Get number from input
        int num = scanner.nextInt();
        scanner.nextLine();


        return num;
    }

    /**
     * get_string() returns a string obtained from user input.
     * @param scanner
     * @return
     */
    public static String get_string(Scanner scanner) {
        System.out.print("\nPlease input a line: ");
        
        // Get String
        String line = scanner.nextLine();
        
        return line;
    }

    /**
     * add_line() adds a line to the Paragraph with an index. 
     * @param scanner
     * @param lines
     */
    public static void add_line(Scanner scanner, Paragraph lines) {
        String line = get_string(scanner);
        lines.insert((lines.length() + 1), line);
    }

    /**
     * undo() deletes the last line of the Paragraph.
     * @param lines
     */
    public static void undo(Paragraph lines) {
        String old_line = lines.get(lines.length());
        System.out.println("Line: \"" + old_line + "\" has been removed.");

        // Removes last line
        lines.remove(lines.length());
    }

    /**
     * write() saves all the lines to a file. 
     * @param lines
     * @param file_name
     */
    public static void write(Paragraph lines, String file_name) {
        // Try to open file and write data
        try {
            FileWriter writer = new FileWriter(file_name);

            // Writes each line to file
            for (int i = 1; i <= lines.length(); i++) {
                writer.write(lines.get(i));
                writer.write("\r\n");   // writes new line
            }

            writer.close();

            System.out.println("\nSuccessfully wrote lines to " + file_name);
        }
        // Catches file errors
        catch (IOException e) {
            System.out.println("Error: fail to write to " + file_name);
            e.printStackTrace(); 
        }
    }

    /**
     * load() reads lines of a file into a Paragraph.
     * @param lines
     * @param file_name
     */
    public static void load(Paragraph lines, String file_name) {
        // Trys to open file and read lines into a Paragraph
        try  {  
            BufferedReader reader;
            reader = new BufferedReader(new FileReader(file_name));
            String line = reader.readLine();
            int count = 1;

            // While there is a line, adds it to Paragraph
            while (line != null) {
                lines.insert(count, line);
                line = reader.readLine();
                count++;
            }

            reader.close();
            reader= null;

            print_lines(lines);
        } 
        // Catches file errors
        catch(IOException e)  { 
            System.out.println("Error: fail to read " + file_name);
            e.printStackTrace(); 
        }
    }
}