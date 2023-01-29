package Fractals;
import java.awt.Color;
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
        t.moveTo(100, 550);
        t.setColor(Color.BLACK);
        t.penDown();
        t.turn(90);
        //Coastlines: II       Gaskets: II        Trees: II
        //t.drawLumpyCoastline(3,100); //Coastline 2
        //t.drawChip(8,300); //Gasket 1
        //t.drawTree(9, 200); //Tree 1
        //t.drawTree2(8, 200); //Tree 2
        //t.drawKochCurve(5, 50); //Coastline 1
        //t.drawSierpinski(8, 350); //Gasket 2
        
    }
    public TreeTurtle(){
        
    }
    public void drawOpenTree(int depth, int length){
        if(depth==0)
    }
    /**
     * draws a lumpy looking coastline shape using fractals
     * @param iterations number of times to run, decrements with every iteration
     * @param length length of original line
     */
    public void drawLumpyCoastline(int iterations, double length){
        if(iterations==0){
            turn(-30);
            forward(length/2);
            turn(60);
            forward(length/2);
            turn(-30);
        }
        else{
            drawLumpyCoastline(iterations-1,length/2);
            turn(-30);
            drawLumpyCoastline(iterations-1, length/2);
            turn(60);
            drawLumpyCoastline(iterations-1,length/2);
            turn(-30);
            drawLumpyCoastline(iterations-1,length/2);
            
        }
    }
    /**
     * turtle will always return to its initial state at the base of the tree just drawn
     * tree family
     * @param depth - depth of recursion, decremented as the program runs
     * @param distance - length of the trunk at the given stage
     */
    public void drawTree(int depth, double distance){
        if(depth==0){ 
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
     * draws a tree with a random aspect to the angle turned
     * @param iterations times to run, decrements on every call
     * @param length 
     */
    public void drawTree2(int iterations, double length){
        if(iterations==0){
            forward(length);
            backward(length);
        }
        else{
            forward(length);
            turn(-30);
            int rnd=(int)Math.random()*10;
            drawTree2(iterations-1,length/2);
            turn(60+rnd);
            drawTree2(iterations-1,length/2);
            turn(60-rnd);
            drawTree(iterations-1,length/2);
            turn(30);
            backward(length);
        }
    }
    /**
     * draws a koch curve using recursion
     * coastline family
     * @param depth depth to recurse, decrements by one each call
     * @param length split into 3 parts
     */
    public void drawKochCurve(int depth, double length){
        if(depth==0){
            forward(length);
        }
        else{
            drawKochCurve(depth-1, length/2);
            turn(-60);
            drawKochCurve(depth-1, length/2);
            turn(120);
            drawKochCurve(depth-1, length/2);
            turn(-60);
            drawKochCurve(depth-1, length/2);
        }
    }
    /**
     * draws sierpinski's triangle using recursion
     * gasket family
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
    /**
     * draws a recursive square with 4 inlaid squares and a plus sign in the middle of each
     * gasket family
     * @param iterations
     * @param side
     */
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
    public void drawMassTriangle(int iterations, double side){
        if(iterations==0){
            forward(side);
            turn(-150);
            forward(side/4);
            turn(120);
            forward(side/4);
            turn(30);
        }
        else{
            drawMassTriangle(iterations-1, side);
        }
    }
}