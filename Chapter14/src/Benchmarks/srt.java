import java.util.Arrays;
public class srt {
    
    public static void main(String[] args){
        int[] nums={3,4,5,1,3,4,5,6,12,32,43,5445,2,123,3213,54,21,65,32,54,32,56,67,89,0,54,12,52,53};
        quick(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    public static void swap(int[] a,int i,int j){
        int h=a[i];
        a[i]=a[j];
        a[j]=h;
    }
    public void callMerge(int[] a,int s, int e){
        int[] temp=new int[a.length];
        merge(temp,a,s,e);
    }
    public void merge(int[] temp, int[] a, int s, int e){
        if(e-s<2){
            int h=a[e];
            e=Math.max(a[e],a[s]);
            s=Math.min(h,a[s]);
        }
        else{
            merge(temp,a,s,s+(e-s)/2);
            merge(temp,a,s+(e-s)/2,e);
            int i=s+(e-s)/2, j=s;
            while(i<=e&&j<=s+(e-s)/2){
                if(a[i]<a[j]){
                    
                }
            }
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
