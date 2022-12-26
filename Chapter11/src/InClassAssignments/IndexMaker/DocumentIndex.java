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
        try{get(foundOrInserted(word)).addLineNum(line);} catch(NullPointerException e){System.out.println(e);}
    }
    /**
     * adds all words to the list by finding where the word ends and calling addWord() with the found word
     * @param str
     * @param line
     */
    public void addAllWords(String str,int line){
        int end;
        while(str.length()>0){
            end=0;
            while(end<str.length()&&Character.isLetter((str.charAt(end)))) end++;
            addWord(str.substring(0,end),line);
            while(end<str.length()&&!Character.isLetter(str.charAt(end))) end++;
            str=str.substring(end);
        }
    }
    public void addAllWordsSplit(String str,int line){
        for(String word: str.split("\\W+")){
            if(word.length()>0) addWord(word, line);
        }
    }
    public int foundOrInserted(String word){
        //this.compareTo(other)>0 is the same as this > other
        for(int i=0;i<size();i++){
            if(get(i).toString().equalsIgnoreCase(word)) return i;
            else if(get(i).toString().compareToIgnoreCase(word)>0){
                add(i,new IndexEntry(word));
                return i;
            }
        }
        add(new IndexEntry(word)); //add to the end
        return size()-1; //if it gets to the end without finding a solution, the word belongs at the end of the list   
    }
}