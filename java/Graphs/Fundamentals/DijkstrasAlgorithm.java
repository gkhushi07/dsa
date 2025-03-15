import java.util.*;

public class DijkstrasAlgorithm{
    static class Edge{
        int src, des, wt;

        public Edge(int s,int d, int w){
            this.src=s;
            this.des=d;
            this.wt=w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,7));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
    }

    static class Pair implements Comparable<Pair>{
        int vertex, distance;

        public Pair(int v, int d){
            this.vertex =v;
            this.distance=d;
        }

        @Override
        public int compareTo(Pair p){
            return this.distance - p.distance;
        }
    }
// TIME COMPLEXITY: O(E + ElogV) where E is complexity of BFS and ELogV is complexity of Priority Queue where, E~v
    public static void dijkstra(ArrayList<Edge> graph[], PriorityQueue<Pair> pq, int[] distance, boolean[] visited){
        
        while(!pq.isEmpty()){
            Pair current= pq.remove();

            if(!visited[current.vertex]){
                visited[current.vertex] = true;
                for(int i=0; i<graph[current.vertex].size(); i++){
                    Edge e=graph[current.vertex].get(i);

                    if(current.distance + e.wt < distance[e.des]){
                        distance[e.des] = current.distance + e.wt;
                        pq.add(new Pair(e.des, distance[e.des]));
                    }
                }
            }
        }

        for(int i=0; i<distance.length; i++){
            System.out.print(distance[i]+ " ");
        }

    }
    public static void main(String args[]){

        ArrayList<Edge> graph[] = new ArrayList[6];
        createGraph(graph);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int distance[] = new int[6];
        for(int i=0; i<distance.length; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[0] = 0;
        boolean visited[] = new boolean[6];

        pq.add(new Pair(0, 0));

        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                dijkstra(graph, pq, distance, visited);
            }
        }
    }
}