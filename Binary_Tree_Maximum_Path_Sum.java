class Solution {
    static int max;
    public static int findMaxPath(TreeNode root) {
        if(root == null) return 0;
        int x1 = findMaxPath(root.left);
        int x2 = findMaxPath(root.right);
        int sum = 0;
        if(x1 > 0) sum += x1;
        if(x2 > 0) sum += x2;
        sum += root.val;
        max = Math.max(max, sum);
        sum = root.val;
        if(x1 > 0 || x2 > 0) sum += Math.max(x1, x2);
        return sum;
    }
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        int dummy = findMaxPath(root);
        return max;
    }
}
