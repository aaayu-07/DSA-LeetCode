class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];

        int maxi = nums[0];
        int mini = nums[n-1];

        for(int i=0;i<n;i++){
            max[i]=Math.max(maxi,nums[i]);
            maxi = Math.max(maxi,nums[i]);

        }
        
        for(int i=n-1;i>=0;i--){
            min[i]=Math.min(mini,nums[i]);
            mini = Math.min(mini,nums[i]);
        }

        int idx = -1;

        for(int i=0;i<n;i++){
            if((max[i]-min[i])<=k){
                idx=i;
                return idx;
            }
        }

        return idx;
    }
}