package Chapter14.Ch12and14Bookwork;

public class Limerick extends Poem{
    private int[] s={9,9,6,6,9};
    public int numLines(){
        return 5;
    }
    public int getSyllables(int k){
        return s[k];
    }
}
