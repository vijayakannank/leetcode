package graph.union;

public class FindParent {

    public static void main(String[] args) {
        int[] parent = {0, 1,1,1,2,2,3,3,5,6};
        System.out.println(findParent(parent, 6));
        System.out.println(findParent(parent, 4));
        System.out.println(findParent(parent, 2));
    }
    static int findParent(int[] arr, int node){
        if(arr[node] == node)
            return node;
        return arr[node] = findParent(arr, arr[node]);

    }

    static int findParentByPathCompression(int[] arr, int node){
        if(arr[node] == node)
            return node;
        return arr[node] = findParent(arr, arr[node]);

    }
}
