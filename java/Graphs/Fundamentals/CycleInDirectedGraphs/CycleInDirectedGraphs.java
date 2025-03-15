import java.util.*;

public class CycleInDirected{
    static class Edge{
        int src, des;

        public Edge(int s, int d){
            this.src=s;
            this.des=d;
        }
    }

    public static boolean cycleInDirected(ArrayList<Edge> graph[], boolean visited[], boolean recursionStack[], int currentVertex){
        visited[currentVertex] = true;
        recursionStack[currentVertex] = true;

        for(int i=0; i<graph[currentVertex].size(); i++){
            Edge e = graph[currentVertex].get(i);
            
            if(!visited[e.des]){
                if(cycleInDirected(graph, visited, recursionStack, e.des))
                    return true;
            }
            else if(visited[e.des] && recursionStack[e.des]){
                return true;
            }
        }
        recursionStack[currentVertex] = false;
        return false;
    }

    public static void createDirectedGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[1].add(new Edge(1,2));
        graph[2].add(new Edge(2,3));
        // graph[3].add(new Edge(3,0));
    }

    public static void main(String args[]){
        ArrayList<Edge> graph[] = new ArrayList[4];

        createDirectedGraph(graph);

        boolean visited[] = new boolean[5];
        boolean recursionStack[] = new boolean[5];

        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                boolean isCycle = cycleInDirected(graph, visited,recursionStack, i);
                if(isCycle){
                    System.out.println("Cycle Exists");
                    break;
                }
                else{
                    System.out.println("Cycle Doesn't Exists");
                }
            }
        }
    }
}