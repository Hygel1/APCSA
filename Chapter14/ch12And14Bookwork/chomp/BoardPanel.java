package Chapter14.Ch12And14Bookwork.chomp;

/**
 * A board for the Chomp program
 */

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class BoardPanel extends JPanel
{
  private int ROWS = 4, COLS = 7;   // board dimensions
  private int CELLSIZE = 40;
  private Color chocolate = new Color(110, 70, 50);

  private int tentativeRow, tentativeCol, displayCount;

  // Constructor
  public BoardPanel(int x,int y){
    setPreferredSize(new Dimension(COLS*x,COLS*y));
    setBackground(Color.LIGHT_GRAY);
  }
  public BoardPanel()
  {
    setPreferredSize(new Dimension(COLS * CELLSIZE, ROWS * CELLSIZE));
    setBackground(Color.LIGHT_GRAY);
  }

  // Returns the number of rows in the board
  public int numRows()
  {
    return ROWS;
  }

  // Returns the number of columns in the board
  public int numCols()
  {
    return COLS;
  }

  // Returns the location that corresponds to the x,y-coordinates
  // of the mouse click on the board
  public Location getPos(int x, int y)
  {
    return new Location(y / CELLSIZE, x / CELLSIZE);
  }

  // Sets location for the expected move at row, col
  // (to provide visual feedback, e.g. flashing the changed squares)
  public void setMove(int row, int col)
  {
    tentativeRow = row;
    tentativeCol = col;
  }

  // Sets count for visual feedback, e.g. flashing the changed squares
  public void setDisplayCount(int count)
  {
    displayCount = count;
  }

  private ChompGame game;

  // Repaints the board after the move at row, col
  public void update(ChompGame game)
  {
    this.game = game;
    repaint();
  }

  // Displays the board after a repaint request
  // (redefines the method of the base class)
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    if (game == null)
      return;

      int cellW=this.getWidth()/COLS;
      int cellH=this.getHeight()/ROWS;
    for (int r = 0; r < ROWS; r++)
    {
      for (int c = 0; c < COLS; c++)
      {
        Color color;

        if (game.isEmpty(r, c))
          color = Color.LIGHT_GRAY;
        else if (displayCount % 2 != 0 && r >= tentativeRow && c >= tentativeCol)
          color = Color.RED;
        else
          color = chocolate;
        g.setColor(color);
        int x = c * cellW;
        int y = r * cellH;
        g.fillRect(x, y, cellW, cellH);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, cellW, cellH);
        g.drawRect(x+1, y+1, cellW-2, cellH-2);
        if (r == 0 && c == 0)
        {
          g.setColor(Color.YELLOW);
          g.drawLine(x+3, y+3, x + cellW - 6, y + cellH - 6);
          g.drawLine(x+3, y + cellH - 6, x + cellW - 6, y+3);
        }
      }
    }

    if (displayCount > 0)
      displayCount--;
  }
}
