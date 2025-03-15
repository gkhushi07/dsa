public class IteratingInList{
    static Node head = null;
    private static int size;
    static class Node{
        int data;
        Node next;

        Node(int d){
            this.data =d;
            this.next=null;
        }
    }

    public void addListElements(int nodeData){
        Node newNode = new Node(nodeData);
        size++;

        if(head == null){
            head = newNode;
            return;
        }

        Node current = head;
        while(current.next != null){
            current = current.next;
        }

        current.next = newNode;
    }

    public void findElementAtIndex(int index){
        if(index>size || index <0){
            System.out.println("Index Out of Bound");
            return;
        }

        Node currentNode = head;
        for(int i=0; i<size; i++){
            if(i+1 == index){
                System.out.println("List element at index " + index + " = "+ currentNode.data);
                return;
            }
            currentNode = currentNode.next;
        }
    }
    
    //O(index)
    public static void addElementAtIndex(int index, Node newNode){
        if(index>size || index<0){
            System.out.println("List Empty");
            return;
        }
        size++;

        if(index == 0){   
            newNode.next = head;
            head = newNode;
            return;         
        }

        Node previous = head;
        Node current = head.next;
        for(int i=1; i<size; i++){
            if(i == index){
                newNode.next = current;
                previous.next = newNode;
                return;
            }
            previous=current;
            current = current.next; 
        }
    }


    public static void printList(){
        if(head == null){
            System.out.println("List is Empty");
        }

        Node current = head;
        while(current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.print("NULL");
    }

    public static void searchElementInList(int element){
        if(head == null){
            System.out.println("List is Empty");
            return;
        }
        int i=0;
        Node current = head;
        while(current != null){
            if(current.data == element){
                System.out.println("Element exists at index: " +i);
                return;
            }
            i++;
            current = current.next;
        }
        System.out.println("Element doesn't exists in the list");
        return;
    }

    public static void main(String args[]){
        IteratingInList il = new IteratingInList();

        il.addListElements(11);
        il.addListElements(21);
        il.addListElements(31);
        il.addListElements(41);
        il.addListElements(51);
        il.printList();

        System.out.println("\nSize of the list is: " + size);
        il.findElementAtIndex(4);

        Node newNode = new Node(71);
        il.addElementAtIndex(4,newNode);
        il.printList();
        System.out.println("\nSize of the list is: " + size);
        il.searchElementInList(71);

        for(int i=1; i<=50; i++){
            il.addListElements(i);
        }
    }
}