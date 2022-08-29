//Time Complexity: o(n).
//Space Complexity: O(1).


class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int rsum = 0; 
        for(int i = 0; i < nums.length; i++){
           rsum =  Math.max(rsum + nums[i], nums[i]);
        
           maxSum = Math.max(maxSum, rsum);
        }
        
        return maxSum;
    }
}