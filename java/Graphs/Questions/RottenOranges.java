import java.util.*;

public class RottenOranges{

    static class GraphCoord{
        int h_coord, v_coord, time;

        public GraphCoord(int y, int x, int time){
            this.h_coord =y;
            this.v_coord =x;
            this.time = time;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows ");
        int r = sc.nextInt();
        System.out.println("Enter the number of columns");
        int c = sc.nextInt();

        int grid[][] = new int[r][c];

        System.out.println("Enter graph elements");
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                grid[i][j] = sc.nextInt(); 
            }
        }

        Queue<GraphCoord> q = new LinkedList<>();
        int freshOrangeCount =0;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
               if(grid[i][j]==2){
                q.add(new GraphCoord(i,j,0));
               }

                if(grid[i][j]==1){
                    freshOrangeCount++;
                }
            }
        }

        int timeTaken = 0;
        int rottenOrangeCount = 0;
        int directions[] = {1,-1,0,0,0,0,1,-1};

        while(!q.isEmpty()){
            int start_h_coord = q.peek().h_coord;
            int start_v_coord =q.peek().v_coord;
            int time = q.peek().time;
            timeTaken = Math.max(timeTaken, time);

            q.remove();

            for(int i=0; i<4; i++){
                int h_coord = start_h_coord +directions[i];
                int v_coord = start_v_coord + directions[i+4];
                
                if(h_coord>=0 && h_coord< r && v_coord>=0 && v_coord<c && grid[h_coord][v_coord]==1){
                    grid[h_coord][v_coord] =2;
                    q.add(new GraphCoord(h_coord,v_coord,timeTaken+1));
                    rottenOrangeCount++;
                }
            }
        }

        if(freshOrangeCount != rottenOrangeCount) 
        {System.out.println("These oranges can't be rotten" + (freshOrangeCount-rottenOrangeCount));
        return;}
        else{ System.out.println("Time Taken to Rot all Oranges: " + timeTaken);}
    }
}