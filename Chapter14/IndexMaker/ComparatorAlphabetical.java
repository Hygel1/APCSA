package Chapter14.IndexMaker;
import java.util.Comparator;
public class ComparatorAlphabetical implements Comparator<IndexEntry>{
    private int t=1;
    /**
     * 
     * @param thisBooleanMakesTheOtherVariableNegativeSoThatItCanDoCompareInOneLine
     */
    public ComparatorAlphabetical(boolean thisBooleanMakesTheOtherVariableNegativeSoThatItCanDoCompareInOneLine){
        if(thisBooleanMakesTheOtherVariableNegativeSoThatItCanDoCompareInOneLine) t=-1;
    }
    public int compare(IndexEntry o1, IndexEntry o2){
        return o1.getWord().compareTo(o2.getWord())*t;
    }
}