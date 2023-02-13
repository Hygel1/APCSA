package Chapter14.Ch12and14Bookwork;

public abstract class Poem {
    public abstract int numLines();
    public abstract int getSyllables(int k);
    public void printRhythm(){
        for(int i=0;i<numLines();i++){
            int nS=getSyllables(i);
            for(int n=0;n<nS;n++){
                if(n==nS-1) System.out.println("ta");
                else System.out.print("ta-");
            }
        }
    }
}
