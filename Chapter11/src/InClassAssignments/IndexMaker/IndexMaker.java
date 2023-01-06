
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
import org.json.JSONArray;
import org.json.JSONException;

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
    // Save index and print to file:
    String fileContents="";
    for (IndexEntry entry : index) fileContents+="\n"+entry;
    time=System.currentTimeMillis()-time;
      //outputFile.println(entry);
    
      //output required statistics/details  
    outputFile.println("File Name: "+fileName);
    outputFile.println("Runtime: "+time);
    outputFile.println("Number of distinct words: "+index.size());
    outputFile.println("Shortest meaningful word "+""); //define meaningful in method first
    outputFile.println("Longest word: "+index.findLongestWord().getWord());
    outputFile.println("Least frequent word: "+index.findLeastCommon().getWord());
    outputFile.println("Most frequent word: "+index.findMostCommon().getWord());
    outputFile.println("Definition of longest word: "+getDefinition(index.findLongestWord().getWord()));
    outputFile.println("Definition of most common word: "+getDefinition(index.findMostCommon().getWord()));

    time-=System.currentTimeMillis();
    outputFile.print(fileContents);
    time+=System.currentTimeMillis();

    // Finish and close objects:
    
    inputFile.close();
    outputFile.close();
    keyboard.close();
    System.out.println("Done.");
  }
  /**
   * finds the definition of the given word using Free Dictionary API, an open source dictionary api created by meetDeveloper on GitHub
   * Takes in JSON from the api and traverses it to get to the first, and likely most relevant definition of the word 
   * @param word word to be found
   * @return
   */
  public static String getDefinition(String word){
    String rtn="";
    try { //Some of these lines throw exceptions, so it is necessary to catch and deal with them accordingly
      BufferedReader urlRead=new BufferedReader(new InputStreamReader(new URL("https://api.dictionaryapi.dev/api/v2/entries/en/"+word).openConnection().getInputStream())); //open connection to api
      StringBuilder sb = new StringBuilder(); //initialize String builder to create storage of JSON
      String line; //temp variable to hold current line of JSON while building its replica
  
      while ((line = urlRead.readLine()) != null) //While there is a line to read, read the next line and add it to the StringBuilder object
      {
        sb.append(line);
      }
      JSONArray jso = new JSONArray(sb.toString()); //Convert the StringBuilder object to an actual String, then make a JSONArray with it (containg the JSONObjects with the necessary info)
      //Traverses the JSONArray to find the first and likely the most relevant definition of the word, it would be possible to find every definition but this would be a lot of excess data
      rtn=jso.getJSONObject(0).getJSONArray("meanings").getJSONObject(0).getJSONArray("definitions").getJSONObject(0).getString("definition");
      //System.out.println(jso.getJSONObject(0).getJSONArray("meanings").getJSONObject(0).getJSONArray("definitions").getJSONObject(0).getString("definition")); //Testing
    } 
    catch (Exception e) { //for other exceptions, print the issue
      
      if(e.equals(new MalformedURLException())) rtn="The dictionary api is either down or not connecting";
      else if(e.equals(new JSONException(e))||e.equals(new FileNotFoundException())) rtn="Word not found in dictionary";
      else e.printStackTrace();
    }
    return rtn;
  }
}

