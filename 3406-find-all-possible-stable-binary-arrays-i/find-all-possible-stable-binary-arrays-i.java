class Solution {
    static final int MOD = 1000000007;
    Long[][][] memo;
    int limit;

    public int numberOfStableArrays(int zero, int one, int limit) {
        this.limit = limit;
        memo = new Long[zero + 1][one + 1][2];

        long res = 0;
        res = (res + dfs(zero - 1, one, 0, 1)) % MOD;
        res = (res + dfs(zero, one - 1, 1, 1)) % MOD;

        return (int) res;
    }

    private long dfs(int z, int o, int last, int count) {
        if (z < 0 || o < 0) return 0;
        if (z == 0 && o == 0) return 1;

        if (memo[z][o][last] != null && count == 1)
            return memo[z][o][last];

        long ans = 0;

        if (last == 0) {
            if (z > 0 && count < limit)
                ans = (ans + dfs(z - 1, o, 0, count + 1)) % MOD;

            if (o > 0)
                ans = (ans + dfs(z, o - 1, 1, 1)) % MOD;
        } else {
            if (o > 0 && count < limit)
                ans = (ans + dfs(z, o - 1, 1, count + 1)) % MOD;

            if (z > 0)
                ans = (ans + dfs(z - 1, o, 0, 1)) % MOD;
        }

        if (count == 1)
            memo[z][o][last] = ans;

        return ans;
    }
}