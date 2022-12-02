/**
 * Sean McLoughlin
 * HONOR PLEDGE: All work here is honestly obtained and is my own. Sean McLoughlin
 * Date of Completion:  
 * Assignment: Ch11 ArrayList Lab
 * 
 * General Description: manages lines in a text file as an ArrayList of Strings
 */
package InClassAssignments.ArrayLists.Align;
import java.util.ArrayList;
public class LineList {
    public ArrayList<String> lines;
    public LineList(){
        lines=new ArrayList<String>();
    }
    /**
     * returns the number of lines
     * @return
     */
    public int size(){
        return lines.size();
    }
    /**
     * returns the value at a specific index of an array
     * @param k index
     * @return
     */
    public String get(int k){
        return lines.get(k);
    }
    /**
     * appends a line to a list
     * @param line
     */
    public void add(String line){
        lines.add(line);
    }
    /**
     * removes and returns the line at index K
     * @param k line to remove and return
     * @return
     */
    public String remove(int k){
        String rtn=lines.get(k);
        lines.remove(k);
        return rtn;
    }
    /**
     * moves the line at index to the position of newIndex
     * */
    public void move(int index, int newIndex){
        String hold=lines.get(index);
        lines.remove(index);
        lines.add(newIndex, hold);
    }
    /**
     * shuffles the lines of text randomly
     * goes through the whole array and swaps each index with a random index
     */
    public void shuffle(){
        for(int i=0;i<lines.size();i++){
            int place=(int)(Math.random()*lines.size());
            String temp=lines.get(i);
            lines.set(i,lines.get(place));
            lines.set(place,temp);
        }
    }

}
