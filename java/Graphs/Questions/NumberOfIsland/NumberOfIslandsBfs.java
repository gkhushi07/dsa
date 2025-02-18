import java.util.*;

public class NumberOfIslandsBfs{
    static class GraphPoint{
        int cord_h, cord_v;

        public GraphPoint(int x, int y){
            this.cord_h =x;
            this.cord_v =y;
        }
    }
    
    // private static void six_d_bfs(int grid[][], boolean visited[][], int start_cord_h,int start_cord_v, int total_row, int total_col){
    //     Queue<GraphPoint> q= new LinkedList<GraphPoint>();
    //     q.add(new GraphPoint(start_cord_h,start_cord_v));

    //     while(!q.isEmpty()){
    //         int cord_h=q.peek().cord_h;
    //         int cord_v=q.peek().cord_v;
    //         q.remove();
    //         for(int i = -1; i<=1; i++){
    //             for(int j =-1; j<=1; j++){
    //                 if (i == 0 && j == 0) continue;
    //                 int n_cord_h = cord_h+i;
    //                 int n_cord_v = cord_v+j;
    //                 if(n_cord_h>=0 && n_cord_h<total_row && n_cord_v>=0 && n_cord_v<total_col && grid[n_cord_h][n_cord_v] == 1 && !visited[n_cord_h][n_cord_v]){
    //                     q.add(new GraphPoint(n_cord_h,n_cord_v));
    //                 }
    //             }
    //         }
    //     }
    // }

private static void bfs(int grid[][], boolean visited[][], int start_cord_h, int start_cord_v, int total_row, int total_col) {
    Queue<GraphPoint> q = new LinkedList<>();
    q.add(new GraphPoint(start_cord_h, start_cord_v));
    // visited[start_cord_h][start_cord_v] = true; // Mark the starting point as visited *immediately*

    int[] dr = {1,-1,-1, 1, 0, 0, 1, -1 }; // Define delta rows for cleaner neighbor checking
    int[] dc = {-1,-1,0, 0, -1, 1, 1, 1}; // Define delta columns

    while (!q.isEmpty()) {
        GraphPoint current = q.poll(); // Use poll() to remove and get the element
        int cord_h = current.cord_h;
        int cord_v = current.cord_v;

        for (int i = 0; i < 6; i++) { // Iterate through the 4 cardinal directions
            int n_cord_h = cord_h + dr[i];
            int n_cord_v = cord_v + dc[i];

            if (n_cord_h >= 0 && n_cord_h < total_row && n_cord_v >= 0 && n_cord_v < total_col && 
                grid[n_cord_h][n_cord_v] == 1 && !visited[n_cord_h][n_cord_v]) {

                visited[n_cord_h][n_cord_v] = true; // Mark as visited *before* adding to the queue
                q.add(new GraphPoint(n_cord_h, n_cord_v));
            }
        }
    }
}
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows:");
        int m = sc.nextInt();
        System.out.println("Enter the number of columns:");
        int n = sc.nextInt();

        // Consume the leftover newline after reading integers
        sc.nextLine(); // This fixes the issue of infinite input after m and n

        int[][] grid = new int[m][n];
        System.out.println("Enter the grid elements (1 for land, 0 for water):");
        
        // Read the grid values
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = sc.nextInt(); // Read grid elements
            }
        }
        sc.close();

        boolean[][] visited = new boolean[m][n];
        int island_count = 0;

        // Count the islands
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    island_count += 1;
                    visited[i][j] = true;
                    bfs(grid, visited, i, j, m, n);
                }
            }
        }
        System.out.println("Total Islands:" + island_count);
    }
}