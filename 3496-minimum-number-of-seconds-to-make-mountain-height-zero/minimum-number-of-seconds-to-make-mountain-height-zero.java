class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 1;
        long right = (long)1e16; 
        
        while (left < right) {
            long mid = left + (right - left) / 2;
            
            if (canFinish(mid, mountainHeight, workerTimes)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canFinish(long time, int mountainHeight, int[] workerTimes) {
        long total = 0;
        
        for (int w : workerTimes) {
            double val = Math.sqrt(1.0 + (8.0 * time) / w);
            long h = (long)((val - 1) / 2);
            total += h;
            
            if (total >= mountainHeight) return true;
        }
        
        return total >= mountainHeight;
    }
}