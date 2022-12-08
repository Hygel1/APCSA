import java.util.ArrayList;
public class IndexEntry {
    private String word;
    private ArrayList<Integer> numList;
    public IndexEntry(String name){
        word=name.toUpperCase();
    }
    public void add(int num){
        numList.add(num);   
    }
    public String getWord(){
        return word;
    }
    public String toString(){
        return word+" "+numList;
    }
}
