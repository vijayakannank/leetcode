package binarySearcg;

import tree.TreeNode;

public class ValidBst {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        isValidBST(root);

    }

    static boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }

    static boolean isValidBST(TreeNode root,long min,long max){
        if(root == null)
            return true;
        if(root.val >= min || root.val <= max)
            return false;
        return isValidBST(root.left,root.val,max) && isValidBST(root.right,min,root.val);
    }
}
