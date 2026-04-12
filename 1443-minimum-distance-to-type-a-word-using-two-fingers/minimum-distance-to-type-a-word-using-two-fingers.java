class Solution {
    public static HashMap<Character, int[]> map;
    static {
        map = new HashMap<>();
        int i = 0;
        int j = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(c, new int[] { i, j });
            if (j == 5) {
                i++;
                j = 0;
            } else {
                j++;
            }
        }
    }

    public int minimumDistance(String word) {
        int[][][] dp = new int[word.length() + 1][26][26];
        for (int i = 0; i <= word.length(); i++) {
            for (int j = 0; j < 26; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (char c1 = 'A'; c1 <= 'Z'; c1++) {
            for (char c2 = 'A'; c2 <= 'Z'; c2++) {
                ans = Math.min(ans, solve(c1, c2, dp, word, 0));
            }
        }
        return ans;
    }

    private int solve(char c1, char c2, int[][][] dp, String word, int idx) {
        if (idx == word.length())
            return 0;
        if (dp[idx][c1 - 'A'][c2 - 'A'] != -1)
            return dp[idx][c1 - 'A'][c2 - 'A'];
        int[] p1 = map.get(c1);
        int[] p2 = map.get(c2);
        int[] p3 = map.get(word.charAt(idx));
        int s1 = solve(word.charAt(idx), c2, dp, word, idx + 1) + Math.abs(p1[0] - p3[0]) + Math.abs(p1[1] - p3[1]);
        int s2 = solve(c1, word.charAt(idx), dp, word, idx + 1) + Math.abs(p2[0] - p3[0]) + Math.abs(p2[1] - p3[1]);
        return dp[idx][c1 - 'A'][c2 - 'A'] = Math.min(s1, s2);
    }
}