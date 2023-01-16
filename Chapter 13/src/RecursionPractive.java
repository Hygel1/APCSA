public class towersOfHanoi {
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
}

