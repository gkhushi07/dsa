// Done using modified dfs, where the dfs is same but we implemnt a stack to store the extreme neighbours.
import java.util.*;
public class TopologicalSorting {
    static class Edge{
        int src, des;

        public Edge(int s, int d){
            this.src=s;
            this.des=d;
        }
    }

    public static void createDAG(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,4));
    }

    public static void topologicalSorting(ArrayList<Edge> graph[], boolean visited[], int currentVertex, Stack<Integer> st ){
        visited[currentVertex] = true;
        for(int i=0; i< graph[currentVertex].size(); i++){
            Edge e= graph[currentVertex].get(i);
            if(!visited[e.des]){
                topologicalSorting(graph, visited, e.des, st);
            }
        }
        st.push(currentVertex);
    }
    public static void main(String args[]){
        ArrayList<Edge> graph[] = new ArrayList[5];

        createDAG(graph);// Directed Acyclic Graph, where the graphs have direction but no cyclic.

        boolean visited[]= new boolean[5];
        Stack<Integer> st= new Stack<>();
        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                topologicalSorting(graph, visited, i, st);
            }
        }
        for(int i=0; i<5; i++){
            System.out.print(st.pop() + " ");
        }
    }
}