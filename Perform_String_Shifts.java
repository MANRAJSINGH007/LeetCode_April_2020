class Solution {
    public String stringShift(String s, int[][] shift) {
        int n = s.length(), net = 0, x= 0, y = 0;
        for(int  i = 0; i < shift.length; i++) {
            if(shift[i][0] == 1) x += (shift[i][1] % n);
            else y += (shift[i][1] % n);
        }
        net = x - y;
        if(net == 0) return s;
        String ans = "";
        if(net > 0) {
            net %= n;
            ans = s.substring(n - net) + s.substring(0, n - net);
        }
        else {
            net = -net;
            net %= n;
            ans = s.substring(net) + s.substring(0, net);
        }
        return ans;
    }
}
