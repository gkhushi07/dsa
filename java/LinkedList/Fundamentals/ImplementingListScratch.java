public class ImplementingListScratch{
    static Node head = null;
    private int size;

    ImplementingListScratch(){
        this.size = 0;
    }

    static class Node{
        int val;
        Node next;

        Node(int v){
            this.val = v;
            this.next = null;
        }
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = newNode;
            return;
            }
        
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = newNode;
            return;
        } 

        Node currentNode = head;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
    }

    public void printListWithHead(Node head){
        Node currentNode = head.next;

        while(currentNode != null){
            System.out.print(currentNode.val + "->");
            currentNode = currentNode.next;
        }
        System.out.println("NULL");
    }

    public void printList(){
        if(head == null){
            System.out.println("Linked List is Empty");
            return;
        }
        Node currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode.val + "->");
            currentNode = currentNode.next;
        }
        System.out.println("NULL");
    }

    public void deleteFirst(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        size--;

        head = head.next;

        // before delete: 1->2->3->4 after delete: 2->3->4
    }

    public void deleteLast(){
        if(head == null){
            System.out.println("List is Empty");
            return;
        }

        size--;

        if(head.next == null){
            head = null;
            return;
        }

        Node currentNode = head.next;
        Node previousNode = head;
        while(currentNode.next !=null){
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        previousNode.next = null;
    }

    public static void delete(int n){
        if(head == null){
            System.out.println("List is Empty");
            return;
        }

        if(head.next==null && n==head.val){
            head = null;
            return;
        }

        if(n==head.val){
            head = head.next;
            return;
        }

        Node previousNode = head;
        Node current = head.next;

        // if(current.next == null){
        //     if(head.val == n){
        //         head = current;
        //         return;
        //     }
        //     else if(current.val == n){
        //         head.next = null;
        //         return;
        //     }
        //     else{
        //         System.out.println("Target not in the list");
        //         return;
        //     }                
        // }

        // Node nextNode = current.next;

        while(current != null){
            if(current.val != n){
                previousNode = current;
                current = current.next;
            }
            else{
                previousNode.next = current.next;
                return;
            }
        }

        System.out.println("Target is not in the list");
    }

    public int getSize(){
        return size;
    }
    public static void main(String args[]){
        ImplementingListScratch il = new ImplementingListScratch();
        il.addFirst(1);
        il.addFirst(2);
        il.addLast(3);
        il.addLast(4);
        il.printList();
        il.delete(4);
        // il.printList();
        // il.deleteLast();
        // il.printList();
        // il.deleteLast();
        // il.printList();
        // il.deleteLast();
        // System.out.println(il.getSize());
        il.printList();
    }
}