package Tests;
import java.util.Arrays;

/**
 * You should use this file to complete your Sudoku problem
 * as many of its components are related to Class Design.
 * Your task is to implement the required components of
 * maintaining and using information about the given "board".
 * You may find looking at the GameOfLife and Chomp to
 * be useful contexts for this work.
 * 
 * You are welcome to implement some testing device, if
 * you wish.
 * 
 * @author yoderr
 *	Note:  It will require some ingenuity and exploration on your part to actually "test" 
 *	this particular exercise because none of these methods are declared as static and
 *	we have not reinforced class design and class testing yet. (That is Ch10.)
 *
 */
public class SudokuGrid {

	private int[][] grid;
	//private final int EMPTY = 0;
	
	public SudokuGrid()
	{
		grid=new int[9][9];
	}
	public int[] sumRows(){
		int[] hold=new int[grid.length]; 
		for(int i=0;i<grid.length;i++){
			for(int n:grid[i]){
				hold[i]+=n;
			}
		}
		return hold;
	}
	public int[] sumCols(){
		int[] hold=new int[grid[0].length];
		for(int i=0;i<grid.length;i++){
			for(int n=0;n<grid[i].length;n++){
				hold[n]+=grid[n][i];
			}
		}
		return hold;
	}
	
	//parts e-i
	public int getCell(int row, int col)
	{
		return grid[row][col];
	}
	
	public boolean isOkColumn(int col, int value){
		for(int i=0;i<grid.length;i++){
			if(grid[i][col]==value) return false;
		}
		return true;
	}
	
	public boolean isOkRow(int row, int value)
	{
		for(int i: grid[row]){
			if(i==value) return false;
		}
		return true;
	}
	
	public boolean isOkSector(int row, int col, int value)
	{
		for(int i=(row/3)*3;i<(row/3)*3+3;i++){
			for(int n=(col/3)*3;n<(col/3)*3+3;n++){
				if(grid[i][n]==value) return false;
			}
		}
		return true;
	}
	
	public void setCell(int row, int col, int value)
	{
		grid[row][col]=value;
	}
	public void printWeird(int[][] matrix){
		for(int i=0;i<matrix.length;i++){
			for(int n=0;n<matrix[i].length;n++){
				int count=0, hold=matrix[i][n];
				for(int k=0;k<matrix.length;k++){
					if(matrix[i][k]==hold) count++;
				}
				if(count>2){
					count=0;
					for(int k=0;k<matrix[i].length;k++){
						if(matrix[k][n]==hold) count++;
					}
					if(count>2) System.out.println("("+i+", "+n+") - "+matrix[i][n]);
				}
			}
		}
	}
	public int[][] makeMagicSquare(int n){
		int[][] rtn=new int[n][n];
		if(n%2==0) return null;
		else{
			int num=1;
			int r=0;int c=n/2;
			while(num<=n*n){
				if(rtn[r][c]==0){
					rtn[r][c]=num;
				}
				else{
					if(r+1==n) r=0; else r++;
					rtn[r][c]=num;
				}
				if(r-1==-1) r=rtn.length-1; else r--;
				if(c+1==n) c=0; else c++;
				num++;
			}
		}
		return rtn;
	}
	public void printGridToConsole()
	{
		if (grid==null)
			System.out.println("NULL");
		else
			for(int r=0; r<grid.length; r++) {
				System.out.println(Arrays.toString(grid[r])); //output a row
			}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SudokuGrid sudoku = new SudokuGrid();
		//In order to activate methods that are NOT static, you must
		// create an object and use dot-notation to trigger them.
		
		sudoku.printGridToConsole();
		//do stuff here that changes grid...
		sudoku.printGridToConsole();

	}

}
