package Chapter19;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
public class RadixSort {
/**
 * Sean McLoughlin
 * HONOR PLEDGE: All work here is honestly obtained and is my own. Sean McLoughlin
 * Date of Completion:  3/29/23
 * Assignment: Radix Sort Lab
 * 
 * Attribution: Cole Saunders was my partner
 * 
 * General Description: Sorts array of numbers using Radix sort
 * 
 * Advanced: Creates random files with random amounts of random numbers and sorts them when run
 * 				Can take premade data file using other getArry() method (included) but this version is set to make random files
 */
	public static void main(String[] args) {
		//Sample Test 1
		int[] list=getArray(makeData());
		System.out.println(Arrays.toString(sort(list,4)));
		//Create more test cases to verify functionality  part d.
	}
	/** Pre: number >=0; k>=0
	 *  Post: returns kth digit of number, where k=0 is the 
	*  least significant digit, i.e. the ones' place, and k
	*  represents the power of 10 desired.
	*/
	private static int getDigit(int number, int powerOf10) {
		return (number/(int)Math.pow(10,powerOf10))%10; 
	}
	
	/** Pre:  nums.length > 0;  all values in nums are 
	 * non-negative; k>=0, where k represents the position
	 * of the digit used to determine queue placement
	 * Post: returns an array of 10 queues as described in
	 * the example; the total number of values in the array of 
	 * queues is equal to nums.length
	 *
	 */
	private static Queue[] itemsToQueues(int[] nums, int k) {
		Queue[] rtn=new Queue[10];
		for(int i=0;i<10;i++) rtn[i]=new LinkedList<Integer>();
		for(int i=0;i<nums.length;i++) rtn[getDigit(nums[i], k)].add(nums[i]);
		return rtn;
	}
	/** Pre: queues.length is 10; numvals is the number of values
	 * in all 10 queues.
	 * Post: Returns an array that contains the integers from 
	 * queues[0] through queues[9] in the order in which they were
	 * stored into the queues;  each queue in queues will be emptied
	 */
	private static int[] queuesToArray(Queue[] queues, int numVals){
		int[] rtn=new int[numVals];
		int spot=0;
		for(int i=0;i<queues.length;i++){
			while(queues[i].size()>0){
				rtn[spot]=(int)queues[i].remove();
				spot++;
			}
		}
		return rtn;		
	}
	
	/** Pre: nums.length >0; all values in nums are nonnegative;
	 * the largest value in nums has numDigits digits
	 * Post: returns an array of all the values found in nums,
	 * sorted in nondecreasing order
	 */
	public static int[] sort(int[] nums, int numDigits) {
		for(int i=0;i<numDigits;i++)
		nums=queuesToArray(itemsToQueues(nums, i), nums.length);
		return nums;
	}
	public static int[] getArray(String path){
		ArrayList<Integer> rtn=new ArrayList<>();
		File f=new File(path);
		try{
			Scanner intake=new Scanner(f);
			while(intake.hasNextLine()){
				rtn.add(intake.nextInt());
			}
			intake.close();
		}catch(Exception e){}
		return toNorm(rtn.toArray());
	}
	public static int[] getArray(){
		ArrayList<Integer> rtn=new ArrayList<>();
		Scanner pathIntake=new Scanner(System.in);
		System.out.print("Path: ");
		String path=pathIntake.nextLine();
		pathIntake.close();
		File f=new File(path);
		try{
			Scanner intake=new Scanner(f);
			while(intake.hasNextLine()){
				rtn.add(intake.nextInt());
			}
			intake.close();
		}catch(Exception e){}
		return toNorm((Integer[])rtn.toArray());
	}
	public static int[] toNorm(Object[] a){
		int[] rtn=new int[a.length];
		for(int i=0;i<a.length;i++){
			rtn[i]=(Integer)a[i];
		}
		return rtn;
	}
	public static String makeData(){
		String fN="";
		try{
		for(int i=0;i<Math.random()*10;i++) fN+=String.valueOf((int)(Math.random()*10));
		File f=new File(fN);
		FileWriter fw=new FileWriter(f);
		for(int i=0;i<Math.random()*100;i++)  fw.write((int)(Math.random()*1000)+"\n");
		fw.close();
		}catch(Exception e){};
		return fN;
	}
}
