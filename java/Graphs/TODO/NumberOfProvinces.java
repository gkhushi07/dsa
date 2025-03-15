class Solution {

    //Using DFS Travesal
    public int findCircleNum(int[][] isConnected) {
    
        int v=isConnected.length;
        boolean[] visited = new boolean[v];
        int provinces = 0;

        for (int i = 0; i < v; i++) {
            if (!visited[i]) { 
                dfs(isConnected, visited, i);
                provinces++; 
            }
        }
        return provinces;
    }
    private void dfs(int[][] isConnected, boolean[] visited, int node) {
        visited[node] = true; 

        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[node][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j); 
            }
        }
    }
}