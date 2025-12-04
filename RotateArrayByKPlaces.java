// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : We first check if k is greater than n and apply mod function, if we rotate n times, we get the same array.
// We rotate the complete array, then rotate the first k elements and then the rest of elements from k.

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n < 2){
            return;
        }
        if(k > n){
            k = k%n;
        }
        rotate(nums, 0, n - 1); //rotate complete array
        rotate(nums, 0, k - 1); //rotate until k-1 index
        rotate(nums, k, n - 1); //rotate from k to end of array
    }

    private void rotate(int[] nums, int left, int right) { //rotate array of size left to right
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}