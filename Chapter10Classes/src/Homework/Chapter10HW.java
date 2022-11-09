package Homework;
import java.awt.Color;

//import Homework.SoccerTeam.ScoreReport;
public class Chapter10HW extends SoccerTeam{
    public static void main(String ars[]){
        rectangleTester();
    }
    //#1
    public String replace(String srt, char character){
        return "";
    }

    /* #2
    a. false
    b. true
    c. true
    d.true
    e. true
    f. true
    */
    
    //#3 C

    /* #4
     * String does have a copy constructor
     * Color does not have a copy constructor
     */

     //#5
    public class balloon{
        double radius;
        Color color;
        public balloon(){
            radius=10;
            color=new Color(135,206,250);
        }
    }

    //#6
    public class Fraction{
        private int num, den;
        public Fraction(int myNum, int myDen){
            num=myNum;
            den=myDen;
        }
        public int getNum(){
            return num;
        }
        public int getDen(){
            return den;
        }
        public Fraction divide(Fraction other){
            if(other.getDen()==0){
                throw new IllegalArgumentException();
            }
            return new Fraction(num*=other.getDen(),den*=other.getNum());
        }
    }

    //#7
    public class FConverter{
        private double far;
        public FConverter(){

        }
        public void setFarenheight(double faren){
            far=faren;
        }
        public double getFarenheight(){
            return (far-32)*5./9.;
        }
    }

    //#9
    public class Point{
        private double x;
        private double y;
        public Point(Point pnt){
            x=pnt.getX();
            y=pnt.getY();
        }
        public double getX(){
            return x;
        }
        public double getY(){
            return y;
        }
    }
    public class Disk{
        private Point center;
        private double radius;
        public Disk(Disk dsk){
            center=dsk.getCenter();
            radius=dsk.getRadius();
        }
        public Point getCenter(){
            return center;
        }
        public double getRadius(){
            return radius;
        }
    }

    //#10 - Rectangle is static to allow it to be run without creating an instance of the outer class
    public static class Rectangle{
        int w,h;
        public Rectangle(int width, int height){
            w=Math.abs(width);h=Math.abs(height);
        }
        public Rectangle(int side){
            side=Math.abs(side);
            w=side;h=side;
        }
        public Rectangle(){
            w=1;h=1;
        }
        public boolean isSquare(){
            return w==h;
        }
        public void quadritize(){
            int hold=(int)Math.sqrt(w*h);
            w=hold;h=hold;
        }
        public int getW(){
            return w;
        }
        public int getH(){
            return h;
        }

    }
    public static void rectangleTester(){
        Rectangle r1=new Rectangle(4,5);
        Rectangle r2=new Rectangle(5);
        Rectangle r3=new Rectangle();
        if(r1.isSquare()) System.out.println("E1-1");
        r1.quadritize();
        if(!r1.isSquare()) System.out.println("E1-2");
        if(r1.getH()!=r1.getW()) System.out.println("E1-3");
        if(r1.getH()!=4) System.out.println("E1-4");
        if(r1.getW()!=4) System.out.println("E1-5");

        if(!r2.isSquare()) System.out.println("E2-1");
        if(r2.getH()!=r2.getW()) System.out.println("E2-2");

        if(!r3.isSquare()) System.out.println("E3-1");
        if(r3.getW()!=r3.getH()) System.out.println("E3-2");
    }
    
    /** #11
     * Integer is immutable
     * Color is immutable
     * Point is not immutable
     * Rectangle is not immutable
     */

     /** #12
      * Integer and String are final because they are immutable and only need to be modified once (at creation)
      */

      //#14
      
}