package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.left.left = new TreeNode(9);
        treeNode.left.left.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println(rightSideView(treeNode));


    }

    static  List<Integer> rightSideView(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root==null)
            return result;

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {

                TreeNode curr=q.remove();

                if(i==size-1)
                {
                    result.add(curr.val);
                }

                if(curr.left!=null)
                    q.add(curr.left);


                if(curr.right!=null)
                    q.add(curr.right);
            }
        }

        return result;
    }
}


