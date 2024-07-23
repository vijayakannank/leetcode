package narray;

import java.util.Arrays;
import java.util.List;

public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    static Node buildNArrTree(){
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n2 = new Node(2);
        Node n4 = new Node(4);
        Node n3 = new Node(3, Arrays.asList(n5, n6));
        return new Node(1, Arrays.asList(n3, n2, n4));
    }
}
