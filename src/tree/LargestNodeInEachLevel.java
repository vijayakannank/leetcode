package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestNodeInEachLevel {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(3);
        node.right = new TreeNode(2);
        node.right.right = new TreeNode(9);
        largestValues(node);
    }

    static List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        if(!queue.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = queue.size();

            for(int i=0; i<size; i++){
                TreeNode current = queue.remove();
                if(max < current.val){
                    max = current.val;
                }
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }

            }
            result.add(max);

        }
        return result;
    }
}
