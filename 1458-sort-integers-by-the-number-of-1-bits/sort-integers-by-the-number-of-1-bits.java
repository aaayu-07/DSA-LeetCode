class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed,(a,b) -> {
            int countA=Integer.bitCount(a);
            int countB=Integer.bitCount(b);

            if(countA == countB){
                return a - b;
            }
            return countA- countB;

        });
        return Arrays.stream(boxed).mapToInt(Integer::intValue).toArray();
        
    }
}