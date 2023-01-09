/**
 * This program takes a text file, creates an index (by line numbers)
 *  for all the words in the file and writes the index
 *  into the output file.  The program takes input and output file names
 *  from the command-line args or prompts the user for the file names.
 */
import java.util.Scanner;
import java.net.*;
import java.io.*;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.Arrays;
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
    outputFile.println("Number of distinct words: "+index.size());
    outputFile.println("Shortest meaningful word: "+index.findShortestWord().getWord());
    outputFile.println("Longest word: "+index.findLongestWord().getWord());
    outputFile.println("Least frequent word: "+index.findLeastCommon().getWord());
    outputFile.println("Most frequent word: "+index.findMostCommon().getWord());
    outputFile.println("Definition of longest word("+index.findLongestWord().getWord()+"): "+longDef());
    outputFile.println("Definition of most common word ("+index.findMostCommon().getWord()+"): "+getDefinition(index.findMostCommon().getWord()));

    time-=System.currentTimeMillis();
    outputFile.println(fileContents);
    time+=System.currentTimeMillis();
    outputFile.print("Runtime for indexing:"+(double)time/60000+" minutes");
    
    // Finish and close objects:
    inputFile.close();
    outputFile.close();
    keyboard.close();
    System.out.println("Done.");
  }
  
  /**
   * finds the definition of the longest word using getDefinition
   * @return
   */
  private static ArrayList<String> exclusion=new ArrayList<>(1); //used to track undefinable words
  /*private static String longDef(){
    Object rtn=getDefinition(index.findLongestWord(exclusion).getWord());//Find the definition of the longest word, excluding previously established non-words (if there is no definition available, an error is returned)
    if(rtn.getClass()==String.class) return rtn.toString(); //If the returned Object is a String, not an error, return that
    //System.out.println(rtn.getClass().toString());  
    /**
       * If the word searched for is not in the dictionary, search for the longest real word
       * in the event of several nonreal words, the method will have recursed, increasing the size of stacktrace. This can be used to determine whether or not to add the front statement to the returned value (Longest could...)
       *
      exclusion.add(index.findLongestWord(exclusion).getWord()); //If the returned Object is an error (not String), add it to the list and keep moving
      //System.out.println(Arrays.toString((Thread.currentThread().getStackTrace())));
      if(Thread.currentThread().getStackTrace().length>3) return longDef(); //if needed, recurse the method
      else return "Longest could not be found in dictionary; definition of longest real word: "+longDef(); //if needed, recurse the method with front statement
  } */
  private static String longDef(){
    Object rtn=getDefinition(index.findLongestWord(exclusion).getWord());//Find the definition of the longest word, excluding previously established non-words (if there is no definition available, an error is returned)
    while(rtn.getClass()!=String.class){
      exclusion.add(index.findLongestWord(exclusion).getWord());
      rtn=getDefinition(index.findLongestWord(exclusion).getWord());
    }
    if(exclusion.size()>0) return "Longest could not be found in dictionary; longest real word def: "+rtn.toString();
    return rtn.toString(); //If the returned Object is a String, not an error, return that

  }
  /**
   * finds the definition of the given word using Free Dictionary API, an open source dictionary api created by meetDeveloper on GitHub
   * Takes in JSON from the api and traverses it to get to the first, and likely most relevant definition of the word 
   * @param word word to be found
   * @return
   */
  public static Object getDefinition(String word){
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
      if(e.getClass()==new MalformedURLException().getClass()) return "The dictionary api is either down or not connecting";
      else if(e.getClass()==new FileNotFoundException().getClass()) return new Exception();
      else if(e.getClass()==new JSONException(e.getMessage()).getClass()) return "JSONException error, likely a malformed JSON response";
      else e.printStackTrace();
    }
    return rtn;
  }
}

