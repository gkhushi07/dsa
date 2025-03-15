public class DiameterOfTree{
    static class Track{
        int height, diameter;

        Track(int h, int d){
            this.height = h;
            this.diameter = d;
        }
    }

    static class TreeNode{
        int val; 
        TreeNode left, right;

        TreeNode(int v){
            this.val=v;
            this.left = null;
            this.right = null;
        }

    }

    static class BinaryTree{
        static int idx = -1;
        public static TreeNode createBinaryTree(int[] nodes){
            idx++;
            if(nodes[idx]==-1)
                return null;
            
            TreeNode current = new TreeNode(nodes[idx]);
            current.left = createBinaryTree(nodes);
            current.right = createBinaryTree(nodes);

            return current;

        }
    }

    public static int calculateHeight(TreeNode root){
        if(root == null)
            return 0;
        
        int left = calculateHeight(root.left);
        int right = calculateHeight(root.right);

        return Math.max(left, right) + 1;
    }

    // Complexity of the method = O(n^2)
    public static int calculateDiameter(TreeNode root){
        if(root == null)
            return 0;
        
        int leftDiam = calculateDiameter(root.left);
        int rightDiam = calculateDiameter(root.right);
        int diameter = calculateHeight(root.left) +  calculateHeight(root.right) +1;
        return diameter;
    }

    // complexity of the method = O(n)
    public static Track calculateDiameter2(TreeNode root){
        if(root == null)
            return new Track(0,0);
        
        Track left = calculateDiameter2(root.left);
        Track right = calculateDiameter2(root.right);
        int diameter = left.height + right.height + 1;

        return new Track((Math.max(left.height, right.height) +1), diameter);

    }

    public static void main(String args[]){
        int[] nodes = {1,2,3, -1, -1, 4, -1,-1, 5 , -1,6, 7,-1,-1, -1};
        BinaryTree bt = new BinaryTree();

        TreeNode root = bt.createBinaryTree(nodes);

        System.out.println("Diameter with n^2 complexity" + calculateDiameter(root));
        System.out.println("Diameter with n complexity: " + calculateDiameter2(root).diameter + " and height: "+ calculateDiameter2(root).height);
    }
}