package graph.union;

public class CycleDetection {

    static Node[] nodes;
    public static void main(String[] args) {
        int n = 5;
        nodes = new Node[n];
        for(int i = 0; i< n; i++){
            nodes[i] = new Node();
        }
        int[][] arr = {
                {0,1},
                {2,3},
                {1,2},
                {0,4},
                {4,3}
        };
        System.out.println(new CycleDetection().isCyclic(arr));
    }

     boolean isCyclic(int[][] paths){

         for(int[] path: paths){
             int up = find(path[0]);
             int vp = find(path[1]);
             if(up == vp)
                 return true;
             union(up, vp);
         }
         return false;
     }

    int find( int v){
        if(nodes[v].parent == -1)
            return v;
        return nodes[v].parent = find( nodes[v].parent);
    }
    void union( int a, int b){
        int ap = find(a);
        int bp = find( b);

        if(nodes[ap].rank > nodes[bp].rank)
            nodes[bp].parent = nodes[ap].parent;

        else if(nodes[ap].rank < nodes[bp].rank)
            nodes[ap].parent = nodes[bp].parent;

        else {
            nodes[bp].parent = nodes[ap].parent;
            nodes[bp].rank++;
        }
    }
}

class Node {
    int parent;
    int rank;


    Node(){
        this.parent = -1;
        this.rank = 0;
    }
    public Node(int parent, int rank) {
        this.parent = parent;
        this.rank = rank;
    }
}