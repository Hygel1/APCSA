package Chapter14.Ch12And14Bookwork;
/**
 * Sean McLoughlin
 * HONOR PLEDGE: All work here is honestly obtained and is my own. Sean McLoughlin
 * Date of Completion: 2/15/23
 * Assignment: Chapter 12 and 14 Bookwork Problems
 * 
 * Attribution: Andrew Dollar was my partner
 * 
 * Everything other than chomp is done in nested classes in a single file, which is why the brackets may not line up as expected
 */
public class ch12and14Bookwork{
    public ch12and14Bookwork(){}
    public static void main(String[] args){
        ch12and14Bookwork t=new ch12and14Bookwork();
        t.test();
    }
    public void test(){
        //Ch12Q4
        Diploma d1=new Diploma("Steve Smith", "Gardening");
        DiplomaWithHonors d2=new DiplomaWithHonors("John Smith", "Robotics");
        System.out.println(d1+"\n");
        System.out.println(d2);
        //ch12Q5
        Haiku p1=new Haiku();
        Limerick p2=new Limerick();
        p1.printRhythm();
        System.out.println();
        p2.printRhythm();
        //ch12Q6
        RightTriangle rT=new RightTriangle(3);
        EquilateralTriangle eT=new EquilateralTriangle(3);
        System.out.println(rT.getArea());
        System.out.println(rT.getPerimeter());
        System.out.println(eT.getArea());
        System.out.println(eT.getPerimeter());
        //right triangle because there is a longer hypotenuse than the legs
        //Ch12Q7
        //The string class inherits the .equals() method from its parent class Object, which does not have a specific case for Strings built in
        
        //Ch12Q12
        //Yes, it will compile. It will return true when the object implements the interface somewhere in its heirarchy
        System.out.println(rT instanceof inter);
        //Tested: it does compile and does return true when the object implements the interface
        
        //Ch12Q15/16/17
        //finished in other files (chomp)

        //Ch14Q2
        Person person1=new Person("John", "Appleseed");
        Person person2=new Person("Abe","Appleseed");
        System.out.println(person1.compareTo(person2));
        //Ch14Q3
        Fraction frac1=new Fraction(3,4);
        Fraction frac2=new Fraction(2,4);
        System.out.println(frac1.compareTo(frac2));
        System.out.println(frac2.compareTo(frac1));
        //Ch14Q4
        QuadraticFunction q1=new QuadraticFunction(1, 1, 1);
        QuadraticFunction q2=new QuadraticFunction(0, 0, 0);
        QuadraticFunction q3=new QuadraticFunction(-2, -2, -2);
        System.out.println(q1);
        System.out.println(q2);
        System.out.println(q3);
        System.out.println(q3.equals(q1));
        System.out.println(q3.equals(new QuadraticFunction(-2, -2, -2)));
        System.out.println(q3.compareTo(q1));
        System.out.println(q1.compareTo(q3));
        System.out.println(new QuadraticComparator().compare(q1,q2));
        System.out.println(new QuadraticComparator(3).compare(q1,q2));
    }
    public class Diploma {
        private String n; //name field
        private String f; //focus field
        public Diploma(String name, String focus){
            n=name; //set fields
            f=focus;
        }
        public String toString(){
            return "This certifies that "+n+"\nhas completed a workshop in "+f; //general statement for diplomas
        }
    }
    public class DiplomaWithHonors extends Diploma{
    
        public DiplomaWithHonors(String n, String f){
            super(n,f); //create parent object
        }
        public String toString(){
            return super.toString()+"\n*** with honors ***"; //append to general statement if honors
        }
    }
    public abstract class Poem {
        public abstract int numLines(); //number of lines to be defined by child class
        public abstract int getSyllables(int k); //number of syllables per line to be defined by child class
        public void printRhythm(){
            for(int i=0;i<numLines();i++){ //for each line
                int nS=getSyllables(i); //store number of syllables in the line
                for(int n=0;n<nS;n++){ //for each syllable in the line
                    if(n==nS-1) System.out.println("ta"); //if it's the last syllable, print and ksip to new line
                    else System.out.print("ta-"); //if not the last syllable, print ta-
                }
            }
        }
    }
    public class Haiku extends Poem{
        private int[] s={5,7,5}; //syllables for each line
        public int numLines(){
            return 3; //3 lines in a Haiku
        }
        public int getSyllables(int k){
            return s[k]; //return the number of syllables for a given line
        }
    }
    public class Limerick extends Poem{
        private int[] s={9,9,6,6,9}; //number of syllables per line
        public int numLines(){
            return 5; //Limerick has 5 lines
        }
        public int getSyllables(int k){
            return s[k]; //return number of syllables for given line
        }
    }
    public abstract class Triangle {
        private double side; //side length of triangle
        public Triangle(double s){
            side=s; //set field
        }
        public double getSide(){
            return side; //return side length
        }
        public abstract double getPerimeter(); //abstract classes for finding perimeter and area
        public abstract double getArea();
    }
    public class RightTriangle extends Triangle implements inter{
        public RightTriangle(double s){
            super(s); //make a parent object Triangle
        }
        public double getArea(){ //define abstract methods
            return getSide()*getSide()/2; //side equation for right triangle
        }
        public double getPerimeter(){
            return 2+Math.sqrt(2)*getSide(); //perimeter equation for right triangle
        }
    }
    public class EquilateralTriangle extends Triangle{
        public EquilateralTriangle(double s){
            super(s); //make parent object
        }
        public double getArea(){ //define abstract methods
            return Math.sqrt(3)/4*getSide()*getSide(); //equation for area of equilateral triangle
        }
        public double getPerimeter(){
            return 3*getSide(); //equation for perimeter of equlateral triangle
        }
    }
    public interface inter{}
    public class Person implements Comparable<Person> {
        String first; //first and last name fields
        String last;
        public Person(String first, String last){
            this.first=first; //set fields
            this.last=last;
        }
        public String getFirst(){
            return first; //return first name
        }
        public String getLast(){
            return last; //return last name
        }
        public int compareTo(Person o) {
            //define interface method to compare people and return number for comparison
            if(last.compareTo(o.getLast())==0) return first.compareTo(o.getFirst());
            return last.compareTo(o.getLast());
        }
    }
    public class Fraction implements Comparable<Fraction>
    {
    // ******************  Instance variables  ******************
    private int num;
    private int denom;

    // *********************  Constructors  *********************

    public Fraction()       // no-args constructor
    {
        num = 0;
        denom = 1;
    }

    public Fraction(int n)
    {
        num = n;
        denom = 1;
    }
    public Fraction(int n, int d)
    {
        if (d != 0)
        {
        num = n;
        denom = d;
        reduce();
        }
        else
        {
        throw new IllegalArgumentException(
            "Fraction construction error: denominator is 0");
        }
    }
    public Fraction(Fraction other)  // copy constructor
    {
        num = other.num;
        denom = other.denom;
    }
    // ********************  Public methods  ********************
    // Returns the sum of this fraction and other
    public int compareTo(Fraction frac){
        return add(frac.multiply(-1)).isNeg(); //subtract the calling fraction fromthe passed fraction by adding a negtive version of the passed
        //then call isNeg to get outcome number and return
    }
    /**
     * helper method to avoid repeatedly calling hold Fraction and making several getters
     * @return returns the value to be returned by compareTo() -- pos for greater, neg for less than, 0 for equal
     */
    private int isNeg(){
        if(num==0) return 0; //if the numerator is 0, the fractions are equal (0)
        if(num<0&&denom<0||num>0&&denom>0) return 1; //if the sign of the num and denom are similar, the result is positive and the calling fraction is larger
        return -1; //all other cases are negative
    }
    public Fraction add(Fraction other)
    {
        int newNum = num * other.denom + denom * other.num;
        int newDenom = denom * other.denom;
        return new Fraction(newNum, newDenom);
    }
    // Returns the sum of this fraction and m
    public Fraction add(int m)
    {
        return new Fraction(num + m * denom, denom);
    }
    // Returns the product of this fraction and other
    public Fraction multiply(Fraction other)
    {
        int newNum = num * other.num;
        int newDenom = denom * other.denom;
        return new Fraction(newNum, newDenom);
    }
    // Returns the product of this fraction and m
    public Fraction multiply(int m)
    {
        return new Fraction(num * m, denom);
    }
    // Returns the value of this fraction as a double
    public double getValue()
    {
        return (double)num / (double)denom;
    }
    
    // Returns a string representation of this fraction
    public String toString()
    {
        return num + "/" + denom;
    }
    // *******************  Private methods  ********************

    // Reduces this fraction by the gcf and makes denom > 0
    private void reduce()
    {
        if (num == 0)
        {
        denom = 1;
        return;
        }

        if (denom < 0)
        {
        num = -num;
        denom = -denom;
        }

        int q = gcf(Math.abs(num), denom);
        num /= q;
        denom /= q;    
    }

    // Returns the greatest common factor of two positive integers
    private int gcf(int n, int d)
    {
        if (n <= 0 || d <= 0)
        {
        throw new IllegalArgumentException(
                    "gcf precondition failed: " + n + ", " + d);
        }

        while (d != 0)
        {
        int temp = d;
        d = n % d;
        n = temp;
        }
        return n;
    }
    }
    public class QuadraticFunction implements Comparable<QuadraticFunction>{
        int a,b,c;
        public QuadraticFunction(int a,int b,int c){
            this.a=a;this.b=b;this.c=c; //set fields
        }
        /**
         * retrun value of function plugging in coefficients and x value
         * @param x
         * @return
         */
        public double valueAt(double x){
            return a*x*x+b*x+c;
        }
        //getters
        public int getA(){return a;}
        public int getB(){return b;}
        public int getC(){return c;}
        /**
         * returns true if all coefficients are equal using getters
         * @param q
         * @return
         */
        public boolean equals(QuadraticFunction q){
            return a==q.getA()&&b==q.getB()&&c==q.getC();
        }
        /**
         * if val=-1, subtract with no coefficient, if val<-1, subtract with coefficient, if val=0 remove section, if val=1, add with no coefficient, if val<1, add with coefficient
         */
        public String toString(){
            String rtn="";
            if(a==-1)rtn+="-x^2";else if(a==1)rtn+="x^2";else if(Math.abs(a)>1)rtn+=a+"x^2";
            if(b==-1)rtn+="-x";else if(b==1)rtn+="+x";else if(b<0)rtn+=b+"x";else if(b>0) rtn+="+"+b+"x";
            if(c>0)rtn+="+"+c;else if(c<0)rtn+=c;
            return rtn;
        }
        /**
         * compare two functions using coeffficients
         * @param o
         * @return
         */
        public int compareTo(QuadraticFunction o) {
            if(a!=o.getA()) return a-o.getA();
            if(b!=o.getB()) return b-o.getB();
            return c-o.getC();
        }
    }
    public class QuadraticComparator{
        double x=0; //x defaults to 0
        public QuadraticComparator(){}
        public QuadraticComparator(double x){this.x=x;} //set x
        /**
         * returns the difference in value at x -- x1-x2
         * @param q1
         * @param q2
         * @return
         */
        public double compare(QuadraticFunction q1, QuadraticFunction q2){
            return q1.valueAt(x)-q2.valueAt(x);
        }
    }
}