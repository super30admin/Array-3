/* 
Time Complexity: O(n) 
   - Reverse entire array, reverse first k, reverse last n-k → total O(n).

Space Complexity: O(1) 
   - In-place reversal.

Did this code successfully run on Leetcode: Yes
*/

// Approach:
// - Use the array reversal trick.
// - Step 1: Reverse the entire array.
// - Step 2: Reverse the first k elements.
// - Step 3: Reverse the remaining n-k elements.
// - This achieves rotation to the right by k in O(n) time and O(1) space.


public class RotateArrayToRightByK {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1); // reverse the entire array
        reverse(nums, 0, k - 1); // reverse the first k elements
        reverse(nums, k, n - 1); // reverse the remaining elements
    }

    private void reverse(int[] nums, int left, int right){
        while(left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
