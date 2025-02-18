import java.util.*;

public class BfsOnConnected{

    static class Edge{
        int src, des;

        public Edge(int s, int d){
            this.src = s;
            this.des = d;
        }

    }
    
    public static void createGraph(ArrayList<Edge> graph[]){

        for(int i = 0; i< graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));

    }
    public static void bfs(ArrayList<Edge> graph[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        boolean visited[] = new boolean[graph.length];

        while(! q.isEmpty()){
            int curr_vertex = q.remove();
            if (visited[curr_vertex]== false){
                System.out.println(curr_vertex);
                visited[curr_vertex]=true;
                for(int i = 0; i<graph[curr_vertex].size(); i++){
                    q.add(graph[curr_vertex].get(i).des);
                }
            }
        }
    }

    public static void main(String args []){
        ArrayList<Edge> graph[] = new ArrayList[4];
        createGraph(graph);
        bfs(graph);
    }

}