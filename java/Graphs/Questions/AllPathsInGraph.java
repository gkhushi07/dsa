import java.util.*;

public class AllPathsInGraph{
    static class Edge{
        int src, des;

        public Edge(int s, int d){
            this.src = s;
            this.des = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
    }

    public static void modifiedDfs(ArrayList<Edge> graph[], int curr_vertex, int target, boolean visited[], String path){
        path = path + curr_vertex + " ";
        
        if(curr_vertex == target){
            System.out.println(path);
            return;
        }


        for(int i=0; i<graph[curr_vertex].size(); i++){
            if(!visited[graph[curr_vertex].get(i).des]){
                visited[curr_vertex] = true;
                modifiedDfs(graph, graph[curr_vertex].get(i).des, target,visited, path);
                visited[curr_vertex] = false;
            }
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter target value.");
        int tar = sc.nextInt();
        sc.close();
        int V=7;
        String path = "";
        ArrayList<Edge> graph[] = new ArrayList[V];
        boolean visited[] = new boolean[graph.length];
        createGraph(graph);

        modifiedDfs(graph, 0, tar, visited, path);
    }
}