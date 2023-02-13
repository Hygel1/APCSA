package Chapter14.Ch12and14Bookwork;

public class Diploma {
    private String n;
    private String f;
    public Diploma(String name, String focus){
        n=name;
        f=focus;
    }
    public String toString(){
        return "This certifies that "+n+"\nhas completed a workshop in "+f;
    }
}

