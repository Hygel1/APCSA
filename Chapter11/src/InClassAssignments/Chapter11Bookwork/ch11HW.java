package InClassAssignments.Chapter11Bookwork;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.math.BigInteger;
/**
 * Sean McLoughlin
 * HONOR PLEDGE: All work here is honestly obtained and is my own. Sean McLoughlin
 * Date of Completion: 12/7/2022
 * Assignment: Ch11 Homework
 * 
 * General Description: Chapter 11 Assigned Problems
 */
public class ch11HW {
    public static void main(String args[]){
        test();
    }
    public static void test(){
        //test fillBuckets()
        System.out.println("Testing fillBuckets()...");
        String[] words = new String[] {"Hello", "Hi", "Apple", "Aardvark", "Zebra"};
        ArrayList<String> dictionary = new ArrayList(Arrays.asList(words));
        ArrayList<ArrayList<String>> buckets = fillBuckets(dictionary);
        System.out.println(buckets);
        //test reverse()
        System.out.println("Testing reverse()...");
        System.out.println(reverse(dictionary)+" should be Zebra, Aardvark, Apple, Hi, Hello");
        //Testing removeSmallest()
        System.out.println("Testing removeSmallest()...");
        int[] numms={2,3,4,5,1,6,7};
        ArrayList<Integer> nums=new ArrayList<Integer>(); for(int number: numms) nums.add(number);
        removeSmallest(nums);
        System.out.println(nums+" should be 2,3,4,5,6,7");
        //Testing filter()
        System.out.println("Testing filter()...");
        Object obj1=new ArrayList<>(), obj2=new FileNotFoundException();
        Object[] objs={obj1,obj1,obj1,obj1,obj2,obj1}; 
        ArrayList<Object> objects=new ArrayList<>(); for(Object els:objs) objects.add(els);
        ArrayList<Object> objects1=new ArrayList<>(); objects1.add(obj2);
        filter(objects, objects1);
        System.out.println(objects+" should be [] [] [] [] []");
        //Testing removeConsecutiveDuplicates()
        System.out.println("Testing removeConsecutiveDuplicates()...");
        String[] strs={"one","two","two","three"};
        ArrayList<String> rmcd=new ArrayList(Arrays.asList(strs));
        removeConsecutiveDuplicates(rmcd);
        System.out.println(rmcd+" should be one, two, three");
        //Testing fib()
        System.out.println("Testing fib()...");
        System.out.println(fib(100).get(99)+" should be 354,224,848,179,261,915,075");
    }
    public static void print2d(ArrayList<ArrayList<String>> list){
        for(ArrayList<String> el:list){ for(String elem: el) System.out.print(elem+" ");System.out.println();}
    }
    public static final String alphabet="abcdefghijklmnopqrstuvwxyz";
    /**
     * Question 13
     * sorts an ArrayList of Strings in individual "buckets" that contain only Strings that start with a specific letter
     * buckets are sorted in alphabetical order according to their index
     * @param words initial ArrayList of Strings to be sorted
     * @return returns a 2d ArrayList of Strings sorted in alphabetical order
     */
    public static ArrayList<ArrayList<String>> fillBuckets(ArrayList<String> words){
        ArrayList<ArrayList<String>> rtn=new ArrayList<>(26);//list of 26 undeclared buckets (size=0)
        for(int i=0;i<26;i++){ //becaues each bucket starts at null, we have to declare each one individually
            rtn.add(new ArrayList<String>());
        }
        for(String word: words){ //visits every word and copies it into its "bucket"
            rtn.get(alphabet.indexOf(Character.toLowerCase(word.charAt(0)))).add(word); //instead of the alphabet String and using indexOf(), we could use Character.getNumericalValue(char)
        }
        return rtn;
    }
    /**
     * Question 1
     * a. false
     * b. true
     * c. false
     * d. false
     * e. true
     */
    /**
     * Question 2
     * a. true
     * b. false
     * c. false
     * d. false
     */
    /**
     * Question 3
     * you already know the size of the array
     * you need to save space in your program
     */
    /**
     * Question 4
     * [0,0,1,1,2,2]
     */
    /**
     * Question 5
     * cycles through the ArrayList and adds the current value to the beginning of the returned list every time, 
     * making the first visited element the last element in the returned list
     */
    public static ArrayList<String> reverse(ArrayList<String> list){
        ArrayList<String> rtn=new ArrayList<String>(list.size());
        for(String el:list) rtn.add(0,el);
        return rtn;
    }
    /**
     * Question 6
     * cycles through the list to find the smallest element, storing the index of the smallest so far.
     * calls .remove() on the smallest found index
     */
    public static void removeSmallest(ArrayList<Integer> list){
        int small=0;
        for(int i=1;i<list.size();i++) if(list.get(i)<list.get(small)) small=i;
        list.remove(small);
    }
    /**
     * Question 7
     * cycles through list1 and list2 to find matches; if a match is found, the item is removed from list1 and the loop if broken
     */
    public static void filter(ArrayList<Object> list1, ArrayList<Object> list2){
        for(int i=list1.size()-1;i>-1;i--){ 
            Object compare=list1.get(i); //used to prevent constant duplicate lookup
            for(Object el:list2) if(compare==el){
                list1.remove(i);
                break;
            }
        }
    }
    /**
     * Question 10
     * cycles through the list (other than the last)
     */
    public static void removeConsecutiveDuplicates(ArrayList<String> lst){
        for(int i=lst.size()-1;i>0;i--){
            if(lst.get(i).equals(lst.get(i-1))){
                lst.remove(i-1);
            }
        }
    }
    /**
     * Question 11
     * generates a list of the first n values in the fibonacci sequence
     */
    public static ArrayList<BigInteger> fib(int n){
        ArrayList<BigInteger> rtn=new ArrayList<>();
        if(n>0)rtn.add(new BigInteger("1"));if(n>1)rtn.add(new BigInteger("1")); //adds the first two values if necessary
        for(int i=2;i<n;i++){
            rtn.add((new BigInteger(rtn.get(i-2).add(rtn.get(i-1)).toString()))); //calculates the next value
        }
        return rtn;
    }

}