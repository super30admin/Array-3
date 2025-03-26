/*
 * Time Complexity (TC)
Each reverse function call runs in O(n) in total (three calls covering the whole array).
Overall, TC = O(n).

Space Complexity (SC)
The algorithm operates in place, using only a few extra variables.
SC = O(1) (constant space).

Explanation of the code in three sentences
The algorithm first calculates k % n to handle cases where k is greater than the array length.
It reverses the first n - k elements, then the last k elements, and finally the entire array to achieve the correct rotation order.
The reverse function swaps elements from both ends towards the center to efficiently perform in-place reversal.
 */


 class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 0) return;
        int n = nums.length;
        k = k % n;
        reverse (nums, 0, n - k - 1);
        reverse (nums, n - k, n - 1);
        reverse (nums, 0, n - 1);
    }

    private void reverse (int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l ++;
            r --;
        }
    }
}