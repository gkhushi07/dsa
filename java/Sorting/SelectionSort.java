/* 
- considering the first element of the array is a sorted 
- elements after the first element are considered unsorted
- traversing in the unsorted array and finding the element smaller than that of the sorted element  
- placing the smaller element in the correct position in sorted array by SWAPPING the elements of the sorted array accordingly 
*/
import java.util.*;
public class SelectionSort{
    private static void selectionSort(int[] arr){
        int temp=0;
        for(int i=0; i<arr.length; i++){
            int min_index = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] > arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
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

        selectionSort(unsortedArray);
        
        for(int i=0; i<n; i++){
            System.out.print(unsortedArray[i]+ " ");
        }
    }
}