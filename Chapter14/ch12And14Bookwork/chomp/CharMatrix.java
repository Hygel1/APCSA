package Chapter14.ch12And14Bookwork.chomp;

/**
 * Implements a 2-D array of characters
 */

public class CharMatrix
{
  // Fields:
  char[][] grid;

  /**
   * Constructor: creates a grid with dimensions rows, cols,
   * and fills it with spaces
   */
  public CharMatrix(int rows, int cols)
  {
    grid=new char[rows][cols];
  }

  /**
   * Constructor: creates a grid with dimensions rows , cols ,
   * and fills it with the fill character
   */
  public CharMatrix(int rows, int cols, char fill)
  {
    grid=new char[rows][cols];
    for(int i=0;i<rows;i++){
      for(int n=0;n<cols;n++){
        grid[i][n]=fill;
      }
    }
  }

  /**
   * Returns the number of rows in grid
   */
  public int numRows()
  {
    return grid.length;
  }

  /**
   * Returns the number of columns in grid
   */
  public int numCols()
  {
    return grid[0].length;
  }

  /**
   * Returns the character at row, col location
   */
  public char charAt(int row, int col)
  {
    return grid[row][col];
  }

  /**
   * Sets the character at row, col location to ch
   */
  public void setCharAt(int row, int col, char ch)
  {
    grid[row][col]=ch;
  }

  /**
   * Returns true if the character at row, col is a SPACE,
   * false otherwise
   */
  public boolean isEmpty(int row, int col)
  {
    return grid[row][col]==' ';
  }

  /**
   * Fills the given rectangle with the fill characters.
   * row0, col0 is the upper left corner and row1, col1 is the
   * lower right corner of the rectangle.
   */
  public void fillRect(int row0, int col0, int row1, int col1, char fill)
  {
    for(int i=row0;i<=row1;i++){
      for(int n=col0;n<=col1;n++){
        grid[i][n]=fill;
      }
    }
  }

  /**
   * Fills the given rectangle with the SPACE characters.
   * row0, col0 is the upper left corner and row1, col1 is the
   * lower right corner of the rectangle.
   */
  public void clearRect(int row0, int col0, int row1, int col1)
  {
    for(int i=row0;i<=row1;i++){
      for(int n=col0;n<=col1;n++){
        grid[i][n]=' ';
      }
    }
  }

  /**
   * Returns the count of all non-SPACE characters in row.
   */
  public int countInRow(int row)
  {
    int hold=0;
    for(int i=0;i<grid.length;i++){
      if(grid[row][i]!=' ') hold++;
    }
    return hold;
  }

  /**
   * Returns the count of all non-SPACE characters in col.
   */
  public int countInCol(int col)
  {
    int hold=0;
    for(int i=0;i<grid[col].length;i++){
      if(grid[i][col]!=' ') hold++;
    }
    return hold;
  }
}
