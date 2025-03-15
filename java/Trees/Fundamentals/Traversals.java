import java.util.*;
public class Traversals{
    static class Node{
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right=null;
        }
    }

    static class BuildBinaryTree{
        static int idx = -1;

        public static Node buildTree(int nodes[]){
            idx++;

            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);

            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void preorderTraversal(Node root){
        if(root == null){
            System.out.print("-1 ");
            return;
        }

        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void inorder(Node root){
        if(root == null){
            System.out.print("-1 ");
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void postorder(Node root){
        if(root == null){
            System.out.print("-1 ");
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");

    }

    public static void levelorder(Node root, Queue<Node> q){
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node current = q.remove();

            if(current == null){
                System.out.println();
                if(q.isEmpty())
                    break;
                else   
                    q.add(null);
            }
            else{
                System.out.print(current.data + " ");

                if(current.left != null)
                    q.add(current.left);
                if(current.right != null)
                    q.add(current.right);

            }
        }
    }

    public static void main(String args[]){
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Queue<Node> q = new LinkedList<>();

        BuildBinaryTree bt= new BuildBinaryTree();
        Node root = bt.buildTree(nodes);
        System.out.println("#PRE-ORDER TRAVERSAL:- ");
        preorderTraversal(root);
        System.out.println("\n#IN-ORDER TRAVERSAL:- ");
        inorder(root);
        System.out.println("\n#POST-ORDER TRAVERSAL:- ");
        postorder(root);
        System.out.println("\n#LEVEL-ORDER TRAVERSAL:- ");
        levelorder(root, q);
    }
}