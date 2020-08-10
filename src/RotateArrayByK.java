// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english - 

// Your code here along with comments explaining your approach

/*
 * https://leetcode.com/problems/rotate-array/submissions/
 * 
 * Alternate approaches -  1. do one by one rotation for k times - O(nK) time solution
 * 						2. use extra space (extra array) and copy array based on k value and rotation O(n) time O(n) space solution
 * 						
 * */


class Solution {
    
    //O(n) one pass time, O(1) space
    public void rotate(int[] nums, int k) {
        if(k==0 || nums == null || nums.length ==0) return;
        
        //first reverse whole array
        reverse(nums, 0, nums.length-1);
        
        // handle case where k > nums length
        k = k % nums.length;
        
        //reverse first k elements of the reversed array
        reverse(nums, 0, k-1);
        
        //reverse k+1 to end
        reverse(nums, k, nums.length-1);
       
    }
    
    private void reverse(int[] nums, int l, int r) {
         while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;r--;
        }
    }
}