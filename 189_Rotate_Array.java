    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/rotate-array/
    Time Complexity for operators : o(n) .. n is the length of the array
    Extra Space Complexity for operators : o(1)
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) Reverse the entire array.
                    B) Revse array from 0 to k-1
                    C) Reverse array from k to nums.length - 1.
    */
class Solution {
    public void rotate(int[] nums, int k) {
        
        k = k % nums.length;
        
        if(k == 0)
            return;
        
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }
    
    private void reverse(int nums[], int start, int end){
        
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            
            start += 1;
            end -= 1;
        }
    }
}