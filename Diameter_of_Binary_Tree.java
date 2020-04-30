class Solution {
    static int max;
    public static int func(TreeNode root) {
        if(root == null) return 0;
        int x1 = func(root.left);
        int x2 = func(root.right);
        max = Math.max(max, x1 + x2);
        return Math.max(x1, x2) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        max = 0;
        int x = func(root);
        return max;
    }
}
