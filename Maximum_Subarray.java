class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length, ans = Integer.MIN_VALUE, curr = 0;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, nums[i]);
            curr += nums[i];
            if(curr < 0) curr = 0;
            else ans = Math.max(ans, curr);
        }
        return ans;
    }
}
