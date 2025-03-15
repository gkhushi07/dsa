import java.util.*;

public class ImplementingListCollectionFramework{


    public static void main(String args[]){
        LinkedList<Integer> l = new LinkedList<>();

        l.add(1);
        l.add(2); // default adds at the end
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        System.out.println("Original list: "+l);
        System.out.println("Size of the list: "+ l.size()); // to get the size of the list

        l.addFirst(7); // to add from the begenning
        System.out.println("After adding element(7) in the beginning of the list: "+ l);

        
        l.removeLast();// delete from the last 
        System.out.println("After removing the last element: "+l); 
        int n = l.remove(); // default deletes from the head
        System.out.println("After removing the first element: " +l + "\nValue of removed element: " + n);// to remove from the first
        l.remove(2);
        System.out.println("Removing element from specific index(2): "+ l);

        // Iterating in the list
        for(int i=0; i<l.size(); i++)
        {
            System.out.print(l.get(i)*5 + " ");
        }
    }
}