import java.util.*;

public class DfsOnUnconnected{

    static class Edge{
        int src, des;

        public Edge(int s, int d){
            this.src=s;
            this.des=d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i =0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,4));
        graph[4].add(new Edge(4,3));
    }
    public static void dfsOnUnconnected(ArrayList<Edge> graph[], boolean visited[], int curr_vertex){
        System.out.println(curr_vertex);
        visited[curr_vertex] = true;
        for(int i=0; i<graph[curr_vertex].size(); i++){
            if(visited[curr_vertex]==false){
                dfsOnUnconnected(graph, visited, graph[curr_vertex].get(i).des);
            }
        }

    }
    public static void main(String args []){
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        boolean visited [] = new boolean[graph.length];

        for(int i=0; i<V; i++){
            if(visited[i]== false){
                dfsOnUnconnected(graph, visited, i);
            }
        }
    }
}

/* 0 -- 1
    \  /
     2

    3 -- 4
*/