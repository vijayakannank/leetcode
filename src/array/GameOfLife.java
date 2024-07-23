package array;

import tree.TreeNode;

public class GameOfLife {

    public static void main(String[] args) {
        TreeNode result = convertBinary(new int[]{-5,-3,0,1,2,}, 0, 4, new TreeNode());
        System.out.println("");

    }

    static TreeNode convertBinary(int[] arr, int l, int r, TreeNode node){
        if(l > r)
            return  null;
        int mid = l+(r-l)/2;
        node.val = arr[mid];
        node.left = convertBinary(arr, l, mid-1, node.left);
        node.right = convertBinary(arr, mid+1, r, node.right);
        return node;
    }

}
