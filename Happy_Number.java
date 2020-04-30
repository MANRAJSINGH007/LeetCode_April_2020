class Solution {
    public static boolean happy(int n, HashSet<Integer> set) {
        if(n == 1) return true;
        if(set.contains(n)) return false;
        set.add(n);
        int ans = 0;
        while(n > 0) {
            ans += (int)Math.pow(n % 10, 2);
            n /= 10;
        }
        return happy(ans, set);
    }
    public boolean isHappy(int n) {
        return happy(n, new HashSet<>());
    }
}
