// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        if(k==0) return;
        swap(nums,0,nums.length-1);
        swap(nums,0,k-1);
        swap(nums,k,nums.length-1);
    }
    
    private void swap(int[] nums, int low, int high)
    {
        while(low<high)
        {
            int temp = nums[low];
            nums[low]= nums[high];
            nums[high]= temp;
            low++;
            high--;
        }
    }
}