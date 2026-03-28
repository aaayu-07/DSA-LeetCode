class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] s = new char[n];
        char cur = 'a';
        
        for (int i = 0; i < n; i++) {
            if (s[i] == 0) {
                if (cur > 'z') return "";
                for (int j = i; j < n; j++) {
                    if (lcp[i][j] > 0) s[j] = cur;
                }
                cur++;
            }
        }
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int expected = (s[i] == s[j]) ? 
                    (i + 1 < n && j + 1 < n ? lcp[i + 1][j + 1] + 1 : 1) : 0;
                if (lcp[i][j] != expected) return "";
            }
        }
        
        return new String(s);
    }
}