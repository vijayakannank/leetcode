package graph;

public class BiperTite {
    public static void main(String[] args) {
        int[][] arr = {
                {1,3},
                {0,2},
                {1,3},
                {0,2}
        };
        System.out.println(new BiperTite().isBipartite(arr));
    }

    boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];

        for(int i=0;i<color.length;i++){
            //if curent node is not colored color it with red(1)
            if(color[i] == 0 && !isValid(graph,color,i,1))
                return false;
        }
        return true;
    }

    public boolean isValid(int[][] graph,int[] color, int index, int colorShade){
        //if current vertex is not colored check whether it's colored with
        //expected color shade
        if(color[index]!=0)
            return color[index] == colorShade;

        //color the current vertex
        color[index]=colorShade;

        for(int node : graph[index]){
            //check whether the adjacet vertex are colored with opposite color
            //for red vertex adjacents should be colored in blue and vice-versa
            if(!isValid(graph,color,node,-colorShade))
                return false;
        }

        return true;
    }
}
