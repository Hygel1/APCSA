import java.util.Arrays;
public class srt {
    static double[] temp;
    public static void main(String[] args){
        double[] nums={3,4,5,1,3,4,5,6,12,32,43,5445,2,123,3213,54,21,65,32,54,32,56,67,89,0,54,12,52,53};
        double[] nums1={3,4,5,1,3,4,5,6,12,32,43,5445,2,123,3213,54,21,65,32,54,32,56,67,89,0,54,12,52,53};
        //quick(nums,0,nums.length-1);
        Mergesort.sort(nums1);
        System.out.println(Arrays.toString(nums1)+"\n");
        callMerge(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void swap(int[] a,int i,int j){
        int h=a[i];
        a[i]=a[j];
        a[j]=h;
    }
    public static void callMerge(double[] a){
        temp=new double[a.length];
        mergeSort(a,0,a.length-1);
    }
    public static void mergeSort(double[] a, int s, int e){
        if(e-s<2){
            if(e>s&&a[s]>a[e]){
                double h=a[s];
                a[s]=a[e];
                a[e]=h;
            }
        }
        else{
            int middle=(e+s)/2;
            mergeSort(a,s,middle);
            mergeSort(a,middle+1,e);
            merge(a,s,middle,e);
            }
        }
    public static void merge(double[] a, int from,int middle, int to){
        int s=from,e=middle+1,k=from;
        while(s<=middle&&e<=to){
            if(a[s]<a[e]){
                temp[k]=a[s];
                s++;
            }
            else{
                temp[k]=a[e];
                e++;
            }
            k++;
        }
        while(s<middle){
            temp[k]=a[s];
            k++;s++;
        }
        while(e<=to){
            temp[k]=a[e];
            k++;e++;
        }
        for(int i=from;i<=to;i++){
            a[i]=temp[i];
        }
    }
    public static void quick(int[] a ,int s, int e){
        int i=s+1, j=e, p=s;
        if(e-s<1) return;
        while(i<=j){
            if(a[i]<=a[p]) i++;
            else if(a[j]>=a[p]) j--;
            else{
                swap(a,i,j);
                i++;j--;
            }
        }
            swap(a,j,p);
            p=j;

        quick(a,s,p-1);
        quick(a,p+1,e);
    }

}
