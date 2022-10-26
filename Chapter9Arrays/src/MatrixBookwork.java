import java.util.Arrays;
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
public class MatrixBookwork {
public static void main(String args[]){
    testMethod();
    //printTriangle(pascalTriangle(5));
}
private static void testMethod(){
    //matrixMultiplication() tests
    System.out.println("Testing matrixMultiplication()...");
    printArray(matrixMultiplication(new int[][] {{1,2},{3,4}}, new int[][] {{1,2,3},{4,5,6}}));System.out.println("Should be:");printArray(new int[][] {{9,12,15},{19,26,33}});System.out.println();
    printArray(matrixMultiplication(new int[][] {{1,2},{3,4}}, new int[][] {{1,2,3},{4,5,6},{7,8,9}}));System.out.println("Should be: null");System.out.println();
    printArray(matrixMultiplication(new int[][] {{0,0,0},{0,0,0}}, new int[][] {{3,4,5},{6,7,8},{1,2,3}}));System.out.println("Should be: ");printArray(new int[][] {{0,0,0},{0,0,0}});System.out.println();
    
    //addMatrices() Tests
    System.out.println("\nTesting addMatrices()...");
    printArray(addMatrices(new int[][] {{1,1},{1,1}}, new int[][] {{1,1},{1,1}}));System.out.println("Should be: ");printArray(new int[][] {{2,2},{2,2}});System.out.println();
    printArray(addMatrices(new int[][] {{1,2,3},{1,2,3}}, new int[][]{{1,2,3},{1,2,3}}));System.out.println("Should be:");printArray(new int[][] {{2,4,6},{2,4,6}});System.out.println();
    printArray(addMatrices(new int[][] {{2,2,2},{2,2,2},{2,2,2}}, new int[][] {{3,3,3},{3,3,3},{3,3,3}}));System.out.println("Should be:");printArray(new int[][] {{5,5,5},{5,5,5},{5,5,5}});System.out.println();//onDiagonal() tests
    
    //onDiagonal () Tests
    System.out.println("\nTesting onDiagonal...");
    System.out.println(onDiagonal(new int[10][10], 0, 0)+" should be "+true);
    //if(onDiagonal(new int[10][10], 0, 0)==false) System.out.println("Error onDiagonal() test 1");
    System.out.println(onDiagonal(new int[10][10],1,2)+" should be "+false);
    //if(onDiagonal(new int[10][10],1,2)==true) System.out.println("Error onDiagonal() test 2");
    System.out.println(onDiagonal(new int[12][12],5,6)+" should be "+true);
    //if(onDiagonal(new int[12][12],5,6)==false) System.out.println("Error onDiagonal() test 3");
    
    //positiveMax() tests
    if(positiveMax(new double[][] {{1,2,3,4,5,6,7,8,9},{-1,-1,-1,-1,-1}})!=9) System.out.println("Error positiveMax() test 1");
    if(positiveMax(new double[][] {{-1,-2,-3}, {-1,-4,-5}})!=0) System.out.println("Error positiveMax() test 2");
    if(positiveMax(new double[][] {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}})!=0) System.out.println("Error positiveMax test 3");
    System.out.println("positiveMax() tested");
    
    //fillCheckerboard() tests
    System.out.println("\nTesting fillCheckerboard()...");
    Color on=new Color(true);
    Color off=new Color(false);
    Color[][] checkers1=new Color[5][5]; fillCheckerboard(checkers1);
    printCheckerboard(checkers1);
    printCheckerboard(new Color[][]{{on, off, on, off, on},{off, on, off, on, off},{on, off, on, off, on},{off, on, off, on, off},{on, off, on, off, on}});System.out.println();
    Color[][] checkers2=new Color[1][5]; fillCheckerboard(checkers2);
    printCheckerboard(checkers2);System.out.println("\nShould be:");
    printCheckerboard(new Color[][] {{on,off,on,off,on}});
    
    //covers() tests 
    System.out.println("\nTesting covers()...");
    System.out.println(covers(new double[][] {{2,3,4,5,6},{3,3,4,3,3}},new double[][] {{1,2,3,4,5},{3,3,3,3,3}})+" should be "+true);
    //if(covers(new double[][] {{1,2,3,4,5},{3,3,3,3,3}}, new double[][] {{2,3,4,5,6},{3,3,4,3,3}})==false) System.out.println("Error covers() test 1");
    System.out.println(covers(new double[][] {{1,2,3,4,5},{1,2,3,4,5}},new double[][] {{1,2,3,4,5},{1,2,3,4,5}})+" should be "+false);
    //if(covers(new double[][] {{1,2,3,4,5},{1,2,3,4,5}},new double[][] {{1,2,3,4,5},{1,2,3,4,5}})==true) System.out.println("Error covers() test 2");
    System.out.println(covers( new double[][] {{5,5,5,5}},new double[][] {{1,2,3,4}})+" should be "+true);
    //if(covers(new double[][] {{1,2,3,4}}, new double[][] {{5,5,5,5}})==false) System.out.println("Error covers() test 3");
    
    //isMagicSquare() tests
    System.out.println("\nTesting isMagicSquare*()...");
    System.out.println(isMagicSquare(new int[][] {{8,1,6},{3,5,7},{4,9,2}})+" should be "+true);
    //if(isMagicSquare(new int[][] {{8,1,6},{3,5,7},{4,9,2}})==false) System.out.println("Error isMagicSquare() test 1");
    System.out.println(isMagicSquare(new int[][] {{1,2,3},{4,5,6},{7,8,9}})+" should be "+false);
    //if(isMagicSquare(new int[][] {{1,2,3},{4,5,6},{7,8,9}})==true) System.out.println("Error isMagicSquare() test 2");
    
    //areAdjacent() Tests
    System.out.println("\nTesting areAdjacent()...");
    System.out.println(areAdjacent(new Location(1,2),new Location(2,12))+" should be "+true);
    System.out.println(areAdjacent(new Location(1,1),new Location(3,3))+" should be "+false);
    
    //isSnake() tests
    System.out.println("\nTesting isSnake()...");
    System.out.println(isSnake(new int[][] {{0,2,3,0,0},{0,1,4,0,0},{0,0,5,0,0},{0,7,6,0,0},{0,8,0,0,0}})+" should be "+true);
    System.out.println(isSnake(new int[][] {{0,1,3,0,0},{0,1,4,0,0},{0,0,5,0,0},{0,7,6,0,0},{0,8,0,0,0}})+" should be "+false);

    //average() tests
    System.out.println("\nTesting average()");
    System.out.println(average(new int[]{1,2,1,2})+" should be "+1.5);
    System.out.println(average(new int[]{0,0,0,0,0,0,0,0})+" should be "+0);
    
    //sumVals() tests
    System.out.println("\nTesting sumVals()...");
    System.out.println(sumVals(new int[]{1,1,1,1,1})+" should be "+5);
    System.out.println(sumVals(new int[]{3,6,1,6})+" should be "+16);
    
    //sum2d() tests
    System.out.println("\nTesting sum2d()...");
    System.out.println(Arrays.toString(sum2d(new int[][]{{1,1,1},{1}}))+" should be "+Arrays.toString(new int[]{3,1}));
    System.out.println(Arrays.toString(sum2d(new int[][] {{2,2,2,2,2,2},{1,1,1,1,1,1},{4,4,4,44}}))+" should be "+Arrays.toString(new int[]{12,6,56}));
}
//Ability to print an array used for testing
private static void printArray(int[][] m){
    if(m==null){
        System.out.println("null"); return;
    };
    for(int[] i:m){
        for(int n:i){
            System.out.print(n+" ");
        }
        System.out.println();
    }
}
//Adds two matrices together using mathematic rules
private static int[][] addMatrices(int[][] m1, int[][] m2){
    if(m1.length!=m2.length||m1[0].length!=m2[0].length) return null;
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
//Multiplies two matrices together and returns the product
private static int[][] matrixMultiplication(int[][] m1, int[][] m2){
    int[][] rtn=new int[m1.length][m2[0].length]; //hold array to be returned
    if(!isSquare(m1)||!isSquare(m2)||!(m1[0].length==m2.length)) return null; //if arrays are able ot be matrices (all rows are the same length)
        for(int i=0;i<rtn.length;i++){ //traverse the array
            for(int n=0;n<rtn[0].length;n++){ //traverse the array
                int hold=0; //reset the value for the next index of the returned array
                for(int q=0;q<m1.length;q++){ //go across m1 and down m2 using the same variable
                    hold+=m1[i][q]*m2[q][n]; //Add to the value to be used in the returned array
                }
                rtn[i][n]=hold; //set the rtn value to the found value
            }
        }
    return rtn;
}
//returns is an array is rectangular - named wrong
public static boolean isSquare(int[][] m){
    int length=m[0].length;
    for(int i=1;i<m.length;i++){
        if(m[i].length!=length) return false;
    }
    return true;
}
//returns if the given index is on either diagonal of a square array
private static boolean onDiagonal(int[][] arr, int i, int j){
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
//Fills a 2d array of Color to create an alternating checkerboard pattern
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
        for(int n=0;n<m1[0].length;n++){
             if(m1[i][n]>m2[i][n]) hold++;
    }
}
    return hold>(m1.length*m1[0].length/2);
}
//returns true if each value of the array is different ranging from 1-the number of elements and the sum of each row/col/diagonal is equal
private static boolean isMagicSquare(int m[][]){
    if(m.length==m[1].length){
        int num=0;
        int current=0;
        int current2=0;
        for(int i=0;i<m.length;i++){ //find first row's sum to compare to
            num+=m[0][i];
        }
        for(int i=0;i<m.length;i++){ 
            for(int n=0;n<m.length;n++){ //add up all rows/cols
                current+=m[i][n];
                current2+=m[n][i];
            }
            if(current!=num||current2!=num) return false; //if completed sums don't work, return false
            current=0; //reset sums
            current2=0;
        }
        for(int i=0;i<m.length;i++){ //check diagonals
            current+=m[i][i];
            current2+=m[m.length-1-i][m.length-1-i]; 
        }
        if(current!=num||current2!=num) return false;
        return true; //have to check that every number is included
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
private static boolean areAdjacent(Location loc1, Location loc2){
    int r1=loc1.getRow(); int c1=loc1.getCol();
    int r2=loc2.getRow(); int c2=loc2.getCol();
    return c1==c2&&Math.abs(r1-r2)<2||r1==r2&&Math.abs(c1-c2)<2;
}
//returns true if the bordering numbers count up to a certain number and all other numbers not included in this sequance are 0
private static boolean isSnake(int[][] m){
    int zeroes=0; //numbner of zeros in the array
    int num=0; //highest number found in the snake pattern
    boolean found=false;
    int size=0;
    for(int i=0;i<m.length;i++){
        size+=m[i].length; //square array is not guaranteed so we need to find the number of values in the aray with a loop
    }
    for(int i=0;i<m.length;i++){ //looop through the whole array
        int r1=i; //sets row 1
        for(int n=0;n<m[i].length;n++){
            int c1=n; //sets column 1
            if(m[i][n]==0) zeroes++; //count the number of zeros in the array
            else if(!found&&m[i][n]==num+1){
                num++; //sets the num value to track the snake pattern with, starts with 1
                found=true; //after finding the first 1's index, the snake pattern follower can no longer be restarted
                int iLim=i; int nLim=n; //Allows for the for loops to be changed when a new value is found
                for(int q=i-1;q<iLim+2;q++){ //searches the "box" surrounding the index of the found value (similar to gameOfLife)
                    //int r2=q; //sets row 2
                    for(int a=n-1;a<nLim+2;a++){
                        //int c2=a; //sets column 2
                        if(q>-1&&q<m.length&&a>-1&&a<m[q].length&&m[q][a]==num+1&& //number exists in surrounding box
                           (c1==a&&Math.abs(r1-q)<2||r1==q&&Math.abs(c1-a)<2)) //locations are adjacent
                        {
                            iLim=q;nLim=a; //resets all parts of the for loop to begin considering the values around the found value
                            c1=a;r1=q;
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
private static double average(int[] scores){
    int hold=0;
    for(int i:scores){
        hold+=scores[i];
    }
    return (double)hold/scores.length;
}
//returns the sum of the elements in the array
private static int sumVals(int[] nums){
    int hold=0;
    for(int i:nums){
        hold+=i;
    }
    return hold;
}
//returns the summ of elements in a 2d array using sumVals()
private static int[] sum2d(int[][] nums){
    int[] sums=new int[nums.length];
    int hold=0;
    for(int[] i:nums){
        sums[hold]=sumVals(i);
        hold++;
    }
    return sums;
}
//returns an array with every substring of the passed string
private static String[] allSubstrings(String str){
    String[] rtn=new String[str.length()*(str.length()+1)/2];
    int ind=0;
    for(int i=0;i<str.length();i++){
        for(int n=0;n<str.length()-i;n++,ind++){
            rtn[ind]=str.substring(n,n+i+1);
        }
    }
    return rtn;
}
//returns a 2d array with each row containing an array of every possible substring of each element of the passed array
public static String[][] allSubstrings2(String[] words){
    String[][] rtn=new String[words.length][];
    for(int i=0;i<words.length;i++){
        rtn[i]=allSubstrings(words[i]);
    }
    return rtn;
}
//creates pascal's triangle with n+1 rows
private static int[][] pascalTriangle(int n){
    int[][] triangle=new int[n+1][];
    for(int i=0;i<n+1;i++){
        triangle[i]=new int[i+1];
        for(int k=0;k<i+1;k++){
            if(k==0||k==triangle[i].length-1) triangle[i][k]=1;
            else{
                triangle[i][k]=triangle[i-1][k-1]+triangle[i-1][k];
            }
        }
    }
    return triangle;
}
//method used to print pascal's triangle in triangle form
private static void printTriangle(int[][] tri){
    for(int i=0;i<tri.length;i++){
        for(int n=tri.length-i;n>0;n--) System.out.print(" ");
        for(int n:tri[i]) System.out.print(n+" ");
        System.out.println();
    }
} 
}