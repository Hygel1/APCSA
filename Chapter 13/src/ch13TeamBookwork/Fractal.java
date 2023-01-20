package ch13TeamBookwork;
// Chapter 13 Question 19

/**
 * This program draws a picture of nested triangles
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fractal extends JPanel
{
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    drawTriangles(g, 400, 600, 300);
  }

  /**
   * Draws a picture made of triangles in Graphics g
   * with the base midpoint at (x, y) and base half-length r
   */
  public void drawTriangles(Graphics g, int x, int y, int r)
  {
    if(r<1){
      return;
    }
    g.drawLine(x-r,y,x,y-r);
    g.drawLine(x+r,y,x,y-r);
    g.drawLine(x+r,y,x-r,y);
    drawTriangles(g,x-r/2,y,r/2);
    drawTriangles(g,x+r/2,y,r/2);
  }

  public static void main(String[] args)
  {
    JFrame w = new JFrame("Triangles");
    w.setBounds(800, 800, 1000, 1000);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Fractal panel = new Fractal();
    panel.setBackground(Color.WHITE);
    Container c = w.getContentPane();
    c.add(panel);
    w.setResizable(true);
    w.setVisible(true);
  }
}
