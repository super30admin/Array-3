// Time Complexity : O(N)
// Space Complexity : O(1) - stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        // reverse
        reverse(nums, 0, n-1);

        // reverse 0 to k-1
        reverse(nums, 0, k-1);

        //reverse k to n-1
        reverse(nums, k, n-1);
    }

    private void reverse(int[] nums, int i, int j){
        while(i <j){
            swap(nums, i,j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i,int j){
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j]= temp;
    }
}