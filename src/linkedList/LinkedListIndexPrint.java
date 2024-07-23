package linkedList;

public class LinkedListIndexPrint {

    public static void main(String[] args) {
        printBetweenIndex(Node.buildLinkedList(),0,2);
    }

    static void printBetweenIndex(Node head, int start, int end){
        if(head == null){
            return;
        }
        int counter = 0;
        while (counter <= end){
            if(start <= counter){
                System.out.println(head.val);
            }
            counter++;
            head = head.next;
        }
    }
}
