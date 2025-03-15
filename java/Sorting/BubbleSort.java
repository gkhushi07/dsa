import java.util.*;

public class BubbleSort{
    public static void bubbleSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
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

        bubbleSort(unsortedArray);
        
        for(int i=0; i<n; i++){
            System.out.print(unsortedArray[i]+ " ");
        }

    }
}