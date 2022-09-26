import java.util.Arrays;


/**
 * HONOR PLEDGE: All work here is honestly obtained and is my own. Sean McLoughlin
 * Date of Completion:  9/25/2022
 * Assignment:  Array Algorithms Project
 * 
 * Attribution: 
 * 
 * General Description:  
 * 
 * Advanced:  multiple versions of sort and split, alphabetical method (none of these are formally tested but have previouslly worked)
 * 
 * Errata: 
 *
 */
public class ArrayReview {
	public static void testMethod(){
		//fillRandom tests
		int[] fillRand=new int[7]; fillRandom(fillRand);
		System.out.println("fillRandom() 1: "+Arrays.toString(fillRand));
		fillRandom(fillRand);
		System.out.println("fillRandom() 2: "+Arrays.toString(fillRand)+"\n");

		//findSmallest tests
		int[] fs1={1, 2, 3, 4, 5, 6, 7, 8 ,9};
		System.out.println("findSmallest() 1: "+Arrays.toString(fs1)+" returns "+findSmallest(fs1));
		int[] fs2={0, 10, 10, 5, 25, -1};
		System.out.println("findSmallest() 2: "+Arrays.toString(fs2)+" returns "+findSmallest(fs2)+"\n");

		//fillInOrder() tests
		int[] fio1=new int[7]; fillInOrder(fio1, 2);
		System.out.println("fillInOrder() 1: new int[7], 2 "+Arrays.toString(fio1));
		int[] fio2=new int[3]; fillInOrder(fio2, 10);
		System.out.println("fillInOrder() 2: new int[3], 10 "+Arrays.toString(fio2)+"\n");

		//arrayToString() tests
		System.out.println("arrayToString() 1: "+Arrays.toString(fio2)+" returns "+arrayToString(fio2));
		System.out.println("arrayToStirng() 2: "+Arrays.toString(fio1)+" returns "+arrayToString(fio1)+"\n");

		//sum() tests
		System.out.println("sum() 1: "+Arrays.toString(fio1)+" returns "+sum(fio1));
		System.out.println("sum() 2: "+Arrays.toString(fio2)+" returns "+sum(fio2)+"\n");

		//find() tests
		int[] find1={23, 4, 5, 6, 12, 4};
		System.out.println("find() 1: "+Arrays.toString(find1)+", 5 returns "+find(find1, 5));
		System.out.println("find() 2: "+Arrays.toString(find1)+", 4 returns "+find(find1, 4)+"\n");

		//max() tests
		System.out.println("max() 1: "+Arrays.toString(find1)+" returns "+max(find1));
		System.out.println("max() 2: "+Arrays.toString(fio1)+" returns "+max(fio1)+"\n");

		//coundOdds() tests
		System.out.println("countOdds() 1: "+Arrays.toString(fio1)+" returns "+countOdds(fio1));
		System.out.println("countOdds() 2: "+Arrays.toString(find1)+" returns "+countOdds(find1)+"\n");

		//shift() tests
		System.out.print("shift() 1: "+Arrays.toString(find1)+" returns "); shift(find1); System.out.println(Arrays.toString(find1));
		System.out.print("shift() 2: "+Arrays.toString(fio1)+" returns "); shift(fio1); System.out.println(Arrays.toString(fio1)+"\n");

		//Overloaded shift() tests
		System.out.print("shift() overload 1: "+Arrays.toString(find1)+", 2 returns "); shift(find1, 2); System.out.println(Arrays.toString(find1));
		System.out.print("shift() overload 2: "+Arrays.toString(fio1)+", 5 returns "); shift(fio1, 5); System.out.println(Arrays.toString(fio1)+"\n");

		//isIncreasing() tests
		int[] ii1={1, 2, 3, 4, 5, 6, 7};
		int[] ii2={1, 2, 3, 5, 4, 6, 7};
		System.out.println("isIncreasing() 1: "+Arrays.toString(ii1)+" returns "+isIncreasing(ii1));
		System.out.println("isIncreasing() 2: "+Arrays.toString(ii2)+" returns "+isIncreasing(ii2)+"\n");

		//swap() tests
		System.out.print("swap() 1: "+Arrays.toString(ii1)+", 0, 2 returns "); swap(ii1,0,2); System.out.println(Arrays.toString(ii1));
		System.out.print("swap() 2: "+Arrays.toString(ii2)+", 3, 4 returns "); swap(ii2,3,4); System.out.println(Arrays.toString(ii2)+"\n");

		//split() tests
		System.out.print("split() 1: "+Arrays.toString(ii1)+" returns "); splitAgain(ii1); System.out.println(Arrays.toString(ii1));
		System.out.print("split() 2: "+Arrays.toString(find1)+" returns "); splitAgain(find1); System.out.println(Arrays.toString(find1)+"\n");

		//sort() tests
		System.out.print("sort() 1: "+Arrays.toString(find1)+" returns "); sortOther(find1); System.out.println(Arrays.toString(find1));
		System.out.print("sort() 2: "+Arrays.toString(ii1)+" returns "); sortOther(ii1); System.out.println(Arrays.toString(ii1)+"\n");

		//filter() tests
		fillRandom(ii1);
		fillRandom(ii2);
		System.out.print("filter() 1: "+Arrays.toString(ii1)+", 3 returns "); filter(ii1,3); System.out.println(Arrays.toString(ii1));
		System.out.print("filter() 2: "+Arrays.toString(ii2)+", 5 returns "); filter(ii2, 5); System.out.println(Arrays.toString(ii2)+"\n");

		//match() tests
		int[] match11={1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] match12={3,4};
		System.out.println("match() 1: "+Arrays.toString(match11)+", "+Arrays.toString(match12)+" returns "+match(match11, match12));
		int[] match21={9,0,1,2,3};
		int[] match22={3};
		System.out.println("match() 2: "+Arrays.toString(match21)+", "+Arrays.toString(match22)+" returns "+match(match21, match22)+"\n");

		//remove() test
		System.out.println("remove() 1: "+Arrays.toString(match21)+", 1 returns "+Arrays.toString(remove(match21, 1)));
		System.out.println("remove() 2: "+Arrays.toString(ii1)+", 3 returns "+Arrays.toString(remove(ii1,3)));
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
	 * @return 
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
			for(int i=0;i<arr.length-compare.length+1;i++){
				if(arr[i]==compare[0]){
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
	/**
	 * removes a given value from an array and returns a trimmed version of the array
	 * @param arr
	 * @param num
	 * @return
	 */
	public static int[] remove(int[] arr, int num){
		int len=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]==num) len++;
		}
		int[] rtn=new int[arr.length-len];
		for(int i=0, n=0;i<arr.length;i++){
			if(arr[i]!=num){
				rtn[n]=arr[i];
				n++;
			}
		}
		return rtn;
	}
	public static void main(String[] args) {
		testMethod();
	}
}
