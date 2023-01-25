public class RecursionPractive {
    public static void main(String[] args){
        solveToH(61,1,3,2);
    }
    public static void solveToH(int nDisks, int startPeg, int endPeg, int workPeg){
        if(nDisks==1){ //base case
            System.out.println("Move disk from "+startPeg+" to "+endPeg);
        }
        else{ //recursive/general case
        solveToH(nDisks-1, startPeg, workPeg, endPeg);
        System.out.println("Move disk from "+startPeg+" to "+endPeg);
        solveToH(nDisks-1, workPeg, endPeg, startPeg);
    }
    }
    /**
     * base case = when s is shorter than 2 characters wrong
     * returns a reversed String by putting the frontmost character at the end of the returned string in each iteration
     * @param s string to be reversed
     * @return reversed String
     */
    public String someFun(String s){
        if(s.length()>=2) s=someFun(s.substring(1))+s.charAt(0);
        return s;
    }
}

