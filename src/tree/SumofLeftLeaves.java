package tree;

public class SumofLeftLeaves {

    static int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left != null && root.left.left == null){
            return root.left.val+sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);

    }
}
