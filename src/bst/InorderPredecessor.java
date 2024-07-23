package bst;

import tree.TreeNode;

public class InorderPredecessor {

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTreee();
         TreeNode node = new InorderPredecessor().find(root, new TreeNode(40));
        System.out.println(node.val);
    }

    TreeNode find(TreeNode root, TreeNode node){
        if(root == null) return null;
        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null){
            if(cur.val > node.val){
                pre = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return pre;
    }
}
