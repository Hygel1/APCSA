import java.util.ArrayList;
public class DocumentIndex extends ArrayList<IndexEntry> {
    public DocumentIndex(){
        super(); //since DocumentIndex extends ArrayList<IndexEntry>, super() invokes an ArrayList<IndexEntry> for us
    }
    public DocumentIndex(int num){
        super(num);
    }
    /**
     * add a found word to the list of found words taking the word and its line
     * @param word
     * @param line
     */
    public void addWord(String word, int line){
        get(foundOrInserted(word)).addLineNum(line);
        //try{get(foundOrInserted(word)).addLineNum(line);} catch(NullPointerException e){System.out.println(e);}
    }
    /**
     * adds all word to list, separating them using .split
     * @param str
     * @param line
     */
    public void addAllWords(String str,int line){
        for(String word: str.split("\\W+")){
            if(word.length()>0) addWord(word, line);
        }
    }
    /**
     * finds duplicate words in the created list. If the word being searched for is already in the list, the line number is added to the existing entry, otherwise the optimal index is returned
     * @param word
     * @return
     */
    public int foundOrInserted(String word){
        //this.compareTo(other)>0 is the same as this > other
        for(int i=0;i<size();i++){
            String cpm2=get(i).getWord();
            int cmp=cpm2.compareToIgnoreCase(word);
             if(cmp>0){add(i,new IndexEntry(word)); return i;}if(cmp==0) return i;
        }
        add(new IndexEntry(word)); //add to the end
        return size()-1; //if it gets to the end without finding a solution, the word belongs at the end of the list   
    }
}