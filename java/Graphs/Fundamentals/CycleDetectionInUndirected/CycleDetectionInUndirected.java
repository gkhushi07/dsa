import java.util.*;
public class CycleDetectionInUndirected{

    static class Edge{
        int src, des;
        public Edge(int s, int d){
            this.src=s;
            this.des=d;
        }
    }

    static class VisitedTrack{
        boolean visited; int parent;

        public VisitedTrack(boolean v, int p){
            this.visited = v;
            this.parent = p;
        }
    }

    public static boolean cycleDetectionOnUndirected(ArrayList<Edge> graph[], int currentVertex, VisitedTrack visited[]){
        visited[currentVertex].visited = true;

        for(int i=0; i<graph[currentVertex].size(); i++){
            Edge e = graph[currentVertex].get(i);
            if(!(visited[e.des].visited)){
                visited[e.des].parent = currentVertex;
                if(cycleDetectionOnUndirected(graph, e.des,visited)){
                    return true;
                }
            }
            else if(visited[e.des].visited == true && visited[currentVertex].parent != e.des){
                return true;
            }
        }
        return false;
    }

        public static void createGraph(ArrayList<Edge> graph[]){

        for(int i = 0; i< graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1));
        // graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        // graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));

    }
    public static void main(String args[]){
        ArrayList<Edge> graph[] = new ArrayList[5];

        createGraph(graph);

        VisitedTrack visited [] = new VisitedTrack[graph.length];
        for(int i =0; i<visited.length; i++){
            visited[i] = new VisitedTrack(false, -1);
        }

        System.out.println("Cycle Detected: "+cycleDetectionOnUndirected(graph,0, visited));
    }
}