class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) if(nums[i] == 0) nums[i] = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, max = 0;
        map.put(0, - 1);
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            if(!map.containsKey(sum)) map.put(sum, i);
            else max = Math.max(max, i - map.get(sum));
        }
        return max;
    }
}
