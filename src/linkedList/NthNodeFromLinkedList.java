package linkedList;

public class NthNodeFromLinkedList {

    public static void main(String[] args) {
        System.out.println(getNthNode(Node.buildLinkedList(),4));
    }

    static int getNthNode(Node node, int nth){
        int length = 0;
        Node temp = node;
        while(node != null && node.next != null){
            length++;
            node = node.next;
        }
        int counter = 1;
        while(length-nth+1 >= counter ){
            temp = temp.next;
            counter++;
        }

        return temp.val;
    }
}
