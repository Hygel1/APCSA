/**
 * Sean McLoughlin
 * HONOR PLEDGE: All work here is honestly obtained and is my own. Sean McLoughlin
 * Date of Completion: 10/19/2022
 * Assignment: Matrix Work Teamwork
 * 
 * Attribution: 
 * 
 * General Description: problems #13-20 in Ch. 9 of textbook
 * 
 * Advanced: 
 * 
 * Errata: 
 */
import java.util.Arrays;
public class MatrixWorkProblems {
public static void main(String args[]){
    int[][] m1={
        {1,2},
        {3,4}};
    int[][] m2={
        {1,2,3},
        {4,5,6}};
        printArray(matrixMultiplication(m1, m2));

}
private static void testMethod(){
    
}
private static void printArray(int[][] m){
    for(int[] i:m){
        for(int n:i){
            System.out.print(n+" ");
        }
        System.out.println();
    }
}
private static int[][] addMatrices(int[][] m1, int[][] m2){
    int[][] rtn=new int[m1.length][m1[0].length];
    if(isSquare(m1)&&isSquare(m2)){
        for(int i=0;i<m1.length;i++){
            for(int n=0;n<m1[0].length;n++){
                rtn[i][n]=m1[i][n]+m2[i][n];
            }
        }
    }
    return rtn;
}
private static int[][] matrixMultiplication(int[][] m1, int[][] m2){
    int[][] rtn=new int[m1.length][m2[0].length]; //hold array to be returned
    if(isSquare(m1)&&isSquare(m2)){ //if arrays are able ot be matrices (all rows are the same length)
        for(int i=0;i<rtn.length;i++){ //traverse the array
            for(int n=0;n<rtn[0].length;n++){ //traverse the array
                int hold=0; //reset the value for the next index of the returned array
                for(int q=0;q<m1.length;q++){ //go across m1 and down m2 using the same variable
                    hold+=m1[i][q]*m2[q][n]; //Add to the value to be used in the returned array
                }
                rtn[i][n]=hold; //set the rtn value to the found value
            }
        }
    }
    return rtn;
}
public static boolean isSquare(int[][] m){
    int length=m[0].length;
    for(int i=0;i<m.length;i++){
        if(m[i].length!=length) return false;
    }
    return true;
}
//returns if the given index is on either diagonal of a square array
private static boolean q13(int[][] arr, int i, int j){
    return i==j||arr.length-1==i+j;
}
//returns the highest positive number in the array, if no positive numbers, returns 0
private static double positiveMax(double[][] m){
    double max=0;
    for(int i=0;i<m.length;i++){
        for(int n=0;n<m[i].length;n++){
            max=Math.max(max,m[i][n]);
        }
    }
    return max;
}
//nested class to represent color in fillCheckerboard() and printCheckerboard()
private static class Color{
    char rtn;
    public Color(boolean c){
        if(c) rtn='x';
        else rtn='.';
    }
    public String toString(){
        return rtn+"";
    }
}
//Fills a 2d array of Color to create an alternating pattern
private static void fillCheckerboard(Color[][] board){
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
//prints the array created in fillCheckerboard to console
private static void printCheckerboard(Color[][] board){
    for(int i=0;i<board.length;i++){
        for(int n=0;n<board[i].length;n++){
            System.out.print(board[i][n]+" ");
        }
        System.out.println();
    }
}
//returns true if for at least half of the elements in m2, the element in the identical index of m1 is greater
private static boolean covers(double[][] m1, double[][] m2){
    int hold=0;
    for(int i=0;i<m1.length;i++){
        for(int n=0;n<m1[i].length;i++){
            if(m1[i][n]>m2[i][n]) hold++;
        }
    }
    return hold>((double)m1.length*m2.length/2)+.5;
}
//returns true if each value of the arary is different ranging from 1-the number of elements and the sum of each row/col/diagonal is equal
private static boolean isMagicSquare(int m[][]){
    if(m.length==m[1].length){
        int num=0;
        int current=0;
        int current2=0;
        for(int i=0;i<m.length;i++){
            num+=m[0][i];
        }
        for(int i=0;i<m.length;i++){
            for(int n=0;n<m.length;n++){
                current+=m[i][n];
                current2+=m[n][i];
            }
            if(current!=num||current2!=num) return false;
            current=0;
            current2=0;
        }
        for(int i=0;i<m.length;i++){
            current=m[i][i];
            current2=m[m.length-1-i][m.length-1-i];
        }
        if(current!=num||current2!=num) return false;
        return true;
    }
    return false;
}
//nested class to represent location in areAdjacent()
public static class Location{
    private int rows;
    private int cols;
    public Location(int row, int col){
        rows=row;
        cols=col;
    }
    public int getRow(){
        return rows;
    }
    public int getCol(){
        return cols;
    }
}
//returns true if two Location values are next to each other in either their column or row
private boolean areAdjacent(Location loc1, Location loc2){
    return Math.abs(loc1.getRow()-loc2.getRow())<2||Math.abs(loc1.getCol()-loc2.getCol())<2;
}
//returns true if the bordering numbers count up to a certain number and all other numbers not included in this sequance are 0
private boolean isSnake(int[][] m){
    int zeroes=0; //numbner of zeros in the array
    int num=0; //highest number found in the snake pattern
    boolean found=false;
    int size=0;
    for(int i=0;i<m.length;i++){
        size+=m[i].length; //square array is not guaranteed so we need to find the number of values in the aray with a loop
    }
    for(int i=0;i<m.length;i++){ //looop through the whole array
        for(int n=0;n<m[i].length;n++){
            if(m[i][n]==0) zeroes++; //count the number of zeros in the array
            else if(!found&&m[i][n]==num+1){
                num++; //sets the num value to track the snake pattern with
                found=true; //after finding the first 1's index, the snake pattern follower can no longer be restarted
                int iLim=i; int nLim=n; //Allows for the for loops to be changed when a new value is found
                for(int q=i-1;q<iLim+2;q++){ //searches the "box" surrounding the index of the found value (similar to gameOfLife)
                    for(int a=n-1;a<nLim+2;a++){
                        if(q>-1&&q<m.length&&a>-1&&a<m[q].length&&m[q][a]==num+1){
                            iLim=q;nLim=a; //resets all parts of the for loop to begin considering the values around the found value
                            q--;a--;num++; //q and a are reduced to restart at the top left of the found value; num is increased to look for the next number
                        }
                    }
                }
            }
            //else if(m[i][n]==1) return false; //should be handled by final return but there could be an error resulting from multiple 'heads' to the snake
        }
    }
    return size==zeroes+num; //values not included in the snake pattern that aren't zeroes would decrease the compared value, making size larger and forcing this to false
}
//returns the average value of elements in the array
private double average(int[] scores){
    int hold=0;
    for(int i:scores){
        hold+=scores[i];
    }
    return (double)hold/scores.length;
}
//returns the sum of the elements in the array
private int sumVals(int[] nums){
    int hold=0;
    for(int i:nums){
        hold+=nums[i];
    }
    return hold;
}
//returns the summ of elements in a 2d array using sumVals()
private int[] sum2d(int[][] nums){
    int[] sums=new int[nums.length];
    int hold=0;
    for(int[] i:nums){
        sums[hold]=sumVals(i);
        hold++;
    }
    return sums;
}
}