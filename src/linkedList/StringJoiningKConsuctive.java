package linkedList;

import java.util.ArrayList;
import java.util.List;

public class StringJoiningKConsuctive {

    public static void main(String[] args) {
        CharNode head = new CharNode('a');
        head.next = new CharNode('b');
        head.next.next = new CharNode('c');
        head.next.next.next = new CharNode('d');
        head.next.next.next.next = new CharNode('e');
        head.next.next.next.next.next = new CharNode('f');

        List<String> result = stringJoiningKConsuctive(head, 2);
        System.out.println(result);
    }

    static List<String> stringJoiningKConsuctive(CharNode node, int k) {
        List<String> result = new ArrayList<>();
        String word = "";
        int count = 0;

        while (node != null) {
            if(count == k){
                result.add(word);
                count = 0;
                word = "";
            }
            word += node.val;
            count++;
            node = node.next;
        }
        result.add(word);

        return result;
    }
}

class CharNode {
    char val;
    CharNode next;

    public CharNode(char val) {
        this.val = val;
    }
}
