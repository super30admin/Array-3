// Approach: 1. Reverse the whole array
// 2. Reverse the array from 0th to Kth-1 index
// 3. Reverse the array from Kth index to last index
// Time: O(3n) = O(n)
// Space: O(1)

class RotateArrayBy_k_places {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}