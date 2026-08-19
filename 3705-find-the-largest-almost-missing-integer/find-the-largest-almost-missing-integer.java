class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        if (k == 1) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int x : nums) {
                freq.put(x, freq.getOrDefault(x, 0) + 1);
            }

            int ans = -1;
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                if (entry.getValue() == 1) {
                    ans = Math.max(ans, entry.getKey());
                }
            }
            return ans;
        }

        if (k == n) {
            int max = nums[0];
            for (int x : nums) {
                max = Math.max(max, x);
            }
            return max;
        }

        int ans = -1;

        if (isUnique(nums, 0)) {
            ans = Math.max(ans, nums[0]);
        }

        if (isUnique(nums, n - 1)) {
            ans = Math.max(ans, nums[n - 1]);
        }

        return ans;
    }

    private boolean isUnique(int[] nums, int idx) {
        for (int i = 0; i < nums.length; i++) {
            if (i != idx && nums[i] == nums[idx]) {
                return false;
            }
        }
        return true;
    }
}