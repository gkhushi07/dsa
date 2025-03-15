import java.util.*;

public class CountOfNodes{
    static class TreeNode{
        int val;
        TreeNode left, right;

        public TreeNode(int val){
            this.val = val;
            this.left =null;
            this.right =null;
        } 
    }

    public static class BinaryTree{
        static int idx = -1;

        public static TreeNode createBinaryTree(int[] nodes){
            idx++;
            if(nodes[idx]== -1)
                return null;

            TreeNode root = new TreeNode(nodes[idx]);
            root.left = createBinaryTree(nodes);
            root.right = createBinaryTree(nodes);

            return root;
        }
    }


    public static int countNodes(TreeNode root){
        if(root==null)
            return 0;
        
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return leftCount+rightCount+1;
    }

    public static int sumOfNodes(TreeNode root){
        if(root== null)
            return 0;
        
        int leftSum= sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum+rightSum+root.val;
    }
    public static void main(String args[]){
        int[] nodes = {1,2,-1, -1, 3, 4, -1, 5, -1, -1, 6, 7, -1, -1, -1};

        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.createBinaryTree(nodes);

        System.out.println("Number of Nodes in Tree: " + countNodes(root));
        System.out.println("Sum of All the Node in Tree: " + sumOfNodes(root));
    }
}