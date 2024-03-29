package Fractals;
import java.awt.Color;
import edu.gatech.mediaprogramming.*;
/**
 * turtle commands
 * forward(double distance) - moves forward
 * backward(double distance) - moves backward
 * turn(double degrees)
 */

public class TreeTurtle extends Turtle{ //Turtle is part of turtle.jar and imported from edu.gatech.mediaprogramming.*
        static TreeTurtle t=new TreeTurtle();

    public static void main(String[] args){
        t.penUp();
        t.moveTo(300, 300);
        t.setColor(Color.BLACK);
        t.penDown();
        t.turn(90);
        /*
        t.drawLumpyCoastline(3,100); //Coastline 2
        t.drawChip(8,300); //Gasket 1
        t.drawTree(9, 200); //Tree 1
        t.drawTree2(8, 200); //Tree 2
        t.drawKochCurve(5, 50); //Coastline 1
        t.drawSierpinski(8, 350); //Gasket 2
        t.drawRandomShape(5, 100); //Gasket 3
        t.drawVicsek(7,100); //Tree 3
        t.drawCircles(5, 100,1); //Gasket 4, 10th
        t.drawBatman(5, 50); //Coastline 3 */
        //t.drawCircles(4, 150, 1, Color.BLACK);
        //t.drawSpiral(0, 200);
        t.drawCircles(5, 100,1,Color.MAGENTA);
    }
    public TreeTurtle(){
        
    }
    public void drawSpiral(int depth, double length){
        if(depth==0){
            //for(int i=0;i<7;i++){
                forward(length);
                turn(30);
                for(int n=0;n<180;n++){
                    //forward(Math.PI*length/125);
                    forward(1);
                    turn(1);
                }
                //turn(30);
                forward(length);
                turn(90);
                forward(100);
            //}
        }
    }
    /**
     * draws a weird-looking coastline figure recursively (peaks, falls, plateaus, recurses, peaks, falls, recurses); when depth=1, it kind of looks like batman
     * @param depth times to recurse
     * @param length length to draw, no length perfectly matches this value, though
     */
    public void drawBatman(int depth, double length){
        if(depth==0){ //base case
            forward(length/3);
            turn(-80);
            forward(length*.8);
            turn(120);
            forward(length/5);
            turn(-40);
            forward(length/5);
            turn(-80);
            forward(length/5);
            turn(150);
            forward(length*.9);
            turn(-70);
            forward(length/3);
            //move forward, draw batman, move forward again to continue base
        }
        else{
            forward(length/3); //start base
            turn(-80); //prepare to rise
            forward(length*.8); //sprout up
            turn(120); //peak
            forward(length/5); //drop to plateau
            turn(-40); //prepare to fall
            drawBatman(depth-1,length/3); //DRAW ANOTHER BATMAN
            turn(-80); //preapare to rise
            forward(length/5); //rise
            turn(150); //peak
            forward(length*.9); //back to base
            turn(-70); //settle back to oringial angle
            drawBatman(depth-1, length); //continue the saga
        }
    }
    /**
     * draws several circles sprouting off of one another
     * @param depth depth to recurse
     * @param radius radius of each circle
     * @param one allows for child circles to turn in the opposite direction of their parent circle
     * @param clr passed color for new circle, used to help revert to old color when finishing parent circle
     */
    public void drawCircles(int depth, double radius, int one, Color clr){
        t.setColor(clr); //inherit color and use for next circle
        if(depth==0){ //base case
            for(int i=0;i<360;i++){ //repeat 360 times
                forward(2*Math.PI*radius/360); //take a step 1/360th of the circumference
                turn(1); //turn 1 degree
            }
        }
        else{
            Color clr1=new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
            for(int i=0;i<5;i++){ //each parent circle gets 5 child circles
                for(int n=0;n<72;n++){ //the base of each child is evenly spread around its parent's base
                    forward(2*Math.PI*radius/360);
                    turn(1*one); //if the oringinal was spinning one way, child must spin in the opposite direction
                }
                drawCircles(depth-1, radius/3,one*-1, clr1); //draw child circle
                t.setColor(clr); //reset color to continue drawing base circle
            }
        }
    }
    /**
     * draws vicksek's fractal recursively
     * @param depth times to iterate, decrements with each call
     * @param length length of branch to draw
     */
    public void drawVicsek(int depth,double length){
        if(depth==0){
            for(int i=0;i<4;i++){
                forward(length);
                backward(length);
                turn(90);
                //consider the starting point a midpoint and draw cross
            }
        }
        else{
            for(int i=0;i<4;i++){ //4
                forward(length); //sprout out
                drawVicsek(depth-1, length/3); //repeat process
                backward(length); //return to base
                turn(90); //prepare for next time
            }
        }
    }
    /**
     * recursively draws a series of inlaid shapes with a randomly selected number of sides, each shape is independently decided
     * @param depth amount of times to repeat
     * @param length length of each shape's side
     */
    public void drawRandomShape(int depth, double length){
        int rand=(int)(Math.random()*7)+3; //decide the number of sides fopr the enw shape, 2 minimum -- lines are boring and 2 counts as a circle
            if(depth==0){
                for(int i=0;i<rand;i++){
                    forward(length);
                    turn(-360/rand);
                }
            }
            else{
                for(int i=0;i<rand;i++){
                    forward(length/4);
                    drawRandomShape(depth-1, length/2);
                    forward(length/4);
                    turn(-360/rand);
                }
            }
    }

    /**
     * draws a lumpy looking coastline shape using fractals
     * @param iterations number of times to run, decrements with every iteration
     * @param length length of original line
     */
    public void drawLumpyCoastline(int iterations, double length){
        if(iterations==0){
            turn(-30); //turn up
            forward(length/2); //draw
            turn(60); //turn back down
            forward(length/2); //draw
            turn(-30); //flatten out
        }
        else{
            drawLumpyCoastline(iterations-1,length/2);
            turn(-30);
            drawLumpyCoastline(iterations-1, length/2);
            turn(60);
            drawLumpyCoastline(iterations-1,length/2);
            turn(-30);
            drawLumpyCoastline(iterations-1,length/2);
            //reaplce all lines with iterations
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
            int rnd=(int)(Math.random()*10); //find random angle
            drawTree2(iterations-1,length/2);
            turn(60+rnd); //add random angle
            drawTree2(iterations-1,length/2);
            turn(60-rnd); //reverse randomness and return to normalcy
            drawTree(iterations-1,length/2);
            turn(30);
            backward(length); //back to base
        }
    }
    /**
     * draws a koch curve using recursion
     * coastline family
     * @param depth depth to recurse, decrements by one each call
     * @param length split into 3 parts
     */
    public void drawKochCurve(int depth, double length){
        if(depth==0){ //base case line
            forward(length);
        }
        else{
            drawKochCurve(depth-1, length/2); //start with curve as baseline
            turn(-60); //prepare to rise
            drawKochCurve(depth-1, length/2); //rise with curve
            turn(120); //prepare to fall
            drawKochCurve(depth-1, length/2); //fall with curve
            turn(-60); //flatten
            drawKochCurve(depth-1, length/2); //finish base with curve
        }
    }
    /**
     * draws sierpinski's triangle using recursion
     * gasket family
     * @param depth depth to recurse, decrements by one
     * @param side length of triangle's side, split in two
     */
    public void drawSierpinski(int depth, double side){
        if(depth==0){ //draw basic triangle
            forward(side);
            turn(-120);
            forward(side);
            turn(-120);
            forward(side);
            turn(-120);
        }
        else{
            drawSierpinski(depth-1, side/2); //draw small triangle in bottom left
            forward(side/2); //go halfway across base
            drawSierpinski(depth-1, side/2); //draw triangle in bottom right
            turn(-120); //prepare to launch
            forward(side/2); //go to third position
            turn(120); //turn net 0
            drawSierpinski(depth-1, side/2); //draw top triangle
            turn(120); //get ready to go baack to base
            forward(side/2); //go abck to base
            turn(-120); //net 0
        }
    }
    /**
     * draws a recursive square with 4 inlaid squares and a plus sign in the middle of each
     * gasket family
     * @param iterations
     * @param side
     */
    public void drawChip(int iterations, double side){
        if(iterations==0){ //draw square in base case
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
            //draws whole chip then retraces to recurse
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
