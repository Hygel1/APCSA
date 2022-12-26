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
        testing();
    }
    public static void testing(){
        System.out.println("Testing insertionSort()...");
        int[] arr={3,4,7,5,6,2,1,9,8};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr)+" should be [1,2,3,4,5,6,7,8,9]");
        //Testing bewBinarySearch()
        System.out.println("\nTesting newBinarySearch()...");
        int[] arr2={10, 20, 30, 50, 60, 80, 110, 130, 140, 170};
        System.out.println(newBinarySearch(arr2, 110)+" should be 6");
        //Testing araySum()
        System.out.println("\nTesting arraySum()...");
        System.out.println(arraySum(arr2)+" should be 800");
        //Testing rowSums()
        System.out.println("\nTesting rowSums()...");
        int[][] rows={{1,9,2},{2,8,3},{3,7,4},{4,6,5}};
        System.out.println(Arrays.toString(rowSums(rows))+" should be [12,13,14,15]");
        //Testing isDiverse()
        System.out.println("\nTesting isDiverse()...");
        System.out.println(isDiverse(rows)+" should be true");
        rows[0][2]=3; System.out.println(isDiverse(rows)+" should be false");
        //Testing HIddenWord
        System.out.println("\nTesting HiddenWord...");
        System.out.println(new HiddenWord("APCSA").getHint("ASFG")+"should be A+**");
        //Testing Mountain
        System.out.println("\nTesting Mountain...");
        int[] mnt={1,2,5,3,4,5,6};
        System.out.println(getPeakIndex(mnt)+" should be 2");
        System.out.println(isMountain(mnt)+" should be false");
        int[] mnt1={1,2,3,4,5,4,3,2,1};System.out.println(isMountain(mnt1)+" should be true");
        //Testing binarySearch()
        System.out.println("\ntesting binarySearch()...");
        System.out.println(newBinarySearch(mnt,3)+" should be 3");
        //Testing merge()
        System.out.println("\nTesting merge()...");
        System.out.println(Arrays.toString(merge(new String[] {"a","e","f"},new String[]{"b","d","z"}))+" should be [a,b,d,e,f,z]");
        //Testing partition
        System.out.println("\nTesting partition");
        partition(mnt1);
        System.out.println(Arrays.toString(mnt1)+" should be split odd-even");
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
    /**
     * returns true if the sum of each row is diverse to every other sum
     * @param arr2D
     * @return
     */
    public static boolean isDiverse(int[][] arr2D){
        int[] arr=rowSums(arr2D);
        for(int i=0;i<arr.length;i++){
            for(int n=0;n<arr.length;n++){
                if(i!=n&&arr[i]==arr[n]) return false;
            }
        }
        return true;
    }
    //could use indexOf()
    /**
     * gives hints to find a hidden word using clues ina  returned String
     * If the letter guessed is in the hidden word and in the right spot, the letter is left
     * If the letter guesed is in the hiddenw ord but is in the wrong position, a "+" is put in the guessed place
     * If the letter guessed is not in the word at all, a "*" is put in its position
     * 
     * The returned String is a modified version of the guess, not the answer
     */
    public static class HiddenWord{
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
        public static boolean isIncreasing(int[] array, int stop){
            if(array.length<=stop) return false;
            for(int i=0;i<stop-1;i++){
                if(array[i]>=array[i+1]) return false;
            }
            return true;
        }
        public static boolean isDecreasing(int[] array, int stop){
            if(array.length<=stop) return false;
            for(int i=0;i<stop-1;i++){
                if(array[i]<=array[i+1]) return false;
            }
            return true;
        }
        public static int getPeakIndex(int[] array){
            for(int i=1;i<array.length-1;i++){
                if(array[i-1]<array[i]&&array[i+1]<array[i]) return i;
            }
            return -1;
        }
        public static boolean isMountain(int[] array){
            if(getPeakIndex(array)==-1) return false;
            for(int i=1;i<getPeakIndex(array);i++){
                if(array[i]<array[i-1]) return false;
            }
            for(int i=getPeakIndex(array);i<array.length-1;i++){
                if(array[i]<array[i+1]) return false;
            }
            return true;
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
            if(list1[p1].compareTo(list2[p2])<0){
                rtn[p1+p2]=list1[p1];p1++;
            }
            else{
                rtn[p1+p2]=list2[p2];p2++;
            }
        }
        while(p1<list1.length){rtn[p1+p2]=list1[p1]; p1++;}
        while(p2<list2.length){rtn[p1+p2]=list2[p2]; p2++;}
        //if(p1<list1.length) for(int i=p2+p1;i<list2.length;i++) rtn[p2]=list1[i];
        //else if(p2<list2.length) for(int i=p2+p1;i<list2.length;i++) rtn[p1]=list2[i];
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
            else if(a[e]%2==0) e--;
            else if(a[s]%2==0&&a[e]%2==1){
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
