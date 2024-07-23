package linkedList;

public class RecuirsiveSumOfTwoNo {
    public static void main(String[] args) {
        System.out.println(sum(Node.buildLinkedList(), Node.buildLinkedList(),0));

    }

     static int sum(Node node1, Node node2, int sum){

        if(node1 == null) return 0;

        sum(node1.next, node2.next, sum);
         System.out.println("value is "+ node1.val);
        sum += node1.val+node2.val;
        return sum;
    }

}
