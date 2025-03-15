import java.util.*;

public class QuickSort{
    private static void quickSort(int[] a, int si, int ei){
        if(si==ei){
            return;
        }
        int pi = partition(a, si, ei);
        quickSort(a, si, pi-1);
        quickSort(a, pi+1, ei);
    }

    private static int partition(int[] a, int si, ei){
        int pivot=a[ei], i=-1;

        for(int j=si; j<ei; j++){
            if(a[j]< pivot){
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        i++;
        temp = a[i];
        a[i] = pivot;
        a[ei] = temp;
        return i;
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);

        System.out.println("Enter size of array");
        int n= sc.nextInt();

        System.out.println("Enter Array Elements");
        int[] unsortedArray = new int[n];
        for(int i=0; i<n; i++){
            unsortedArray[i] = sc.nextInt();
        }

        sc.close();

        quickSort(unsortedArray, 0, n-1);
        
        for(int i=0; i<n; i++){
            System.out.print(unsortedArray[i]+ " ");
        }
    }
}