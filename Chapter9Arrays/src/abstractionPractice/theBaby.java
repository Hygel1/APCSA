package abstractionPractice;

public class theBaby extends className{
    public static void main(String[] args){
        theClass();
        System.out.println(minor.y); //references inner class
        System.out.println(className.myNumber()); //directly references parent class' inner class
        //note: when the parent's inner class and/or the method were private, this was not allowed
    }
    static class minor{ //nested class defines variable to be used in outer class
    //staticising this class makes it able to be used without referencing the parent class
        static int y=0;
    }
}
