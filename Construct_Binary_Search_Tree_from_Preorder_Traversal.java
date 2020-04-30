class Solution {
    public static TreeNode build(int[] preorder, int start, int end) {
        if(start > end) return null;
        if(start == end) return new TreeNode(preorder[start]);
        TreeNode root = new TreeNode(preorder[start]);
        int index = end + 1;
        for(int j = start + 1; j <= end; j++) {
            if(preorder[j] > preorder[start]) {
                index = j;
                break;
            }
        }
        root.left = build(preorder, start + 1, index - 1);
        root.right = build(preorder, index, end);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        return build(preorder, 0, preorder.length - 1);
    }
}
