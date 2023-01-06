
/**
 * Sean McLoughlin
 * HONOR PLEDGE: All work here is honestly obtained and is my own. Sean McLoughlin
 * Date of Completion:  
 * Assignment: Ch11 IndexMaker
 * 
 * Attribution:
 *  https://dictionaryapi.dev/ - api used to get info
 *  Apache JSONArray library - used to read the JSON input as a JSONArray (note: in order to run this, you need to download the )
 * 
 * 
 * General Description: Prints an index to a given file along with some other information about the contents of the index
 * 
 * Advanced: Accesses a dictionary api to get the definition of words
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
import java.util.ArrayList;
public class IndexMaker
{
  // Create index:
  private static DocumentIndex index = new DocumentIndex();
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
    outputFile.println("Definition of longest word("+index.findLongestWord().getWord()+"): "+getDefinition(index.findLongestWord().getWord()));
    outputFile.println("Definition of most common word ("+index.findMostCommon().getWord()+"): "+getDefinition(index.findMostCommon().getWord()));

    time-=System.currentTimeMillis();
    outputFile.println(fileContents);
    time+=System.currentTimeMillis();
    outputFile.print("Time:"+(double)time/60000+" minutes");
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
  private static ArrayList<String> exclusion=new ArrayList<>(1);
  public static String getDefinition(String word){
    String rtn="";
    try { //Some of these lines throw exceptions, so it is necessary to catch and deal with them accordingly
      BufferedReader urlRead=new BufferedReader(new InputStreamReader(new URL("https://api.dictionaryapi.dev/api/v2/entries/en/"+word).openConnection().getInputStream())); //open connection to api
      StringBuilder sb = new StringBuilder(); //initialize String builder to create storage of JSON
      String line; //temp variable to hold current line of JSON while building its replica
  
      while ((line = urlRead.readLine()) != null)
        sb.append(line); //While there is a line to read, read the next line and add it to the StringBuilder object
      JSONArray jso = new JSONArray(sb.toString()); //Convert the StringBuilder object to an actual String, then make a JSONArray with it (containg the JSONObjects with the necessary info)
      //Traverses the JSONArray to find the first and likely the most relevant definition of the word, it would be possible to find every definition but this would be a lot of excess data
      rtn=jso.getJSONObject(0).getJSONArray("meanings").getJSONObject(0).getJSONArray("definitions").getJSONObject(0).getString("definition");
      //System.out.println(jso.getJSONObject(0).getJSONArray("meanings").getJSONObject(0).getJSONArray("definitions").getJSONObject(0).getString("definition")); //Testing
    } 
    catch (Exception e) { //return error messages if there is an error
      if(e.getClass()==new MalformedURLException().getClass()) rtn="The dictionary api is either down or not connecting";
      else if(e.getClass()==new FileNotFoundException().getClass()){ 
        while(e.getClass()==new FileNotFoundException().getClass()){
          exclusion.add(word);
          System.out.println(index.findLongestWord(exclusion));
          /**
           * This while loop is pretty dumb but I was just using it for testing
           * exclusion is meant to be a list of words not to be used and it works, but findLongestWord is meand to use it as a blacklist,
           * which doesn't work as intended
           * 
           * Just need to get the blacklist and reroll working and it should be fine - necessary patch
           * 
           * 
           * 
           * 
           * 
           */
          
        }
        //if the word cannot be found in the dictionary, exclude it from the count and find the next longest
        rtn="Longest could not be found in dictionary; longest real word: "+rtn;
      }
      else if(e.getClass()==new JSONException(e.getMessage()).getClass()) rtn="Word not found in dictionary";
      else e.printStackTrace();
    }
    return rtn;
  }
}

