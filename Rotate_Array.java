// Time complexity:- O(n) where n is the length of the input array.
// Space complexity:- O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences
/**
 * Approach:
 * This problem is about rotating an array to the right by 'k' positions.
 * I used an in-place approach by reversing parts of the array. First, I reverse the first part of the array,
 * then the second part, and finally reverse the entire array to complete the rotation. 
 */
class Solution {
    int[] nums;
    int k;
    public void rotate(int[] nums, int k) {
        this.nums = nums;
        int n = nums.length;

        k = k % n;
        // Reverse the first part of the array (from index 0 to n-k-1)
        reverse(0, n-k-1);
        // Reverse the second part of the array (from index n-k to n-1)
        reverse(n-k,n-1);
        // Reverse the entire array to complete the rotation
        reverse(0,n-1);
    }
    public void reverse(int left, int right) {
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
