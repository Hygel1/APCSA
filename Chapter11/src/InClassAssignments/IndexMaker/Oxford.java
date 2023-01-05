import  javax.net.ssl.HttpsURLConnection;
import  java.io.BufferedReader;
import  java.io.IOException;
import  java.io.InputStreamReader;
import  java.net.URL;
import org.json.JSONObject;
import org.json.JSONArray;
 public class Oxford {
      public static void main(String[] args) {
       final String language = "en";
       final String word = "Ace";
       final String fields = "definitions";
       final String strictMatch = "false";
       final String word_id = word.toLowerCase();
       final String restUrl = "https://od-api.oxforddictionaries.com:443/api/v2/entries/" + language + "/" + word_id + "?" + "fields=" + fields + "&strictMatch=" + strictMatch;
        final String app_id = "32495243";
       final String app_key = "c1b47a135e3d6d99229b4405e89daf44"; 
       try {
         URL url = new URL(restUrl);
         HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
         urlConnection.setRequestProperty("Accept", "application/json");
         urlConnection.setRequestProperty("app_id", app_id);
         urlConnection.setRequestProperty("app_key", app_key);

         // read the output from the server
         BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
         StringBuilder stringBuilder = new StringBuilder();
         String line = null;
         while ((line = reader.readLine()) != null) {
             stringBuilder.append(line + "\n");
        }
         //System.out.println(stringBuilder.toString());
         JSONObject obj=new JSONObject(stringBuilder.toString());
         System.out.println(obj.getJSONArray("results").getJSONObject(2).getJSONObject("entries"));
      } catch (IOException e) {
         e.printStackTrace();
      }
    }
}