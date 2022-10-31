
import java.util.Arrays;

public class SudokuTester {
    public static void main(String args[]){
        SudokuGrid grid=new SudokuGrid();
        printGrid(grid.makeMagicSquare(3));
    } 
    private static void printGrid(int[][] m){
        for(int[] i:m){
            System.out.println(Arrays.toString(i));
        }
    }
    }
