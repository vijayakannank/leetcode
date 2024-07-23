package linkedList;

public class ReturnBtwIndex {

    public static void main(String[] args) {
        Node node = getBtwIndex(Node.buildLinkedList(),1,3);
        Node.print(node);

    }

    static Node getBtwIndex(Node node, int start,int end){
        int counter = 0;
        while(counter <= end){
            if( start-1 == counter){
                node = node.next;
            } else if(counter == end){
                node.next = null;
            }
            else node = node.next;
            counter++;
        }

        return node;
    }
}
