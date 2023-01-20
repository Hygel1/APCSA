/**
 * Sean McLoughlin
 * HONOR PLEDGE: All work here is honestly obtained and is my own. Sean McLoughlin
 * Date of Completion:  1/20/23
 * Assignment: chapter 13 Bookwork
 * 
 * Attribution: Becca Jose
 * 
 * General Description: chapter 13 bookwork
 */
package ch13TeamBookwork;
public class ch13BookWork {
    public static void main(String args[]){
        int[] nums={2,3,4,1,5,6,8,2};
        System.out.println(product(3,3)+" should be 9");
        System.out.println(product(4,1)+" should be 4");

        System.out.println(findMin(nums,5)+" should be 1");
        System.out.println(findMin(nums,2)+" should be 2");
        
        printTriangle(5);
        System.out.println();
        printTriangleB(5);

        System.out.println(sumDigits(22222)+" should be 10");
        System.out.println(sumDigits(4431)+" should be 12");

        System.out.println(div3(12)+" should be true");
        System.out.println(div3(332)+" should be false");

        System.out.println(fib(0)+" should be 0");
        System.out.println(fib(13)+" should be 144");

        System.out.println(binomialCoefficient(3,2)+" should be 3");
        System.out.println(binomialCoefficient(4,2)+" should be 6");

        System.out.println(sequence18(3)+" should be 1.5");
        System.out.println(sequence18(2)+" should be 2");
    }
    /**
     * multiplication via recursion
     */
    public static int product(int x, int num){
        if(num==0) return 0;
        return x+product(x,num-1);
    }
    /**
     * 2. 15
     * 3. EVAH NUF
     * 4. returns the smallest value of the first n elements in the list
     */
    public static int findMin(int[] list, int n){
        if(n<3) return Math.min(list[0],list[1]);
        return Math.min(list[n],findMin(list,n-1));
    }
    /**
     * 5. a,b,c,e,g,h - palendromes
     * 6a. prints a triangle of stars of height num using recursion
     */
    private static void printStars(int num){
        if(num==1) System.out.println("*");
        else{ System.out.print("*");printStars(num-1);}
    }
    private static void printTriangle(int num){
        if(num==1) System.out.println("*");
        else{ printTriangle(num-1);printStars(num);}
    }
    /**
     * 6b.
     */
    private static void printTriangleB(int num){
        if(num==1) System.out.println("*");
        else{ printStars(num);printTriangleB(num-1);}
    }
    /**
     * 7.
     * 0,0,1,0,0,1,2,3
     * 
     * 8a. recursive method that returns the sum of all digits in a non-negative integer
     */
    private static int sumDigits(int num){
        if (num<10) return num;
        return num%10+sumDigits(num/10);
    }
    /**
     * 8b. returns true if a number is divisible by 3 using recursion and no mathematical operators
     */
    private static boolean div3(int n){
        if(n>9) return div3(sumDigits(n));
        return n==3||n==6||n==9;
    }
    /**
     * 9. 0,1,0,2,0,3,0,1,0
     * 11. 8
     * 12a. 4
     * 12b. E
     * 13. 019
     * 14. returns the nth number of the fibonacci sequence using one loop
     */
    private static int fib(int n){
        if(n==0) return n;
        int one=0,two=1;
        for(int i=2;i<n;i++){
            int temp=two;
            two=one+two;
            one=temp;
        }
        return two;
    }
    /**
     * 15. computes a specified binomial coefficient given 0<k<n
     */
    private static int binomialCoefficient(int n,int k){
        if(k==0||n==k) return 1;
        return binomialCoefficient(n-1, k-1)+binomialCoefficient(n-1,k);
    }
    /**
     * 16. make a folder getSize() mtehod using File's getSize() method adding 128 for each file's metadata and 512 for the folder's metadata
     */
    public class File{
        int fileSize;
        public File(int x){
            fileSize=x;
        }
        public int getSize(){
            return fileSize;
        }
    }
    public class Folder{
        int folderSize;
        File[] files;
        public Folder(int numItems){
            files=new File[numItems];
        }
        public int getSize(){
            folderSize=512+files.length*128;
            for(int i=0;i<files.length;i++){
                folderSize+=files[i].getSize();
            }
            return folderSize;
        }
    }
    /**
     * 18. recursively computes th sequence x(n+1)=1+1/[x(n)]
     */
    private static double sequence18(int n){
        if(n<1) return 0; if(n==1) return 1;
        return 1+1/sequence18(n-1);
    }
    /**
     * 19. in other file
     */
    
}
