import java.util.Arrays;

//Sample Start File
public class ArrayReview {

	//#1
	public static void fillRandom(int[] a) {
		for(int i=0;i<a.length;i++){
			a[i]=(int)(Math.random()*100);
		}
	}
	
	public static int findSmallest(int[] nums) {
		int smallest=nums[0];
		for(int i=1;i<nums.length;i++){
			smallest=Math.min(smallest,nums[i]);
		}
		return smallest;
	}
	public static void fillInOrder(int[] arr, int x){
		for(int i=0;i<arr.length;i++){
			arr[i]=i+x;
		}
	}
	public static String arrayToString(int[] arr){
		String rtn="[";
		for(int i=0;i<arr.length;i++){
			rtn+=arr[i]+", ";
		}
		return rtn.substring(0,rtn.lastIndexOf(","))+"]";
	}
	public static int sum(int[] arr){
		int rtn=0;
		for(int i=0;i<arr.length;i++){
			rtn+=arr[i];
		}
		return rtn;
	}
	public static int find(int[] arr, int target){
		for(int i=0;i<arr.length;i++){
			if(arr[i]==target) return i;
		}
		return -1;
	}
	public static int max(int[] arr){
		int max=arr[0];
		for(int i=1;i<arr.length;i++){
			max=Math.max(max,arr[i]);
		}
		return max;	
	}
	public static int countOdds(int[] arr){
		int rtn=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]%2==1) rtn++;
		}
		return rtn;
	}
	public static void shift(int[] arr){
		int last=arr[arr.length-1];
		for(int i=0;i<arr.length-1;i++){
			arr[arr.length-i-1]=arr[arr.length-i-2];
		}
		arr[0]=last;
	}
	public static void shift(int[] arr, int num){
		int hold;
		for(int n=0;n<num;n++){
			shift(arr);
		}
	}
	public static boolean isIncreasing(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			if(arr[i]!=Math.min(arr[i],arr[i+1])) return false;
		}
		return true;
	}
	public static void swap(int[] list, int x, int y){
		int hold=list[x];
		list[x]=list[y];
		list[y]=hold;
	}
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
	public static void main(String[] args) {
		int [] numbers = new int[] {3,9,2,7,1,3,9,12,20,2,4};
		/*
		shift(numbers,2);
		System.out.println(Arrays.toString(numbers));
		shift(numbers);
		System.out.println(Arrays.toString(numbers));
		System.out.println(arrayToString(numbers));
		
		System.out.println("My list is: " + Arrays.toString(numbers));
		System.out.println("Smallest is: " + findSmallest(numbers));
		//void method called on its own line
		fillRandom(numbers); */
	}
}
