// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        
       reverse(nums, 0, nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k, nums.length-1);
    }
    
    private void reverse(int[] nums, int i, int j){
        while(i<j){
            int temp=nums[j];
            nums[j]=nums[i];
            nums[i]=temp;
            i++;
            j--;
        }
    }
}