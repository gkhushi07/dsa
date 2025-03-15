import java.util.*;
public class MergeSort{
    private static void mergeSort(int[] arr, int s,int e){
        if(s==e){
            return;
        }
        int mid = (e + s)/2;

        mergeSort(arr, s, mid);
        mergeSort(arr, mid+1, e);
        merge(s, mid, e,arr);
    }

    private static void merge(int s, int mid, int e, int[] a){
        int[] res= new int[e-s+1];
        int i=s, j=mid+1, c=0;

        while(i<=mid && j<=e){
            if(a[i]<a[j]){
                res[c]=a[i];
                i++;
            }
            else{
                res[c] = a[j];
                j++;
            }
            c++;
        }
        while(i<=mid){
            res[c]=a[i];
            i++;
            c++;
        }
        while(j<=e){
            res[c]=a[j];
            j++;
            c++;
        }
        for(int k=0; k<res.length; k++){
            a[k+s] = res[k];
        }
    }
    public static void main(String args[]){{
        Scanner sc= new Scanner(System.in);

        System.out.println("Enter size of array");
        int n= sc.nextInt();

        System.out.println("Enter Array Elements");
        int[] unsortedArray = new int[n];
        for(int i=0; i<n; i++){
            unsortedArray[i] = sc.nextInt();
        }

        sc.close();

        mergeSort(unsortedArray,0,n-1);
        
        for(int i=0; i<n; i++){
            System.out.print(unsortedArray[i]+ " ");
        }
    }}
}