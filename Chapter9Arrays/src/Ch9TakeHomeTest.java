/**
 * Sean McLoughlin
 * HONOR PLEDGE: All work here is honestly obtained and is my own. Sean McLoughlin
 * Date of Completion:  10/5/2022
 * Assignment: Chapter 9 Take-Home Test
 */
import java.util.Arrays;
public class Ch9TakeHomeTest{
    public static void main(String args[]){
        test();
    }
    public static void test(){
        int[] binary1={1,1,0,0,1,0,1};
        if(translate(binary1)!=101) System.out.println("Error translate test 1");
        int[] binary2={1};
        if(translate(binary2)!=1) System.out.println("Error translate test 2");
        int[] binary3={0,0,0,0,0,0,0,0,0};
        if(translate(binary3)!=0) System.out.println("Error translate test 3");
        System.out.println("translate() tested");
        
        boolean[] life1={true, true, false, true, false, false, true};
        nextGeneration(life1);
        if(!Arrays.equals(life1, new boolean[] {true, true, false, true, false, false, true})) System.out.println("Error nextGeneration test 1");
        boolean[] life2={false,false,false,false,false};
        nextGeneration(life2);
        if(!Arrays.equals(life2,new boolean[] {false,false,false,false,false})) System.out.println("Error nextGeneration test 2");

    }
    /**
     * advences a boolean array one generation in using the game of life rules
     * @param strand
     */
    public static void nextGeneration(boolean[] strand){
        boolean[] rtn=new boolean[strand.length];
        rtn[0]=(strand[1]&&(!strand[strand.length-1])||(!strand[1])&&strand[strand.length-1]);
        rtn[strand.length-1]=strand[0]&&(!strand[strand.length-2])||(!strand[0])&&strand[strand.length-2];
        for(int i=1;i<strand.length-1;i++){
            rtn[i]=(strand[i-1]&&(!strand[i+1]))||((!strand[i-1])&&strand[i+1]);
        }
        strand=rtn;
    }
    /**
     * translates a binary array to an int
     * @param binary
     * @return
     */
    public static int translate(int binary[]){
        int total=0;
        for(int i=0;i<binary.length;i++){
            total+=(Math.pow(2,i)*binary[binary.length-1-i]);
        }
        return total;
    }
}