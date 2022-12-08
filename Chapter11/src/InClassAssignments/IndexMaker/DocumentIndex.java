import java.util.ArrayList;
public class DocumentIndex extends ArrayList<IndexEntry> {
    private ArrayList<String> words=new ArrayList<>();
    public DocumentIndex(){
        super(); //since DocumentIndex extends ArrayList<IndexEntry>, super() invokes an ArrayList<IndexEntry> for us
    }
    public DocumentIndex(int num){
        super(num);
    }
    public void addWord(String word, int line){
        if(words.contains(word)) get(words.indexOf(word)).add(line);
        else for(int i=0;i<)
    }

}
