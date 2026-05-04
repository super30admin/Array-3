// O(n) time, O(n) space
// class Solution {
//     public void rotate(int[] nums, int k) {
//         int n = nums.length;
//         int[] temp = new int[n];
//         k = k % n;
//         for (int i = 0; i < n; i++) {
//             temp[(i+k) % n] = nums[i];
//         }
//         for (int i = 0; i < n; i++) {
//             nums[i] = temp[i];
//         }
//     }
// }

// O(n) time, O(1) space
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(0, n-1, nums); // reverse array
        reverse(0, k-1, nums); // reverse 1st k elements
        reverse(k, n-1, nums); // reverse remaining portion
    }
    private void reverse(int left, int right, int[] nums) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}