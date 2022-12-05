package InClassAssignments.Chapter11Bookwork;
import java.util.ArrayList;
import java.math.BigInteger;
public class Fibonacci{
    public static void main(String args[]){
        ArrayList<BigInteger> fibs=fibList(100);
        System.out.println("Num of digits in fib100 is "+fibs.get(fibs.size()-1).toString().length());
    }
    /**
     * generates and returns a list of the firsts n BigIntegers corresponding to the fibonacci sequence
     * @param n
     * @return
     */
    public static ArrayList<BigInteger> fibList(int n){
        ArrayList<BigInteger> rtn=new ArrayList<>();
        rtn.add(new BigInteger("1")); //BigInteger takes String as a constructor because it translates number too large to fit into ints
        rtn.add(new BigInteger("1"));
       for(int i=2;i<n;i++){
        rtn.add(rtn.get(i-2).add(rtn.get(i-1)));
       }
        return rtn;
    }
}