import java.util.*;
public class InsertionSort{

    private static void insertionSort(int[] arr){
        for(int i=1; i<arr.length; i++){
            int temp = arr[i];
            int j=i-1;
            while(j>-1 && temp<arr[j]){
                arr[j+1] =arr[j];
                j--;
            }

            arr[j+1] = temp;
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

        insertionSort(unsortedArray);
        
        for(int i=0; i<n; i++){
            System.out.print(unsortedArray[i]+ " ");
        }

    }
}