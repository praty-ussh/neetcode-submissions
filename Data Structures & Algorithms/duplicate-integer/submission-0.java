class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> uniqueNum = new HashSet<>();
        for(int i=0; i< nums.length; i++){
            uniqueNum.add(nums[i]);
        }
        if(uniqueNum.size()< nums.length){
            return true;
        }
        else return false;
    }
}