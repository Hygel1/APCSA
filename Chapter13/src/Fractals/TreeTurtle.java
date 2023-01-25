package Fractals;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import edu.gatech.mediaprogramming.*; //GT turtle library
/**
 * turtle commands
 * forward(int distance) - moves forward
 * backward(int distance) - moves backward
 * turn(int degrees)
 */

public class TreeTurtle extends Turtle{ //Turtle is part of turtle.jar and imported from edu.gatech.mediaprogramming.*
    public static void main(String[] args){
        System.out.println("yo");
        TreeTurtle t=new TreeTurtle();
        t.penUp();
        t.moveTo(100, 350);
        t.setColor(Color.BLACK);
        t.penDown();
        t.turn(90); 
        t.drawChip(8,300);
        //t.drawTree(9, 200);
        //t.drawKochCurve(9, 500);
        //t.drawSierpinski(8, 350);
        
    }
    public TreeTurtle(){
        
    }
    /**
     * turtle will always return to its initial state at the base of the tree just drawn
     * @param depth - depth of recursion, decremented as the program runs
     * @param distance - length of the trunk at the given stage
     */
    public void drawTree(int depth, double distance){
        if(depth==1){ 
            forward(distance);
            backward(distance); //return to base
        }
        else{
            forward(distance);
            turn(45);
            drawTree(depth-1,distance/2);
            turn(-90); //turn back and 45 degrees past original angle
            drawTree(depth-1,distance/2);
            turn(45); //go back to original angle
            backward(distance);
        }
    }
    /**
     * draws a koch curve using recursion
     * @param depth depth to recurse, decrements by one each call
     * @param length split into 3 parts
     */
    public void drawKochCurve(int depth, double length){
        if(depth==0){
            forward(length);
        }
        else{
            drawKochCurve(depth-1, length/3);
            turn(-60);
            drawKochCurve(depth-1, length/3);
            turn(120);
            drawKochCurve(depth-1, length/3);
            turn(-60);
            drawKochCurve(depth-1, length/3);
        }
    }
    /**
     * draws sierpinski's triangle using recursion
     * @param depth depth to recurse, decrements by one
     * @param side length of triangle's side, split in two
     */
    public void drawSierpinski(int depth, double side){
        if(depth==0){
            forward(side);
            turn(-120);
            forward(side);
            turn(-120);
            forward(side);
            turn(-120);
        }
        else{
            drawSierpinski(depth-1, side/2);
            forward(side/2);
            drawSierpinski(depth-1, side/2);
            turn(-120);
            forward(side/2);
            turn(120);
            drawSierpinski(depth-1, side/2);
            turn(120);
            forward(side/2);
            turn(-120);
        }
    }
    public void drawChip(int iterations, double side){
        if(iterations==0){
            forward(side);
            turn(-90);
            forward(side);
            turn(-90);
            forward(side);
            turn(-90);
            forward(side);
            turn(-90);
        }
        else{
            drawChip(iterations-1,side/3);
            turn(-90);
            forward(2*side/3);
            turn(90);
            drawChip(iterations-1,side/3);
            turn(90);
            forward(2*side/3);
            turn(-90);
            forward(2*side/3);
            drawChip(iterations-1, side/3);
            forward(side/3);
            turn(-90);
            forward(2*side/3);
            turn(-90);
            forward(side/3);
            turn(180);
            drawChip(iterations-1,side/3);
            turn(-90);
            forward(side/3);
            turn(-90);
            forward(2*side/3);
            turn(-90);
            forward(side);
            turn(-90);
        }
    }

}