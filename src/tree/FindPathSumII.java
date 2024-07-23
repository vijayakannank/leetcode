package tree;


import java.util.ArrayList;
import java.util.List;
// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

public class FindPathSumII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        pathSum(root, 22);


    }

    static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPathReccursively(root, sum, currentPath, result);
        return result;
    }
    static private void findPathReccursively(TreeNode currentNode, int sum, List<Integer> currentPath, List<List<Integer>> result) {
        if (currentNode == null) {
            return;
        }

        currentPath.add(currentNode.val);

        if (currentNode.val == sum && currentNode.left == null && currentNode.right == null) {
            result.add(new ArrayList<>(currentPath));
        } else {
            findPathReccursively(currentNode.left, sum - currentNode.val, currentPath, result);
            findPathReccursively(currentNode.right, sum - currentNode.val, currentPath, result);
        }

        currentPath.remove(currentPath.size() - 1);
    }


}
