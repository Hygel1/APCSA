import java.util.Arrays;


/**
 * HONOR PLEDGE: All work here is honestly obtained and is my own. Sean McLoughlin
 * Date of Completion:  9/xx/2022
 * Assignment:  Array Algorithms Project
 * 
 * Attribution: 
 * 
 * General Description:  
 * 
 * 
 * Advanced:  
 * 
 * Errata: 
 *
 */
public class ArrayReview {
	public static void testMethod(){
		//fillRandom() not testable
		//findSmallest() tests
		if(findSmallest(new int[] {1, 2, 3, 4, 5, 6})!=1) System.out.println("error: findSmallest test 1");
		if(findSmallest(new int[] {0,10,10,0,25, -1})!=-1) System.out.println("error: findSmallest test 2");
		if(findSmallest(new int[] {0})!=0) System.out.println("error: findSmallest test 3");
		if(findSmallest(new int[] {12, 12, 12, 12, 12, 12, 12, 12, 12})!=12) System.out.println("error: findSmallest test 4");
		if(findSmallest(new int[]{0,0,0})!=0) System.out.println("error: findSmallest test 5");
		System.out.println("findSmallest tested");
		//fillInOrder() tests
		
	}
	/**
	 * fills a given int array with random ints in each index
	 * @param a
	 */
	public static void fillRandom(int[] a) {
		for(int i=0;i<a.length;i++){
			a[i]=(int)(Math.random()*100);
		}
	}
	/**
	 * finds and returns the smallest int value in a given int array
	 * @param nums
	 * @return
	 */
	public static int findSmallest(int[] nums) {
		int smallest=nums[0];
		for(int i=1;i<nums.length;i++){
			smallest=Math.min(smallest,nums[i]);
		}
		return smallest;
	}
	/**
	 * fills each element of a given array with the corresponsding index added to the given value
	 * @param arr
	 * @param x
	 */
	public static void fillInOrder(int[] arr, int x){
		for(int i=0;i<arr.length;i++){
			arr[i]=i+x;
		}
	}
	/**
	 * returns a string containing each element of an array separated by commas and spaces and surrounded by brackets
	 * @param arr
	 * @return
	 */
	public static String arrayToString(int[] arr){
		String rtn="[";
		for(int i=0;i<arr.length;i++){
			rtn+=arr[i]+", ";
		}
		return rtn.substring(0,rtn.lastIndexOf(","))+"]";
	}
	/**
	 * finds and returns the sum of each element in a given int array
	 * @param arr
	 * @return
	 */
	public static int sum(int[] arr){
		int rtn=0;
		for(int i=0;i<arr.length;i++){
			rtn+=arr[i];
		}
		return rtn;
	}
	/**
	 * finds and returns the index of the first occurence of a given int in a given int array
	 * @param arr
	 * @param target
	 * @return
	 */
	public static int find(int[] arr, int target){
		for(int i=0;i<arr.length;i++){
			if(arr[i]==target) return i;
		}
		return -1;
	}
	/**
	 * finds and returns the largest value in a given int array 
	 * @param arr
	 * @return
	 */
	public static int max(int[] arr){
		int max=arr[0];
		for(int i=1;i<arr.length;i++){
			max=Math.max(max,arr[i]);
		}
		return max;	
	}
	/**
	 * counts and returns the number of odd digit in a given array
	 * @param arr
	 * @return
	 */
	public static int countOdds(int[] arr){
		int rtn=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]%2==1) rtn++;
		}
		return rtn;
	}
	/**
	 * shifts each element in a given array down one index value
	 * @param arr
	 */
	public static void shift(int[] arr){
		int last=arr[arr.length-1];
		for(int i=0;i<arr.length-1;i++){
			arr[arr.length-i-1]=arr[arr.length-i-2];
		}
		arr[0]=last;
	}
	/**
	 * shifts each element in a given array a given number of index values
	 * @param arr
	 * @param num
	 */
	public static void shift(int[] arr, int num){
		for(int n=0;n<num;n++){
			shift(arr);
		}
	}
	/**
	 * returns whether an int array contains values that are increasing in comparison to the element before
	 * @param arr
	 * @return
	 */
	public static boolean isIncreasing(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			if(arr[i]>=arr[i+1]) return false;
		}
		return true;
	}
	/**
	 * swaps two specified values in a given int array
	 * @param list
	 * @param x
	 * @param y
	 */
	public static void swap(int[] list, int x, int y){
		int hold=list[x];
		list[x]=list[y];
		list[y]=hold;
	}
	/**
	 * swaps two specified values in a given String array
	 * @param list
	 * @param x
	 * @param y
	 */
	public static void swap(String[] list, int x, int y){
		String hold=list[x];
		list[x]=list[y];
		list[y]=hold;
	}
	/**
	 * rearranges a given array to place all odd values on the left and even values on the right
	 * @param arr
	 */
	public static void split(int[] arr){
		int[] rtn=new int[arr.length];
		int hold1=0;
		int hold2=arr.length-1;
		for(int i=0;i<arr.length;i++){
			if(arr[i]%2==1){
				rtn[hold1]=arr[i];
				hold1++;
			}
			else{
				rtn[hold2]=arr[i];
				hold2--;
			}
		}
		arr=rtn;
	}
	public static void splitOther(int[] arr){
		//try clamping on t=either side until both sides need to be swapped
		int hold=arr.length-1;
		for(int i=0;i<hold;i++){
			if(arr[i]%2==0){
				for(int n=hold;n>i;n--){
					if(arr[n]%2==1){
						swap(arr, n, i);
						hold=n-1;
					}
				}
			}
		}
	}
	public static void splitAgain(int[] arr){
		int l=1,r=arr.length-1;
		while(l<r){
			if(arr[l]%2==1) l++;
			else if(arr[r]%2==0) r--;
			else swap(arr,r,l);
		}
	}
	
	/**
	 * reaggranges a given array in ascending order
	 * @param arr
	 */
	public static void sort(int[] arr){
		int[] rtn=new int[arr.length];
		for(int i=0;i<arr.length;i++){
			int maxIndex=0;
			for(int n=1;n<arr.length;n++){
				if(Math.max(arr[maxIndex], arr[n])==arr[n]) maxIndex=n;
			}
			rtn[rtn.length-i-1]=arr[maxIndex];
		}
	}
	public static void sortOther(int[] arr){
		for(int i=0, min;i<arr.length-1;i++){
			min=i;
			for(int n=i+1;n<arr.length;n++){
				if(Math.min(arr[n], arr[min])==arr[n]) min=n;
			}
			swap(arr, i, min);
		}
	}
	/**
	 * replaces any value larger than a given value with 0
	 * @param arr
	 * @param val
	 */
	public static void filter(int[] arr, int val){
		val=Math.abs(val);
		for(int i=0;i<arr.length;i++){
			if(Math.abs(arr[i])>val) arr[i]=0;
		}
	}
	/**
	 * returns the index at which a given array exists in another given array (returns -1 if it does not exist)
	 * @param arr
	 * @param compare
	 * @return
	 */
	public static int match(int[] arr, int[] compare){
		if(arr.length>=compare.length){
			for(int i=0;i<arr.length-compare.length;i++){
				if(arr.length>=compare.length&&arr[i]==compare[0]){
					for(int n=0;n<compare.length;n++){
						if(compare[n]!=arr[n+i]) break;
						else if(n==compare.length-1) return i;
					}
				}
			}
		}
		return -1;
	}
	/**
	 * returns the given array in alphabetical order
	 */
	public static String[] alphabetical(String[] arr){
		int earliestInd;
		for(int n=0;n<arr.length;n++){
			earliestInd=n;
			for(int i=n;i<arr.length;i++){
				if(arr[i].compareToIgnoreCase(arr[earliestInd])<0){
					earliestInd=i;
				} 
			}
			swap(arr, n, earliestInd);
		}
		return arr;
	}
	public static void main(String[] args) {
		/**
		 * Still to do:
		 * Fill in test method
		 */
		int [] numbers = new int[] {3,9,2,7,1,3,9,12,20,2,4};
		int [] numbers2 = new int[] {3,9,2,7,1,3,9,12,20,2,4};
		String[] sentences = new String[] {"a", "c", "d", "e", "t", "e", "q"};
		/*
		System.out.println(Arrays.toString(alphabetical(new String[] {"swap", "swa", "swb", "sqak"})));
		System.out.println(match(numbers, new int[] {2, 7, 1, 3}));
		shift(numbers,2);
		System.out.println(Arrays.toString(numbers));
		shift(numbers);
		System.out.println(Arrays.toString(numbers));
		System.out.println(arrayToString(numbers));
		
		System.out.println("My list is: " + Arrays.toString(numbers));
		System.out.println("Smallest is: " + findSmallest(numbers));
		//void method called on its own line
		fillRandom(numbers); 
		*/
	}
}
