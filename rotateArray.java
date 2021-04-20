// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :N/A
// Any problem you faced while coding this :Test cases


// Your code here along with comments explaining your approach
class Solution {
    public void rotate(int[] nums, int k) 
    {
      k = k % nums.length;
      //reverse the complete array
      reverse(nums,0,nums.length-1);
      //reverse just the k numbers from the beginning
      reverse(nums,0,k-1);
      //reverse the remaining numbers after k number of numbers from the begining of the array
      reverse(nums,k,nums.length-1);
        
    }
  
    public void reverse(int[] nums,int start, int end)
    {
        while(start<end)
        {
          int temp = nums[start];
          nums[start] = nums[end];
          nums[end] = temp;
          start++;
          end--;
        }
    }
}