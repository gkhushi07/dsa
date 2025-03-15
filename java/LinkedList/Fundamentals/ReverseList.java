public class ReverseList extends ImplementingListScratch{

    public void reverseList(){
        if(head == null){
            System.out.println("List is Empty");
            return;
        }

        if(head.next == null){
            System.out.println("List only has one element, cant be reversed.");
        }

        Node previous = head;
        Node current = head.next;

        while(current != null){
            Node pointer=current.next;
            current.next = previous;

            previous = current;
            current = pointer;
        }

        head.next=null;
        head = previous;
    }

    public static Node recursiveReverseList(Node current) {
        // Base case: if current is null or we've reached the last node
        if (current == null || current.next == null) {
            return current;  // Return the last node (this becomes the new head)
        }

        // Recursively reverse the rest of the list
        Node newHead = recursiveReverseList(current.next);  // Recur until we reach the last node

        // After recursion, adjust pointers to reverse the list
        current.next.next = current;  // Make the next node's next point to the current node
        current.next = null;  // Set the current node's next to null (this will be the new tail)

        return newHead;  // Return the new head of the reversed list
    }

    public void printList(){
        Node current = head;
        while(current != null){
            System.out.print(current.val + "->");
            current = current.next;
        }

    }
    public static void main(String args[]){
        ImplementingListScratch il = new ImplementingListScratch();
        ReverseList rl = new ReverseList();

        for(int i=1; i<=10; i++){
            il.addLast(i);
        }
        il.printList();

        rl.reverseList();
        il.printList();
        rl.recursiveReverseList(il.head);
        rl.printList();
    }
}


Post.includes(:comments)
Post.preload(:comments).where