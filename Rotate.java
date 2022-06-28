/**
Time Complexity : O(N)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    public void rotate(int[] nums, int k) {
        
        int length = nums.length;
        k = k % length;
        
        reverse(nums, 0, length - k - 1);
        reverse(nums, length-k, length-1);
        reverse(nums, 0, length-1);
    }
    
    public void reverse(int nums[], int start, int end)
    {
        while(start <= end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            
            start++;
            end--;
        }
    }
}