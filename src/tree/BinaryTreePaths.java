package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        List<String> result = binaryTreePaths(root);
        System.out.println(result);

    }

    static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, "", result);
        return result;
    }

    static void dfs(TreeNode root, String path, List<String> result){
        path += root.val;
        if(root.left == null && root.right == null){
            result.add(path);
            return;
        }
        if(root.left != null)
            dfs(root.left, path+"->", result);
        if(root.right != null)
            dfs(root.right, path+"->", result);
    }
}
