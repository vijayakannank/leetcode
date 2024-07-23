package bst;

import tree.TreeNode;

public class InorderSuccessor {

    TreeNode find(TreeNode root, TreeNode node){
        if(root == null) return null;
        TreeNode cur = node;
        TreeNode pre = null;

        while(cur != null){
            if(cur.val > node.val) {
                pre = cur;
                cur = cur.left;
            } else
                cur = cur.right;
        }
        return pre;
    }
}
