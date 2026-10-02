class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), res);
        return res;
    }

    void backtrack(int n, int open, int close, StringBuilder s, List<String> res) {
        if (open == n && close == n) {
            res.add(s.toString());
            return;
        }

        if (open < n) {
            s.append('(');
            backtrack(n, open + 1, close, s, res);
            s.deleteCharAt(s.length() - 1);
        }

        if (close < open) {
            s.append(')');
            backtrack(n, open, close + 1, s, res);
            s.deleteCharAt(s.length() - 1);
        }
    }
}