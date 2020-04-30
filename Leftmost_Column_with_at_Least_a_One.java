/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public static boolean check(BinaryMatrix binaryMatrix, int mid, int n) {
        for(int i = 0; i < n; i++) if(binaryMatrix.get(i, mid) == 1) return true;
        return false;
    }
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int n = dim.get(0), m = dim.get(1);
        int start = 0;
        int end = m - 1;
        int ans = -1;
        while(start <= end) {
            int mid = (start + end)/2;
            if(check(binaryMatrix, mid, n)) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans;
    }
}
