class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n= strs.length;
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int[] count = new int[26];
            for(int j = 0; j < strs[i].length(); j++) count[strs[i].charAt(j) - 97]++;
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < 26; j++) {
                sb.append((char)(j + 97));
                sb.append(Integer.toString(count[j]));
            }
            String x = sb.toString();
            if(!map.containsKey(x)) map.put(x, new ArrayList<>());
            map.get(x).add(strs[i]);
        }
        Set<String> keys = map.keySet();
        List<List<String>> ans = new ArrayList<>();
        for(String k : keys) ans.add(map.get(k));
        return ans;
    }
}
