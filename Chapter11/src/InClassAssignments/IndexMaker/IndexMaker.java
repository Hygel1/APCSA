
/**
 * Sean McLoughlin
 * HONOR PLEDGE: All work here is honestly obtained and is my own. Sean McLoughlin
 * Date of Completion:  
 * Assignment: Ch11 IndexMaker
 * 
 * Attribution: 
 * 
 * General Description: Prints an index to a text file in another file with a given name
 * 
 * Advanced: 
 */
/**
 * This program takes a text file, creates an index (by line numbers)
 *  for all the words in the file and writes the index
 *  into the output file.  The program takes input and output file names
 *  from the command-line args or prompts the user for the file names.
 */
import java.util.Scanner;
import org.json.JSONObject; //external library that requries path editing
import java.net.*;
import java.io.*;

public class IndexMaker
{
  public static void main(String[] args) throws IOException
  {
    Scanner keyboard = new Scanner(System.in);
    String fileName;

    // Open input file:
    if (args.length > 0) fileName = args[0];
    else{
      System.out.print("\nEnter input file name: ");
      fileName = keyboard.nextLine().trim(); //defines fileName using user input
    }
    BufferedReader inputFile = new BufferedReader(new FileReader(fileName), 1024); //reader for incoming data

    // Create output file:
    if (args.length > 1) fileName = args[1];
    else{
      System.out.print("\nEnter output file name: ");
      fileName = keyboard.nextLine().trim();
    }
    PrintWriter outputFile = new PrintWriter(new FileWriter(fileName));

    // Create index:
    DocumentIndex index = new DocumentIndex();

    long time=System.currentTimeMillis();
    String line;
    int lineNum = 0;
    while ((line = inputFile.readLine()) != null){
      lineNum++;
      index.addAllWords(line,lineNum);
    }
    //output required statistics or details  
    time=System.currentTimeMillis()-time; //final runtime used
    outputFile.println("File Name: "+fileName);
    outputFile.println("Runtime: "+time);
    outputFile.println();

    // Save index:
    for (IndexEntry entry : index)
      outputFile.println(entry);
    
    // Finish:
    inputFile.close();
    outputFile.close();
    keyboard.close();
    System.out.println("Done.");
  }
  public String getDefinition(String word) throws MalformedURLException{
    //URL url=new URL();
    JSONObject jso;
    String rtn="";
    try {
      BufferedReader urlRead=new BufferedReader(new InputStreamReader(new URL("https://api.dictionaryapi.dev/pai/v2/entries/en/"+word).openConnection().getInputStream()));
      jso=new JSONObject(urlRead.readLine());
      rtn=jso.getString("word");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return rtn;
  }
}

