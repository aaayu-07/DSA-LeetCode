class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m=grid.length,n=grid[0].length;
        int[][] res=new int[m-k+1][n-k+1];
        for(int i=0;i<m-k+1;i++){
            for(int j=0;j<n-k+1;j++){
                Set<Integer> st=new HashSet<>();
                for(int x=i;x-i<k;x++){
                    for(int y=j;y-j<k;y++){
                        st.add(grid[x][y]);
                    }
                }
                List<Integer> arr=new ArrayList<>(st);
                Collections.sort(arr);
                int max=Integer.MAX_VALUE;
                for(int l=1;l<arr.size();l++){
                    max=Math.min(max,arr.get(l)-arr.get(l-1));
                }
                res[i][j]=(max==Integer.MAX_VALUE)?0:max;
            }
        }
        return res;
    }
}