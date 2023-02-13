package Chapter14.Ch12and14Bookwork;

public class Haiku extends Poem{
    private int[] s={5,7,5};
    public int numLines(){
        return 3;
    }
    public int getSyllables(int k){
        return s[k];
    }
}
