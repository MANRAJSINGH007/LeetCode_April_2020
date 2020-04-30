class Solution {
    public int countElements(int[] arr) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < n; i++) set.add(arr[i]);
        for(int i = 0; i < n; i++) if(set.contains(arr[i] + 1)) count++;
        return count;
    }
}
