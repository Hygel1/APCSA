import java.util.Arrays;
public class testFile{
    public static void main(String[] args){
        try{
            System.out.println("1");
            int num=5/0;
            System.out.println("2");
        }
        catch(Exception e){
            System.out.println("done");
        }
    }

    
}