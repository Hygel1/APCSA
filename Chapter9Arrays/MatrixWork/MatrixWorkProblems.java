public class MatrixWorkProblems {
    public class Color{
        public char state;
        public Color(boolean c){
            if(c) state='x';
            else state=' ';
        }
    }

public static void main(String args[]){

}
public static void q13(){

}
public static double positiveMax(double[][] m){
    double max=0;
    for(int i=0;i<m.length;i++){
        for(int n=0;n<m[i].length;n++){
            max=Math.max(max,m[i][n]);
        }
    }
    return max;
}
public static void fillCheckerboard(Color[][] board){
    for(int i=0;i<board.length;i++){
        for(int n=0;n<board[i].length;n++){
            
        }
    }
}
}