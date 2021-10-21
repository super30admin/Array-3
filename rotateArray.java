// Time complexity: O(kn)
// Space complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public void rotate(int[] nums, int k) {
        // check for null or empty input array
        if(nums == null || nums.length == 0) return;
        int n = nums.length;
        // if the number of rotations are greater than the length of input array
        // find the effective number of elements to be rotated
        if(k > n) k = k % n;
        // reverse the whole array
        reverse(nums, 0, n-1);
        // reverse the first k elements
        reverse(nums, 0, k-1);
        // reverse the remaining elements
        reverse(nums, k, n-1);

    }
    // function to reverse elements in array between given indices
    private void reverse(int[] nums, int l, int r){
        // while l and r pointers don't cross each other,
        // keep swapping the elements at l and r pointers
        // keep updating l and r pointers
        while(l < r){
            swap(nums, l, r);
            l++;
            r--;
        }
    }
    // function to swap two elements in array
    private void swap(int[] nums,int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}