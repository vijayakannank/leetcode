package linkedList;

public class RotateList {

    static Node rotate(Node head, int k){
        Node tmp = head;

        int len =0;

        while(tmp.next != null){
            len++;
            tmp = tmp.next;
        }
        len++;
        tmp.next = head;

        k %= len;
        len = len-k;
        tmp = head;

        while(--len  >0){
            tmp = tmp.next;

        }
        Node res = tmp.next;
        tmp.next = null;


        return res;
    }

    public static void main(String[] args) {
        Node node = Node.buildLinkedList();
        Node res = rotate(node, 2);
        Node.print(res);

    }
}
