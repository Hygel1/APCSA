package InClassAssignments.Chapter11Bookwork;
import java.util.ArrayList;
public class ch11HW {
    public static void main(String args[]){
        
    }
    public static final String alphabet="abcdefghijklmnopqrstuvwxyz";
    /**
     * sorts an ArrayList of Strings in individual "buckets" that contain only Strings that start with a specific letter
     * buckets are sorted in alphabetical order according to their index
     * @param words initial ArrayList of Strings to be sorted
     * @return returns a 2d ArrayList of Strings sorted in alphabetical order
     */
    public static ArrayList<ArrayList<String>> fillBuckets(ArrayList<String> words){
        ArrayList<ArrayList<String>> rtn=new ArrayList<>(26);//list of 26 undeclared buckets (size=0)
        for(int i=0;i<26;i++){ //becaues each bucket starts at null, we have to declare each one individually
            rtn.add(new ArrayList<String>());
        }
        for(String word: words){ //visits every word and copies it into its "bucket"
            rtn.get(alphabet.indexOf(word.charAt(0))).add(word); //instead of the alphabet String and using indexOf(), we could use Character.getNumericalValue(char)
        }
        return rtn;
    }
}
