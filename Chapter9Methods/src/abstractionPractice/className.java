package abstraction;

public class className {
    enum Months{ //enum=group of finalized values grouped together
        JANUARY,FEBRUARY,MARCH,APRIL
    };
    public static void main(String[] args){
        int x=new newClass().myNumber();
        System.out.println(theBaby.minor.y); //references class using the class name
        System.out.println(new newClass().myNumber()); //references inner class
    }
    public static void theClass(){
        System.out.println("found");
        //myClass() - staic methods don't have access to nonstatic methods/variables
    }
    public void myClass(){
        theClass();
    }
    class newClass{  //nested class allows for privatized information
        /*
        public void main(String[] args){ //main is realisticaly never used because rnning the file results in running the outermost classes
            /**
             * if I were to declare other methods or variables, they would be able to be referenced by the outer class
             *./
            System.out.println(Months.JANUARY); //outer class' variable (Months) can be accessed by the inner class without references
        }
        */
        public int myNumber(){
            return 10;
        }
    }
}
