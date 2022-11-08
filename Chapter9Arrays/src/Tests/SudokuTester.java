package Tests;
import java.util.Arrays;

public class SudokuTester{
    public static void main(String[] args){
        int[][] grid={{0,1,2,3,4},{0,2,3,4,5},{3,0,4,3,3},{1,1,0,1,7},{0,1,0,3,8}};
        SudokuGrid sod=new SudokuGrid();
        sod.printWeird(grid);
    } 
    private static void printGrid(int[][] m){
        for(int[] i:m){
            System.out.println(Arrays.toString(i));
        }
    }
    }
