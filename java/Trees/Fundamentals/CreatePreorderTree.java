public class CreatePreorderTree{
    static class Node{
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
            this.left=null;
            this.right=right;
        } 
    }

    static class BuildBinaryTree{
        static int idx = -1;
        public static Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx] == -1)
                return null;

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }
    public static void main(String args[]){

        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BuildBinaryTree bt = new BuildBinaryTree();
        Node root = bt.buildTree(nodes);
        System.out.print("Root: " + root.data);

    }
}