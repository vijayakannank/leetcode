package bst;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElement {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        node.left.right = new TreeNode(2);
        kthSmallest(node,1);
    }
    public static int kthSmallest(TreeNode root, int k) {

        List<Integer> list = new ArrayList<>();
        if( root == null) return 0;
        dfs(root, list);
        return list.get(k);

    }
    public static void dfs(TreeNode root, List<Integer> list){
        if(root == null) return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
