package Chapter19;

import java.util.concurrent.CountDownLatch;

public class chapter19Bookwork {
    /**
     * Q6: Hypothesis mysterySum(n)=n^2
     * 
     * Base Case: 
     *  mS(1)=1                         (works)
     * Test: mS(n)=mS(n-1)+2*n-1        
     *  mS(2)=mS(1)+2*2-1=1+4-1=4       (works)
     * 
     * (n-1)^2+2*n-1=n^2-n-n+1+2*n-1=n^2-2n+2n+1-1=n^2
     * 
     * it would be easier and less resource intensive to use a for loop
     */
    /**
     * Q7: N=number of people in the set        n=possible depth
     * Base Case:
     *  dS(1)=1;
     * Test: dS(n)=(3*N^n-N^(n-1)-2*N)/(N-1)
     *  dS(2)=(3*N^2-N^(1)-2*N)/(N-1)=(n*(3*n-3))/(n-1)=3*n
     *  dS(3)=(3*N^3-N^(3-1)-2*N)/(N-1)=(N*(3*N^2-N-2))/(N-1)=(N*(3*N+2)*(N-1))/(N-1)=N*(3*N+2)=3*N^2+2*N
     * 
     *dS(n)=()
     *  
     */
    /**
     * question 8
     * @param str
     * @return
     */
    public static String removeConsecutiveDuplicates(String str){
        if(str.length()<2) return str;
        if(str.length()==2&&str.charAt(0)==str.charAt(0)) return str.charAt(0)+"";
        if(str.charAt(0)==str.charAt(1)) return removeConsecutiveDuplicates(str.substring(1));
        return str.charAt(0)+removeConsecutiveDuplicates(str.substring(1));
    }
    /**
     * 
     * @param x
     * @param y
     * @return
     */
    public long countPaths(int x, int y){
 
    }
}
