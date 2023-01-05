import java.util.Scanner;
import org.json.JSONObject; //external library that requries path editing
import org.json.JSONArray;
import java.net.*;
import java.io.*;
public class testFile {
    
    public static void main(String[] args){

        System.out.println(getDefinition("hello"));
    }
    public static String getDefinition(String word){
        //URL url=new URL();
      //  StringBuilder builder=new StringBuilder();
       
        String rtn="";
        try {
          BufferedReader urlRead=new BufferedReader(new InputStreamReader(new URL("https://api.dictionaryapi.dev/api/v2/entries/en/"+word+"/").openConnection().getInputStream()));
         // BufferedReader urlRead=new BufferedReader(new InputStreamReader(new URL("http://ergast.com/api/f1/2004/1/results.json").openConnection().getInputStream()));
          StringBuilder sb = new StringBuilder();
          String line;
          String ParsedLine;
        
          while ((line = urlRead.readLine()) != null)
          {
          //  ParsedLine = line.replace("[","").replace("]","");
            sb.append(line);
          }
        //  System.out.println(sb.toString());
          String jsonData = sb.toString();
          JSONObject jso = new JSONObject(jsonData);

          JSONArray resultArr = jso.getJSONArray("results");

          System.out.println(jso.getString("word"));

        } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }


        return rtn;
      }
}
