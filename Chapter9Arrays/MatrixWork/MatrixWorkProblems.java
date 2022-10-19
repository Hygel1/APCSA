import java.util.Arrays;
public class MatrixWorkProblems {
public static void main(String args[]){
    Color[][] box=new Color[3][3];
    fillCheckerboard(box);
    printCheckerboard(box);
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
public static class Color{
    char rtn;
    public Color(boolean c){
        if(c) rtn='x';
        else rtn='.';
    }
    public String toString(){
        return rtn+"";
    }
}
public static void fillCheckerboard(Color[][] board){
    for(int i=0;i<board.length;i++){
        for(int n=0;n<board[i].length;n++){
            if(i%2==0){
                if(n%2==0)board[i][n]=new Color(true);
                else board[i][n]=new Color(false);
            }
            else{
                if(n%2==0)board[i][n]=new Color(false);
                else board[i][n]=new Color(true);
            }
        }
    }
}
public static void printCheckerboard(Color[][] board){
    for(int i=0;i<board.length;i++){
        for(int n=0;n<board[i].length;n++){
            System.out.print(board[i][n]+" ");
        }
        System.out.println();
    }
}
}