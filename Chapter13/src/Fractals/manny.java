package Fractals;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class manny{
    public static void main(String[] args){
        drawMandelbrot(300, 300);
    }
    public static boolean isIncreasing(ArrayList<ComplexNumber> aL){
        boolean b1=true,b2=true;
        for(int i=0;i<aL.size()-1;i++){
            if(b1&&Math.abs(aL.get(i).getReal())>Math.abs(aL.get(i+1).getReal())){b1=false; System.out.println(1);}
            if(b2&&aL.get(i).getComplex()>aL.get(i+1).getComplex()){b2=false;System.out.println(2);}
        }
        aL.clear();
        if(b1||b2) num1++;
        return b1||b2;
    }
    static int num1=0,num2=0;
    static ArrayList ma=new ArrayList<ComplexNumber>();
    /**
     * decides whether or not a certain number drifts off to infinity with given values
     * @param iterations number of times to test, decrements with recursion
     * @param n previous value of equation
     * @param c constant value being tested
     * @return
     */
    public static boolean mandelbrotEquation(int iterations, ComplexNumber n, ComplexNumber c){
        if(n.getReal()*n.getReal()+n.getComplex()*n.getComplex()>4) return false;
        if(iterations==0) return true;
        ma.add(n);
        return mandelbrotEquation(iterations-1, n.multiply(n).add(c),c);
    }

    public static void drawMandelbrot(int width, int height){
        BufferedImage img=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g=img.createGraphics(); //make graphics and image to write output to
        g.setColor(Color.WHITE);
        for(int w=0;w<width;w++){ 
            for(int h=0;h<height;h++){//go through every pixel in range
               if(mandelbrotEquation(8,new ComplexNumber(0, 0),new ComplexNumber(map(w,0,width,-1,1), map(h,0,height,-1,1)))){
                //if the point is in the set...
                g.drawLine(w, h, w, h);
               }
            }
        }
        File fOut=new File("mandelbrot.png");
        try{ImageIO.write(img,"png",fOut);} catch(IOException e){System.out.println("uh oh");}
    }
    /**
     * find the equivelant of number num from range range11-range12 in range21-range22; converts ranges
     * @param num
     * @param range
     * @return
     */
    public static double map(double num, double range11, double range12, double range21, double range22){
        return (double) (num-range11+range21)/(range12-range11)*(range22-range21);

    }
    public static class ComplexNumber{
        double real,com;
        public ComplexNumber(double real, double com){
            this.real=real;
            this.com=com;
        }
        public double getReal(){
            return real;
        }
        public double getVal(){
            return real*real-com*com;
        }
        public double getComplex(){
            return com;
        }
        public ComplexNumber add(ComplexNumber n){
            return new ComplexNumber(real+n.getReal(),com+n.getComplex());
        }
        public ComplexNumber multiply(ComplexNumber n){
            return new ComplexNumber(real*n.getReal()+com*n.getComplex(), real*n.getComplex()+com*n.getReal());
        }
    }
}
