// Time Complexity : O(2n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        if(nums==null||nums.length<=1||k==0)
            return;
        int n = nums.length;
        reverse(nums,0,n-1);
        reverse(nums,k,n-1);
        reverse(nums,0,k-1);
    }
    
    private void reverse(int[] nums,int l ,int h ){
        while(l<=h){
            int temp = nums[l];
            nums[l] = nums[h];
            nums[h] = temp;
            l++;
            h--;
        }
    }
}