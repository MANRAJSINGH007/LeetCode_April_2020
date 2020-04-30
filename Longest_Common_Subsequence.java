class Solution {
    public static int func(String s1, String s2, int i, int j, int n, int m, int[][] dp) {
        if(i == n || j == m) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 1 + func(s1, s2, i + 1, j + 1, n, m, dp);
        return dp[i][j] = Math.max(func(s1, s2, i + 1, j, n, m, dp), func(s1, s2, i, j + 1, n, m, dp));
    }
    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) dp[i][j] = -1;
        }
        return func(s1, s2, 0, 0, n, m, dp);
    }
}
