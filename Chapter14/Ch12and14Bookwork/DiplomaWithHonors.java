package Chapter14.Ch12and14Bookwork;

public class DiplomaWithHonors extends Diploma{
    
    public DiplomaWithHonors(String n, String f){
        super(n,f);
    }
    public String toString(){
        return super.toString()+"\n*** with honors ***";
    }
}
