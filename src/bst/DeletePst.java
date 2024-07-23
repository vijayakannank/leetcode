package bst;

import tree.TreeNode;

public class DeletePst {

    public static void main(String[] args) {
        TreeNode node = TreeNode.buildTreee();
        deletePST(node, 4);
    }

    static TreeNode deletePST(TreeNode root, int val){
        if(root == null) return root;
        if(root.val < val)
            root.right = deletePST(root.right, val);
        else if(root.val > val)
            root.left = deletePST(root.left, val);
        else {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            root.val = findMin(root.right);
            root.right = deletePST(root.right, root.val);
        }
        return root;
    }

    static int findMin(TreeNode root){
        return root.left == null ?  root.val : findMin(root.left);
    }
}
