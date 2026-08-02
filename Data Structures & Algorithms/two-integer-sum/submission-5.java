class Solution {
    public int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        HashMap<Integer, Integer> targetAcheived = new HashMap<>();
     
        for(int i=0; i<size; i++){
         int complement = target - nums[i];
        if (targetAcheived.containsKey(complement)) {
        
            int[] ans = new int[]{targetAcheived.get(complement), i};
            return ans;
        }
        targetAcheived.put(nums[i], i);
        }
        
        return new int[]{-1, -1};
    }
}
