package Chapter14.Ch12and14Bookwork;
public class ch12And14Bookwork{
    public static void main(String[] args){
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
    }
}