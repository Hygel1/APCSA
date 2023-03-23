package Chapter19;
/**
 * Sean McLoughlin
 * HONOR PLEDGE: All work here is honestly obtained and is my own. Sean McLoughlin
 * Date of Completion: 3/21/23
 * Assignment: Chapter 19 Bookwork #6-9
 */
public class chapter19Bookwork {
    public static void main(String[] args){
        System.out.println(removeConsecutiveDuplicates("aabbccddeeffgg"));
        System.out.println(countPaths(4,4));
    }
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
     * proof: picture attached
     * dS(n)=N+N(1+dS(n-1))=2*N+N*dS(n-1)=((n-1)*dS(n-1)/(n-1))+N*dS(n-1)=((2*N^2-2*N)/(N-1))+N*dS(n-1)=
     * (2*n^2-2*N)/(N-1)+N*(3*N^(n-1)-N^(n-2)-2*N)/(N-1)=(2*N^2-2*N)/(N-1)+(3*N^n-N^(n-1)-2*N^2)/(N-1)=
     * (3*N^n-N^(n-1)-2*N)/(N-1)
     *  
     * on every call, the for loop requires N calls to knows (N+...)
     * on every call, if knows() returns true, there are N calls to dS() plus an initial call for each N*(dS()+1)
     * dS(n)=N+N*(dS(n-1)+1)
     */
    /**
     * question 8
     * @param str String to be reversed
     * @return
     */
    public static String removeConsecutiveDuplicates(String str){
        if(str.length()<2) return str;
        if(str.charAt(0)==str.charAt(1)) return str.charAt(0)+removeConsecutiveDuplicates(str.substring(2));
        return str.charAt(0)+removeConsecutiveDuplicates(str.substring(1));
    }
    /**
     * question 9
     * @param x starting x value
     * @param y starting y value
     * @return the number of paths able to be taken to (0,0)
     */
    public static long countPaths(int x, int y){
        if(x==0||y==0) return x+y;
        else return countPaths(x-1, y)+countPaths(x, y-1);
    }
}
