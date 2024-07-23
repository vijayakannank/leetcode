package common;

import java.util.Stack;

public class BurningNodes {

    Stack<Integer>  stack = new Stack<>();

    void burningNode(Tree treeNode, boolean isFoundTargetNode, int targetNode) {
        if(treeNode == null) return;
        if(!isFoundTargetNode){
            stack.push(treeNode.val);
        }
        if(!isFoundTargetNode && treeNode.val == targetNode){
            isFoundTargetNode = true;
        }

        if(isFoundTargetNode)
            System.out.println(treeNode.val);
        burningNode(treeNode.left, isFoundTargetNode, targetNode);
        burningNode(treeNode.right, isFoundTargetNode, targetNode);
        if(isFoundTargetNode && stack.isEmpty() )
            System.out.println(stack.pop());
    }
}

class Tree {
    int val;
    Tree left;
    Tree right;
}
