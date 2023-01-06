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
    public IndexEntry findLongestWord(ArrayList<String> exclude){
        int ind=0,indL=get(0).getWord().length(); //ind to hold index, indL to hold the longest length (prevents repeat operations)
        for(int i=1;i<size();i++){
            if(exclude.contains(get(i).getWord())&&get(i).getWord().length()>indL){
                System.out.println("found something");
                indL=get(i).getWord().length();
                ind=i;
            }
        }
        return get(ind);
    }
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
            if(get(i).getWord().length()<indL){
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
            if(indL<get(i).numLines()){
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
        
    }