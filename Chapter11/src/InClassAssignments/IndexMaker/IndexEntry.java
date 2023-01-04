import java.util.ArrayList;
public class IndexEntry {
    private String word;
    private ArrayList<Integer> numList;
    //constructor to make an empty entry
    public IndexEntry(String name){
        word=name.toUpperCase();
        numList=new ArrayList<>();
    }
    //constructor to make an indexEntry with one existing line
    public IndexEntry(String name, int line){
        word=name.toUpperCase();
        numList=new ArrayList<>();
        numList.add(line);
    }
    //adds a line number to an entry
    public void addLineNum(int num){
        numList.add(num);   
    }
    //returns the entry's word in String form
    public String getWord(){
        return word;
    }
    public int numLines(){
        return numList.size();
    }
    //parses the entry as a readable String
    public String toString(){
        return word+" "+numList.toString().substring(1,numList.toString().length()-1);
    }
}
