package Chapter14.ch12And14Bookwork;
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
        
        //Ch12Q15
 
        //Ch12Q16
        Person person1=new Person("John", "Appleseed");
        Person person2=new Person("Abe","Appleseed");
        System.out.println(person1.compareTo(person2));
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
}