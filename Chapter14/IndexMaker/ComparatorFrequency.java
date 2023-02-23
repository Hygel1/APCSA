package Chapter14.IndexMaker;

import java.util.Comparator;

public class ComparatorFrequency implements Comparator<IndexEntry>{
    public ComparatorFrequency(){}
    public int compare(IndexEntry o1, IndexEntry o2){
        if(o1.numLines()-o2.numLines()==0) return o1.numLines()-o2.numLines();
        return new ComparatorAlphabetical(false).compare(o1,o2);
    }
}
