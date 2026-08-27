class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] totalCount = new int[26];
        for (char c : s.toCharArray()) {
            totalCount[c - 'a']++;
        }

        // Find how far target's prefix can match using characters from s
        int[] prefixCount = new int[26];
        int maxPrefix = 0;
        while (maxPrefix < n) {
            int charIdx = target.charAt(maxPrefix) - 'a';
            if (prefixCount[charIdx] + 1 <= totalCount[charIdx]) {
                prefixCount[charIdx]++;
                maxPrefix++;
            } else {
                break;
            }
        }

        // Try placing a strictly larger character at the highest possible index i (from maxPrefix down to 0)
        for (int i = maxPrefix; i >= 0; i--) {
            // If i == n, all characters matched target, so no character can be strictly greater at index n
            if (i < n) {
                int targetCharIdx = target.charAt(i) - 'a';

                // Look for the smallest available character strictly greater than target[i]
                for (int c = targetCharIdx + 1; c < 26; c++) {
                    if (prefixCount[c] < totalCount[c]) {
                        // Found the optimal split point and replacement character
                        StringBuilder sb = new StringBuilder();
                        sb.append(target, 0, i);
                        sb.append((char) ('a' + c));
                        prefixCount[c]++;

                        // Append the remaining characters in ascending order
                        for (int rem = 0; rem < 26; rem++) {
                            int available = totalCount[rem] - prefixCount[rem];
                            while (available > 0) {
                                sb.append((char) ('a' + rem));
                                available--;
                            }
                        }
                        return sb.toString();
                    }
                }
            }

            // Backtrack one character from the matched prefix
            if (i > 0) {
                prefixCount[target.charAt(i - 1) - 'a']--;
            }
        }

        return "";
    }
}