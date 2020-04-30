class Solution {
    public static void dfs(char[][] grid, int n, int m, int i, int j) {
        if(i < 0 || j < 0 || i == n || j == m || grid[i][j] == '.' || grid[i][j] == '0') return;
        grid[i][j] = '.';
        dfs(grid,n , m, i + 1, j);
        dfs(grid,n , m, i - 1, j);
        dfs(grid,n , m, i, j + 1);
        dfs(grid,n , m, i, j - 1);
        return;
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if(n == 0) return 0;
        int m = grid[0].length;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    ans++;
                    dfs(grid, n, m, i, j);
                }
            }
        }
        return ans;
    }
}
