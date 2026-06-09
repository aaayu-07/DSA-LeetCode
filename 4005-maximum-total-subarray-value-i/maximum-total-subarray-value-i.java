class Solution {
    public long maxTotalValue(int[] nums, int k) {
        Long maxVal = Long.MIN_VALUE;
        Long minVal = Long.MAX_VALUE;

        for (int num : nums) {
            maxVal = Math.max(maxVal, (long)num);
            minVal = Math.min(minVal, (long)num);
        }

        return (long)k * (maxVal - minVal);
    }
}