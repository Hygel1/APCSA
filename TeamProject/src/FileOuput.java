/**
 * Name(s): Grace Boerner, Gracie Stokes, Sean McLoughlin
 * 
 * HONOR PLEDGE: All work here is honestly obtained and is my own. Sean McLoughlin, Grace Boerner, Gracie Stokes
 * Date of Completion: 8/26/2022
 * Assignment: Team Programming Assignment
 * 
 * Attribution: https://www.geeksforgeeks.org/why-is-scanner-skipping-nextline-after-use-of-other-next-functions/ - Used to correct Scanner not skipping to next line after reading data
 * 
 * General Description: Takes data using console prompts and converts answers to String values using FileOutputEC Class, then writes String values in a file
 * 
 * Advanced: Takes the user's answer to "Do you like ice cream" as a String and converts it to a boolean based on the answer given
 * 
 * Errata:  
 *
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileOuput {
    private static String name; //String value to hold the user's name
    private static int age; //Integer value to hold user's age
    private static double favoriteDecimal; //Double value to hold user's favorite decimal number
    private static boolean likesIceCream; //Boolean value to hold whether or not the user likes Ice cream
    private static char favoriteLetter; //Char value to hold the user's favorite letter
    private static Scanner scan=new Scanner(System.in); //Initializing the scanner

    private static String fileName="output.txt"; //String value to hold the output file name
    public static void main(String[] args) throws IOException{
        File outputFile=new File(fileName);
        
    /**
     * Takes data using dataCollection() and feeds it into FileOutputEC to be converted to a String, which is written to the file using PrintWriter
     * Realistically, this would be better suited in main rather than as its own method
     */
    try{ //used to handle FileWriter throwing IOException since it doesn't actually cause any program-breaking errors
        PrintWriter writer=new PrintWriter(new FileWriter(fileName)); //Initializes Printwriter
        System.out.print("How many students are there: ");
        int numStudents=scan.nextInt();
        scan.nextLine();
        for(int i=0;i<numStudents;i++){ //repeat prompted number of times
            dataCOllection(); //Collect Data using user prompts
            writer.println(new FileOutputEC(name, age, favoriteDecimal, likesIceCream, favoriteLetter)); //Feeds data collected from dataCollection() into FileOutputEC to be converted to String and prints it to file using PrintWriter
            }
        writer.close(); //Closes PrintWriter before leaving method
    }
    catch(IOException e){}
        scan.close(); //Closes scanner before ending the program
    }
    
    /**
     * Method to read user's inputted data to be fed to FileOutputEC class
     * Uses console to prompt user and Scanner to collect data
     */
    private static void dataCOllection(){
        System.out.print("What is your name: "); //
        name=scan.nextLine(); //uses scanner to take user's name as a String
        System.out.print("How old are you: ");
        age=scan.nextInt(); //Uses scanner to read user's age as an int
        scan.nextLine(); //Allows scanner to skip to next line
        System.out.print("What is your favorite decimal: ");
        favoriteDecimal=scan.nextDouble(); //Uses scanner to read user's favorite decimal as a double
        scan.nextLine(); //Allows scanner to skip to next line
        System.out.print("True or false do you like Ice Cream: ");
        /*String tempHold=scan.nextLine().toLowerCase(); //Holds user's answer as a String to interpret it later 
        if(tempHold.equals("yes")||tempHold.equals("yeah")||tempHold.equals("true")) likesIceCream=true; //If user answers "yes", "yeah", or "true," likesIceCream is set to true
        else likesIceCream=false; //All other answers set likesIceCream to false  */
        likesIceCream= scan.nextBoolean();
        scan.nextLine(); 
        System.out.print("What is your favorite letter: ");
        favoriteLetter=scan.nextLine().charAt(0); //Takes only the first non-space character in read string
    }
}
