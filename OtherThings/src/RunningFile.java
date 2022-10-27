package OtherThings.src;
import java.io.IOException;
public class RunningFile {
    public static void main(String args[]) throws IOException{
        MakePic picture=new MakePic(500,500);
        picture.fillBlack();
        picture.createFile("myPic");
    }
}
