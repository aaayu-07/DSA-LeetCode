class Solution {
    public int[] resultArray(int[] nums) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        int i = 0, j = 0;

        for(int k = 2; k < nums.length; k++){
            if(arr1.get(i) > arr2.get(j)){
                arr1.add(nums[k]);
                i++;
            }else{
                arr2.add(nums[k]);
                j++;
            }
        }
        arr1.addAll(arr2);


        int[] result = new int[arr1.size()];
        for (int k = 0; k < arr1.size(); k++) {
            result[k] = arr1.get(k);
        }

        return result;
    }
}