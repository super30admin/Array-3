// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public void rotate(int[] nums, int k) {
        //edge
        if(nums == null || nums.length == 0) return;
        //get the length of the array
        int n = nums.length;
        //check if k is greater than n
        if(k>=n){
            //get the division spot
            k = k%n;
        }
        //reverse the list then reverse both side
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    
    private void reverse(int[] nums, int i, int r){
        while(i <= r){
            swap(nums, i, r);
            i++;
            r--;
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}