/**
 * Sean McLoughlin
 * HONOR PLEDGE: All work here is honestly obtained and is my own. Sean McLoughlin
 * Date of Completion:  9/26/2022
 * Assignment: AP Questions and CodingBat
 * 
 * Attribution: 
 * 
 * General Description: 10 questions from AP-1 CodingBat section
 * 
 * Advanced: 
 * 
 * Errata: 
 */
import java.util.Arrays;

public class codingBatAP1{
    public static void main(String[] args){

    }
    /**
     * returns a boolean stating whether each element of the array is greater than or equal to the last
     * @param scores
     * @return
     */
public boolean scoresIncreasing(int[] scores){
    for(int i=1;i<scores.length;i++){
        if(!(scores[i]>=scores[i-1])) return false;
      }
      return true;
}
/**
 * returns a boolean stating whether or not an array contains two 100 values next to each other
 * @param scores
 * @return
 */
    public boolean scores100(int[] scores){
        for(int i=0;i<scores.length-1;i++){
            if(scores[i]==100&&scores[i+1]==100) return true;
          }
          return false;
    }
    /**
     * returns whether or not there is a clump of 3 values varying at most 2
     * @param scores
     * @return
     */
    public boolean scoresClump(int[] scores) {
        for(int i=0;i<scores.length-2;i++){
          if(Math.abs(scores[i]-scores[i+1])<=2&&Math.abs(scores[i]-scores[i+2])<=2) return true;
        }
        return false;
      }
      /**
       * returns the highest average between the first and second half of an array
       * @param scores
       * @return
       */
      public int scoresAverage(int[] scores) {
        if(average(scores,0,scores.length/2)>average(scores,scores.length/2,scores.length)) return average(scores,0,scores.length/2);
        return average(scores,scores.length/2,scores.length);
      }
      /**
       * helps scoresAverage() by calculating the average of a range in an array
       * @param scores
       * @param start
       * @param end
       * @return
       */
      public int average(int[] scores, int start, int end){ //pairs with scoresAverage()
        int avg=0;
        for(int i=start;i<end;i++){
          avg+=scores[i];
        }
        return avg/(end-start);
      }
      /**
       * returns the number of elements with the given length in an array
       * @param words
       * @param len
       * @return
       */
      public int wordsCount(String[] words, int len) {
        int rtn=0;
        for(int i=0;i<words.length;i++){
          if(words[i].length()==len) rtn++;
        }
        return rtn;
      }
      /**
       * returns an array with only the first n elements of the given array
       * @param words
       * @param n
       * @return
       */
      public String[] wordsFront(String[] words, int n) {
        String[] rtn=new String[n];
        for(int i=0;i<n;i++){
          rtn[i]=words[i];
        }
        return rtn;
      }
       /**
        * returns whether an int conatains the value 1
        * @param n
        * @return
        */
      public boolean hasOne(int n) {
        while(n>0){
          if(n%10==1) return true;
          n/=10;
        }
        return false;
      }
      /**
       * returns a boolean representing whether a given int is divisible by each individual digit that it contains
       * @param n
       * @return
       */
      public boolean dividesSelf(int n) {
        double self=n;
        while(n>0){
          if(n%10==0||self%(n%10)!=0) return false;
          n/=10;
        }
        return true;
      }
      /**
       * returns an array with only the first count even numbers of the given array
       * @param nums
       * @param count
       * @return
       */
      public int[] copyEvens(int[] nums, int count) {
        int[] rtn=new int[count];
        for(int i=0, n=0;n<count;i++){
          if(nums[i]%2==0){
            rtn[n]=nums[i];
            n++;
          }
        }
        return rtn;
      }
      /**
       * returns an array containing only the first count values that are between 0-10 or 90-100 inclusive
       * @param nums
       * @param count
       * @return
       */
      public int[] copyEndy(int[] nums, int count) {
        int[] rtn=new int[count];
        for(int i=0,n=0;n<count;i++){
          if(nums[i]>-1&&nums[i]<11||nums[i]>89&&nums[i]<101){
            rtn[n]=nums[i];
            n++;
          }
        }
        return rtn;
      }
                                    

}