package OtherThings.src;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MakePic {
        int width;
        int height;
        BufferedImage bfImg;
        Graphics2D g2d;
        File file;
        public MakePic(int w,int h){
            width=w;
            height=h;
            bfImg=new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
            g2d=bfImg.createGraphics();
        }
        public void fillBlack(){
            g2d.setColor(Color.black);
            g2d.fillRect(0,height,0,height);
        }
        public void createFile(String fileName) throws IOException{
            file=new File(fileName+".png");
            ImageIO.write(bfImg, "png", file);
        }
        public void updateFile() throws IOException{
            ImageIO.write(bfImg, "png", file);
        }
}
