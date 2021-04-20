// Time Complexity : O(2n) => O(n) n- length of the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) return;
        k = k % nums.length;
        // reverse the entire arr
        reverse(nums,0,nums.length-1);
        // reverse k elements
        reverse(nums,0,k-1);
        // reverse n-k elements
        reverse(nums,k,nums.length-1);
    }
    
    public void reverse(int[] nums, int start,int end){
        while(start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
