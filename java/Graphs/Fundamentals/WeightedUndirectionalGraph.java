import java.util.*;

public class WeightedUndirectionalGraph{

    static class Edge{
        int src, des, weight;

        public Edge(int s, int d, int w){
            this.src = s;
            this.des = d;
            this.weight = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for( int i= 0; i< graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1,6));
        graph[0].add(new Edge(0,2,7));  

        graph[1].add(new Edge(1,0,6));
        graph[1].add(new Edge(1,2,8));
        graph[1].add(new Edge(1,3,5));

        graph[2].add(new Edge(2,0,7));
        graph[2].add(new Edge(2,1,8));
        graph[2].add(new Edge(2,3,9));

        graph[3].add(new Edge(3,1,5));
        graph[3].add(new Edge(3,2,9));

        graph[4].add(new Edge(4,3,1));

    }

    public static void main(String args []){

        int V = 5;

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        for(int i=0; i<graph[1].size(); i++ ){
            System.out.println("Source: " + graph[1].get(i).src + " Destination: " + graph[1].get(i).des + " Weight: " + graph[1].get(i).weight);
        }
    }
}