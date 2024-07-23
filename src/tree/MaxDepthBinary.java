package tree;

public class MaxDepthBinary {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.left.left = new TreeNode(9);
        treeNode.left.left.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        System.out.println(maxDepth(treeNode));
    }

    static int maxDepth(TreeNode treeNode) {
        if(treeNode == null)
            return 0;

        int left = maxDepth(treeNode.left);
        int right = maxDepth(treeNode.right);

        return Math.max(left, right)+1;

    }
}
