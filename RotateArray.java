// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// create a new array, newArray[i+k] = nums[i], if i+k>nums.length-1, then do %nums.length

class Solution {
    public void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        
        for(int i=0; i<nums.length; i++){
            if(i+k <= nums.length-1){
               result[i+k] = nums[i]; 
            }
            else{ 
                result[(i+k)%nums.length] = nums[i];
            }
        }
        
        for(int i=0; i<result.length; i++){
            nums[i] = result[i];
        }

    }
}