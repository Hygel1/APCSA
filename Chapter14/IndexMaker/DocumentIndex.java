package Chapter14.IndexMaker;

/**
 * Sean McLoughlin
 * HONOR PLEDGE: All work here is honestly obtained and is my own. Sean McLoughlin
 * Date of Completion:  1/8/2023
 * Assignment: Ch11 IndexMaker
 * 
 * Attribution:
 *  http://blog.vogella.com/2014/10/22/accessing-the-caller-information-of-a-method-in-java-code/#:~:text=Sometimes%20it%20is%20nice%20to,method%20on%20the%20current%20thread - how to use stacktrace
 *  https://dictionaryapi.dev/ - api used to get info
 *  https://github.com/stleary/JSON-java - library used to interact with JSON (must be installed in classpath to run file, download is the first link in README)
 * 
 * General Description:
 *  Creates and prints an index to the given file, processing it line by line.
 *  A new word is created upon the occurence of a unique trimmed string of words, excluding anything that begins with
 *  a nonletter character - punctuation and numbers are excluded this way. The data is stored in a StringBuilder object
 *  and outputted to the file when the StringBuilder is fully built. The whole text only has to be passed through once but the 
 *  index must be passed through multiple times in order to complete all tasks. The timer counts the total runtime for basic 
 *  indexing functions (building and printing the index), excluding the time taken to process metadata because the time taken
 *  to repeatedly reach the api would significantly increase the time.
 * 
 * runtime on war and peace: 2.05 Minutes
 * runtime on odyssey: .12 minutes
 * 
 * Advanced: Accesses a dictionary api to get the definition of words
 */
import java.util.ArrayList;
public class DocumentIndex extends ArrayList<IndexEntry> {
    private String[] noSig={"it","the","they","he","she","them","him","his","a"};
    public DocumentIndex(){
        super(); //since DocumentIndex extends ArrayList<IndexEntry>, super() invokes an ArrayList<IndexEntry> for us
    }
    public DocumentIndex(int num){
        super(num);
    }
    public DocumentIndex(DocumentIndex d){
        super(d.size());
        for(int i=0;i<d.size();i++){
            add(d.get(i));
        }
    }
    int style;
    public void setStyle(int num){
        style=num;
    }
    /**
     * add a found word to the list of found words taking the word and its line
     * @param word
     * @param line
     */
    public void addWord(String word, int line){
            if(Character.isLetter(word.charAt(0))) get(foundOrInserted(word)).addLineNum(line);
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
            String cpm2=get(i).getWord();int cmp;
            cmp=cpm2.compareToIgnoreCase(word);
             if(cmp>0){add(i,new IndexEntry(word)); return i;}
             if(cmp==0) return i;
        }
        add(new IndexEntry(word)); //add to the end
        return size()-1; //if it gets to the end without finding a solution, the word belongs at the end of the list   
    }
    /**
     * finds the longest word in the list by running through the list and comparing to the current longest (ind)
     * @return
     */
    public IndexEntry findLongestWord(){
        int ind=0,indL=get(0).getWord().length(); //ind to hold index, indL to hold the longest length (prevents repeat operations)
        for(int i=1;i<size();i++){
            if(get(i).getWord().length()>indL){
                indL=get(i).getWord().length();
                ind=i;
            }
        }
        return get(ind);
    }
    /**
     * finds the longest word excluding words that are in exclude
     * @param exclude
     * @return
     */
    public IndexEntry findLongestWord(ArrayList<String> exclude){
        int ind=0,indL=get(0).getWord().length(); //ind to hold index, indL to hold the longest length (prevents repeat operations)
        for(int i=1;i<size();i++){
            if(!exclude.contains(get(i).getWord())&&get(i).getWord().length()>indL){
                indL=get(i).getWord().length();
                ind=i;
            }
        }
        return get(ind);
    }
    /**
     * returns true if word is equal to an element of arr and false otherwise
     * @param arr
     * @param word
     * @return
     */
    public boolean contains(String[] arr, String word){
        for(String el: arr) if(word.equals(el)) return true; return false;
    }
    /**
     * finds the shortest word in the list by running through the list and comparing to the current shortest (ind)
     * @return
     */
    public IndexEntry findShortestWord(){
        int ind=0,indL=get(0).getWord().length();
        for(int i=1;i<size();i++){
            if(!contains(noSig,get(i).getWord())&&get(i).getWord().length()<indL){
                indL=get(i).getWord().length();
                ind=i;
            }
        }
        return get(ind);
    }
    /**
     * finds the word with the most line numbers associated with it
     * @return
     */
    public IndexEntry findMostCommon(){
        int ind=0, indL=get(0).numLines();
        for(int i=1;i<size();i++){
            if(!contains(noSig,get(i).getWord())&&indL<get(i).numLines()){
                indL=get(i).numLines();
                ind=i;
            }
        }
        return get(ind);
        }
        /**
         * finds the word with the least line numbers associated with it
         * the lowest possible number is 1 line, otherwise there should be no index -- because of this, the first instance of 1 occurence is returned if found
         * @return
         */
        public IndexEntry findLeastCommon(){
            int ind=0, indL=get(0).numLines();
            for(int i=1;i<size();i++){
                if(get(i).numLines()==0) return get(i);
                if(get(i).numLines()<indL){
                    ind=i;
                    indL=get(i).numLines();
                }
            }
            return get(ind);
        }
        public String toString(){
            String rtn="";
            for(int i=0;i<size();i++){
                rtn+=get(i).getWord()+"("+get(i).numLines()+"), "; //returns each entry with its word and the number of lines it appears in
            }
            return rtn;
        }
        
    }