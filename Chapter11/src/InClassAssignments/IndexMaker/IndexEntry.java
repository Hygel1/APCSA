import java.util.ArrayList;
public class IndexEntry {
    private String word;
    private ArrayList<Integer> numList;
    public IndexEntry(String name){
        word=name.toUpperCase();
    }
    public IndexEntry(String name, int line){
        word=name.toUpperCase();
        numList.add(line);
    }
    public void addLineNum(int num){
        numList.add(num);   
    }
    public String getWord(){
        return word;
    }
    public String toString(){
        return word+" "+numList;
    }
}
