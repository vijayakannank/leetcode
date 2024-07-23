package bst;

import tree.TreeNode;

public class InsertInBST {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.buildTreee();
//        TreeNode result = insertIntoBST(treeNode, 3);
//        TreeNode.printInOrderPST(result);

        System.out.println(search(treeNode, 67));
    }

    static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val,null,null);

        if(root.val < val)
            root.right = insertIntoBST(root.right, val);
        else if (root.val > val)
            root.left = insertIntoBST(root.left, val);

        return root;
    }

    // Function to delete a node from a BST
    public static TreeNode deleteNode(TreeNode root, int key)
    {
        // base case: the key is not found in the tree
        if (root == null) {
            return null;
        }

        // if the given key is less than the root node, recur for the left subtree
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }

        // if the given key is more than the root node, recur for the right subtree
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        // key found
        else {
            // Case 1: node to be deleted has no children (it is a leaf node)
            if (root.left == null && root.right == null)
            {
                // update root to null
                return null;
            }

            // Case 2: node to be deleted has two children
            else if (root.left != null && root.right != null)
            {
                // find its inorder predecessor node
                TreeNode predecessor = findMaximumKey(root.left);

                // copy value of the predecessor to the current node
                root.val = predecessor.val;

                // recursively delete the predecessor. Note that the
                // predecessor will have at most one child (left child)
                root.left = deleteNode(root.left, predecessor.val);
            }

            // Case 3: node to be deleted has only one child
            else {
                // choose a child node
                root = (root.left != null) ? root.left: root.right;
            }
        }

        return root;
    }

    static TreeNode findMaximumKey(TreeNode root){
        while(root.right != null)
            root = root.right;
        return root;
    }

    static int search(TreeNode root, int key){
        if(root == null)
            return -1;
        if(root.val == key)
            return key;
        if(root.val < key)
            return search(root.right, key);
        return search(root.left, key);
    }
}
