package tree;

import java.util.Stack;

public class BinaryTreeToLinkedList {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right = new TreeNode(5);
        treeNode.right.right = new TreeNode(6);
        plattern(treeNode);
        System.out.println("success");
    }

    static void plattern(TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);

        while (!stack.isEmpty()){
            TreeNode tempTreeNode = stack.pop();
            if(tempTreeNode.right != null) {
                stack.push(tempTreeNode.right);
            }
            if(tempTreeNode.left != null) {
                stack.push(tempTreeNode.left);
            }
            if(!stack.isEmpty()){
                tempTreeNode.right = stack.peek();
            }
            tempTreeNode.left = null;
        }
    }
}
