/**
 * Sean McLoughlin
 * HONOR PLEDGE: All work here is honestly obtained and is my own. Sean McLoughlin
 * Date of Completion:  10/03/2022
 * Assignment: Conway's Game of Life
 * 
 * Attribution: 
 * 
 * General Description: Takes user input to make a grid of "organisms" and evolves the array of organisms according to the rules of Conway's game of life
 * 
 * Advanced: rounded array allows for edges of the screen to check opposing sides of the array
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Takes input from user-filled cells in a grid, then evolves the grid according to the rules of Conway's game of life
 * @author Sean McLoughlin
 * @version 10/13/2022
 */

public class GameOfLife extends JFrame implements ActionListener{
    private LifeCanvas display;
    private LifeControls controls;
    private Timer t;
    private int timeStep;
    private boolean isRunning;
    
    public GameOfLife() {
    	isRunning = false;
        display = new LifeCanvas(this);
        display.setBackground(Color.green);
        controls = new LifeControls(this);

        Container c = getContentPane();
        c.add(display, BorderLayout.CENTER);
        c.add(controls, BorderLayout.SOUTH);
        
        
       timeStep = 3000;
       t = new Timer(timeStep, this);
    }
    
    public void setSpeed(int millisecs)
    {
        timeStep = millisecs;
        t.setDelay(timeStep);
        t.restart();
    }
    
    public void next(){
        display.next();
        repaint();
    }
    
    public void stop()
    {
        t.stop();
        isRunning = false;
    }
    
    public void start()
    {
        t.start();
        isRunning = true;
    }
    
    /**
	 * Is the program running?
	 * @return true: program is running
	 */
	public boolean isRunning() {
		return isRunning;
	}
     
   
    /* Timer Event */
    public void actionPerformed(ActionEvent e)
    {
         next();
    }

    public static void main(String[] args)
    {
      GameOfLife window = new GameOfLife();
      window.setTitle("Game of Life 1.0");
      window.setBounds(0,0, 515, 610);
      window.setDefaultCloseOperation(EXIT_ON_CLOSE);
      window.setResizable(true);
      window.setVisible(true);
    }
    
}
