package tree;

public class TreeNode {

    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(){}

    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTreee(){
        TreeNode root = new TreeNode(3);

        // left side
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
//        root.left.right.left = new TreeNode(50);
//        root.left.right.right = new TreeNode(70);
//        root.left.left = new TreeNode(20);
//        root.left.left.left = new TreeNode(10);
//        root.left.left.right = new TreeNode(30);


        // right side
        root.right = new TreeNode(4);
//        root.right.left = new TreeNode(100);
//        root.right.left.right = new TreeNode(110);
//        root.right.left.left = new TreeNode(90);
//        root.right.right.right = new TreeNode(71);
        return root;
    }

    public static void printInOrderPST(TreeNode root){
        if(root == null)
            return;
        printInOrderPST(root.left);
        System.out.println(root.val);
        printInOrderPST(root.right);
    }
}
