class Solution {
    static int inf = Integer.MAX_VALUE;
    public static int func(int[][] grid, int n, int m, int i, int j, int[][] dp) {
        if(i == n || j == m) return inf;
        if(i == n - 1 && j == m - 1) return grid[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        int x1 = func(grid, n, m, i + 1, j, dp);
        int x2 = func(grid, n, m, i, j + 1, dp);
        int min = Math.min(x1, x2);
        return dp[i][j] = min + grid[i][j];
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        if(n == 0) return 0;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) dp[i][j] = -1;
        }
        return func(grid, n, m, 0, 0, dp);
    }
}
