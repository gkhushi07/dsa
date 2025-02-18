import java.util.*;

public class DfsOnConnected{

    static class Edge{
        int src, des;

        public Edge(int s, int d){
            this.src=s;
            this.des=d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph []){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

    }

    public static void dfsOnConnected(ArrayList<Edge> graph[], int curr_vertex, boolean visited[]){

        System.out.println("curr " + curr_vertex);
        visited[curr_vertex] = true;

        for(int i=0; i<graph[curr_vertex].size(); i++){
            Edge e = graph[curr_vertex].get(i);
            if (visited[e.des] == false){
                dfsOnConnected(graph, e.des, visited);
            }

        }

    }

    public static void main(String args[]){
        ArrayList<Edge> graph[] = new ArrayList[5];

        createGraph(graph);

        boolean visited [] = new boolean[graph.length];

        dfsOnConnected(graph,0, visited);


    }
}