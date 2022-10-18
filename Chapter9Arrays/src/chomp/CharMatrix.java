/**
 * Implements a 2-D array of characters
 */

public class CharMatrix
{
  // Fields:
  private char[][] board; //board is null


  /**
   * Constructor: creates a grid with dimensions rows, cols,
   * and fills it with spaces
   */

  public CharMatrix(int rows, int cols)
  {
    board=new char[rows][cols]; //board now has size according to the parameters 
    for(int r=0;r<board.length;r++){
      for(int c=0;c<board[r].length;c++){
        board[r][c]=' ';
      }
    }
  }

  /**
   * Constructor: creates a grid with dimensions rows , cols ,
   * and fills it with the fill character
   */
  public CharMatrix(int rows, int cols, char fill)
  {
    board=new char[rows][cols];
    for(int r=0;r<board.length;r++){
      for(int c=0;c<board[r].length;c++){
        board[r][c]=fill;
      }
    }
  }

  /**
   * Returns the number of rows in grid
   */
  public int numRows()
  {
    return board.length;
  }

  /**
   * Returns the number of columns in grid
   */
  public int numCols()
  {
    return board[0].length;
  }

  /**
   * Returns the character at row, col location
   */
  public char charAt(int row, int col)
  {
    return board[row][col];
  }

  /**
   * Sets the character at row, col location to ch
   */
  public void setCharAt(int row, int col, char ch)
  {
    board[row][col]=ch;
  }

  /**
   * Returns true if the character at row, col is a SPACE,
   * false otherwise
   */
  public boolean isEmpty(int row, int col)
  {
    return board[row][col]==' ';
  }

  /**
   * Fills the given rectangle with the fill characters.
   * row0, col0 is the upper left corner and row1, col1 is the
   * lower right corner of the rectangle.
   */
  public void fillRect(int row0, int col0, int row1, int col1, char fill)
  {
    for(int r=row0;r<row1;r++){
      for(int c=col0;c<col1;c++){
        board[r][c]=fill;
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
    for(int r=row0;r<row1;r++){
      for(int c=col0;c<col1;c++){
         board[r][c]=' '; 
      }
    }
  }

  /**
   * Returns the count of all non-SPACE characters in row.
   */
  public int countInRow(int row)
  {
    int rtn=0;
    for(int i=0;i<board[row].length;i++){
      if(board[row][i]!=' ') rtn++;
    }
    return rtn;
  }

  /**
   * Returns the count of all non-SPACE characters in col.
   */
  public int countInCol(int col)
  {
    int rtn=0;
    for(int i=0;i<board.length;i++){
      if(board[i][col]!=' ') rtn++;
    }
    return rtn;
  }
}
