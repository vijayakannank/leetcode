package narray;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {
    public static void main(String[] args) {
        Node node = Node.buildNArrTree();
        System.out.println(new PreOrderTraversal().preorder(node));
    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        dfs(root, result);
        return result;
    }
    void dfs(Node root, List<Integer> result){
        result.add(root.val);
        if(root.children == null)
            return;
        for(Node node: root.children){
            dfs(node, result);
        }
    }
}
