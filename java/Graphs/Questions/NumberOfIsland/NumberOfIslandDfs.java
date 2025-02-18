import java.util.*;

public class NumberOfIslandsDfs{

    public static void dfs(int graph[][], boolean visited[][], int start_cord_h, int start_cord_v, int total_row, int total_col){
        int[] dr= {1,-1,1,-1, 0, 0,1,-1};
        int[] dc ={-1,-1,0,0, -1, 1,1,1};

        for(int i=0; i<8; i++){
            int cord_h = start_cord_h +dr[i];
            int cord_v = start_cord_v + dc[i];

            if(cord_h>=0 && cord_h<total_row && cord_v>=0 && cord_v< total_col && graph[cord_h][cord_v] == 1 && !visited[cord_h][cord_v] ){
                visited[cord_h][cord_v] = true;
                dfs(graph, visited, cord_h, cord_v, total_row, total_col);
            }
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int island_count = 0;
        System.out.println("Enter Number of Rows");
        int r=sc.nextInt();
        System.out.println("Enter Number of Columns");
        int c=sc.nextInt();

        int graph[][] = new int[r][c];
        System.out.println("Enter Graph Elements");

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                graph[i][j] = sc.nextInt();
            }
        }

        sc.close();

        boolean visited[][] = new boolean [r][c];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(!visited[i][j] && graph[i][j] == 1){
                    visited[i][j] = true;
                    island_count +=1;
                    dfs(graph, visited, i, j, r, c);
                }
            }
        }

        System.out.println("Total Islands =" + island_count);
    }
}