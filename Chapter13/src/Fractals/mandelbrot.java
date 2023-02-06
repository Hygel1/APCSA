package Fractals;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class mandelbrot {
    static int counter=0;

    static int w=1000;
    static int h=1000;
    static BufferedImage bI=new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
    static Graphics2D g=bI.createGraphics();
    static File file=new File("mandelbrot.png");
    public static void main(String[] args){
        /*g.setColor(Color.GREEN);
        g.fillRect(0,0,1000,1000);
        g.setColor(Color.BLACK);
        drawIt(1000);
        System.out.println(counter);
        try {ImageIO.write(bI, "png", file);} catch (IOException e) {e.printStackTrace();}
        Complex num=new Complex(1, .4);
        while(num.getReal()<2&&num.getIm()<2){
            System.out.println(num.multiply(num));
        }*/
        //System.out.println(map(0,0,1000,-1,1)); 

    }
    public static void drawIt(int depth){
        for(int y=0;y<h;y++){
            for(int x=0;x<w;x++){
                Complex current=new Complex((x-w/2)*4/w, (y-h/2)*4/h);
                //if(Math.abs(current.getReal())>1||Math.abs(current.getIm())>1) System.out.println(current);
                if(mandEquation(depth, new Complex(0,0), current)){bI.setRGB(x, y, Color.black.getRGB());counter++;}
            }
        }
    }
    public static double map(double value, double fromLow, double fromHigh, double toLow, double toHigh){
        return (toHigh-toLow)/(fromHigh-fromLow)*(value-fromLow)+toLow;
    }
    /**
     * recursively computes each step of the set's equation z(n+1)=z(n)^2+C
     * z is the recursive value and c is a complex constant as pictured on graphed output
     * on iteration 0, z is 0,  which means iteration1=C
     * @param depth depth to recurse, decrements with call
     * @param z finished product passed form call to call
     * @param c constant remains untouched when passed from call to call
     * @return whether or not the set is a part of the set based on depth iterations of the equation
     */
    public static boolean mandEquation(int depth, Complex z, Complex c){
        if(depth==0) return false; //if number of attempts is met, give up :(
        if(z.getMag()<4) return true; //if at any point, the squared number reaches 2, then the equation will bounce to infinity
        return mandEquation(depth-1, z, c); //z(n+1)
    }


    /**
     * Class to define and compute complex numbers
     */
    public static class Complex{
        double real;
        double im;
        public Complex(double r,double c){
            real=r;
            im=c;
        }
        public double getMag(){
            return real*real+im*im;
        }
        public double getReal(){
            return real;
        }
        public double getIm(){
            return im;
        }
        public Complex multiply(Complex c){
            real=real*c.getReal()-im*c.getIm();
            im=real*c.getIm()+im*c.getReal();
            return this;
        }
        public Complex add(Complex c){
            real+=c.getReal();
            im+=c.getIm();
            return this;
        }
        public Complex subtract(Complex c){
            real-=c.getReal();
            im-=c.getIm();
            return this;
        }
        public Complex divide(Complex c){
            real=(real+im)/(c.getReal()+c.getIm());
            im=(im*c.getReal()-real*c.getIm())/(c.getReal()*c.getReal()+c.getIm()*c.getIm());
            return this;
        }
        public boolean equals(Complex c){
            return real==c.getReal()&&im==c.getIm();
        }
        public  String toString(){
            return real+" + "+im+"i";
        }
    }
}
/**
     * draws the set using for loops which call a recursive function to use the formula
     * @param depth number of tries for each point
     * @param screen passed array of points, prefferably empty because everythingn will be overwritten
     */
    /*
    public void drawMan(int depth, Complex[][] screen){
        for(int y=0;y<screen.length;y++){ //for every row
            for(int x=0;x<screen[y].length;x++){ //for every column
                screen[y][x]=new Complex((screen[y].length/2+(x-screen[y].length/2)),(screen.length/2+y-screen.length)); //set plot points right before finding result
                if(mandEquation(depth,new Complex(0,0),screen[y][x])){ //if the 
                    t.penDown();
                    forward(1);
                    numCall++;
                }
                else{
                    t.penUp();
                    forward(1);
                    numCall++;
                }
            }
            t.penUp();
            turn(90);
            forward(1);
            turn(-90);
            backward(screen[y].length);
        }
    }
*/