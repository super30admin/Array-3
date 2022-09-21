import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n) where n = length of array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// 1. Iterate through array, take the value at particular index and modify the number present at value-1 in the array by multiplying with -1.
// 2. After going through all items, iterate through array one  more time and check if the number at an index is negative.
// 3. If the number is positive at an index, that means the missing number is index+1. So, add index+1 to the list.

//189. Rotate Array (Medium) - https://leetcode.com/problems/rotate-array/
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        int n = nums.length;
        k %= n;
        
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}