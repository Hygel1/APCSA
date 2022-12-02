/**
 * Sean McLoughlin
 * HONOR PLEDGE: All work here is honestly obtained and is my own. Sean McLoughlin
 * Date of Completion: 11/29/2022
 * Assignment: Term 1 Exam corrections
 * 
 * Attribution: 
 * 
 * General Description: copy of written portion of exam with corrections
 */
import java.util.Arrays;
public class Test1Exam {
    public static void main(String args[]){
        int[] arr={3,4,7,5,6,2,1,9,8};
        insertionSort(arr);
        //System.out.println(Arrays.toString(arr));
        int[] arr2={10, 20, 30, 50, 60, 80, 110, 130, 140, 170};
        System.out.println(newBinarySearch(arr2, 110));
    }
    public static int arraySum(int[] arr){
        int hold=0;
        for(int num:arr){
            hold+=num;
        }
        return hold;
    }
    //must use arraySum() -- old version
    /*
    public static int[] rowSums(int[][] arr2D){
        int[] rtn=new int[arr2D.length];
        for(int i=0;i<rtn.length;i++){
            int hold=0;
            for(int num:arr2D[i]){
                hold+=num;
            }
            rtn[i]=hold;
        }
        return rtn;
    } */
    //new version
    /**
     * returns the sum of elements in a 2D int array as an array of sums
     * @param arr2D
     * @return
     */
    public static int[] rowSums(int[][] arr2D){
        int[] rtn=new int[arr2D.length];
        for(int i=0;i<arr2D.length;i++){
            rtn[i]=arraySum(arr2D[i]);
        }
        return rtn;
    }
    //what if i=n - old version
    /*
    public static boolean isDiverse(int[][] arr2D){
        int[] arr=rowSums(arr2D);
        for(int i=0;i<arr.length;i++){
            for(int n=0;n<arr.length;i++){
                if(arr[i]==arr[n]) return false;
            }
        }
        return true;
    } **/

    //new version
    public static boolean isDiverse(int[][] arr2D){
        int[] arr=rowSums(arr2D);
        for(int i=0;i<arr.length;i++){
            for(int n=0;n<arr.length;i++){
                if(i!=n&&arr[i]==arr[n]) return false;
            }
        }
        return true;
    }
    //could use indexOf()
    public class HiddenWord{
        public String word;
        public HiddenWord(String word){
            this.word=word;
        }
        public String getHint(String guess){
            String rtn="";
            for(int i=0;i<guess.length();i++){
                if(guess.charAt(i)==word.charAt(i)) rtn+=word.charAt(i)+"";
                else{
                    for(int n=0;n<guess.length();n++){
                        if(guess.charAt(i)==word.charAt(n)){
                            rtn+="+";
                            break;
                        }
                        else if(n==guess.length()-1) rtn+="*";
                    }
                }
            }
            return rtn;
        }
    }
    public class Mountain{
        public boolean isIncreasing(int[] array, int stop){
            if(array.length<=stop) return false;
            for(int i=0;i<stop-1;i++){
                if(array[i]>=array[i+1]) return false;
            }
            return true;
        }
        public boolean isDecreasing(int[] array, int stop){
            if(array.length<=stop) return false;
            for(int i=0;i<stop-1;i++){
                if(array[i]<=array[i+1]) return false;
            }
            return true;
        }
        public int getPeakIndex(int[] array){
            for(int i=0;i<array.length-1;i++){
                if(array[i-1]<array[i]&&array[i+1]<array[i]) return i;
            }
            return -1;
        }
        public boolean isMountain(int[] array){
            if(getPeakIndex(array)==-1) return false;
            for(int i=0;i<getPeakIndex(array);i++){
                if(array[i]<array[i-1]) return false;
            }
            for(int i=getPeakIndex(array);i<array.length-1;i++){
                if(array[i]<array[i+1]) return false;
            }
            return true;
        }
    }
    //wrong, not binary search
    /*
        public static int binarySearch(int[] a, int target){
        for(int i=0;i<a.length;i++){
            if(a[i]==target) return i;
        }
        return -1;
    } */
    /**
     * fixed versoin of binary search that is actually binary search
     * @param a
     * @param target
     * @return
     */
    public static int newBinarySearch(int[] a, int target){
        int p1=0,p2=a.length-1;
        while(p1!=p2){
            int point=((p2-p1)/2)+p1;
            if(a[point]==target) return point;
            else if(a[point]>target) p2=point;
            else p1=point;
        }
        return -1;
    }
    /**
     * takes two String arrays and combines them into one larger array by putting them in order of index
     * @param list1
     * @param list2
     * @return
     */
    public static String[] merge(String[] list1, String[] list2){
        String[] rtn=new String[list1.length+list2.length];
        int p1=0,p2=0;
        while(p1<list1.length&&p2<list2.length){
            if(list1[p1].compareTo(list2[p2])>0){
                rtn[p1+p2]=list1[p1];p1++;
            }
            else{
                rtn[p1+p2]=list2[p2];p2++;
            }
        }
        if(p1<list2.length) for(int i=p2;i<list2.length;i++) rtn[p2+1]=list1[i];
        else if(p2<list2.length) for(int i=p2;i<list2.length;i++) rtn[p1+1]=list2[i];
        return rtn;
    }
    /**
     * places all even numbers at the back of the array and all odd values in the front without using a separate array as a workspace
     * @param a
     */
    public static void partition(int[] a){
        int s=0, e=a.length-1;
        while(s<e){
            if(a[s]%2==1)s++;
            if(a[e]%2==0) e--; //these two were marked as wrong because I didn't but else but else doesn't make muhc sense, it seems more efficient without it
            if(a[s]%2==0&&a[e]%2==1){
                int hold=a[s]; a[s]=a[e]; a[e]=hold; s++; e--;
            }
        }
    }

    //Tested and works
    /**
     * sorts the array in ascending array using insertion sort and no workspace array
     * @param a
     */
    public static void insertionSort(int[] a){
        for(int i=1;i<a.length;i++){
            if(a[i-1]>a[i]){
                for(int n=0;n<i;n++){
                    if(a[n]>a[i]){
                        int hold=a[i];
                        for(int k=i;k>n;k--){
                            a[k]=a[k-1];
                        }
                        a[n]=hold;
                    }
                }
            }
        }
    }
}
