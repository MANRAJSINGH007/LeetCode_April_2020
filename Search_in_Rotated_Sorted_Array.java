class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0, end = n - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[start] == target) return start;
            if(nums[mid] == target) return mid;
            if(nums[start] <= target && target < nums[mid] || nums[start] > nums[mid] && (target >= nums[start] || target < nums[mid])) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }
}
