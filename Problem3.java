/*
    LC - 189. Rotate Array
    TC - O(n)
    SC - O(1)
    Approach -
        k is remainder of k % numslength
        reverse(nums, 0, n-1); ----> entire array
        reverse(nums, 0, k-1); ----> first k elements in the array
        reverse(nums, k, n-1); ----> remaining from k elements in the array
*/

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    private void reverse(int[] nums, int l, int r) {
        while(l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }
    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}