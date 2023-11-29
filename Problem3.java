// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    private void swap(int[] nums, int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp; 
    }
    private void reverse(int[] nums, int left, int right){
        while(left < right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-k-1);
        reverse(nums,0,n-1);
    }
}
