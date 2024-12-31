// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
  public void rotate(int[] nums, int k) {
    int n = nums.length;
    k = k % n;
    reverse(nums, 0, n-1);
    reverse(nums, 0, k-1);
    reverse(nums, k, n-1);
  }

  void reverse(int[] nums, int l, int r) {
    while(l<r) {
      swap(nums, l, r);
      l++;
      r--;
    }
  }

  void swap(int[] nums, int left, int right) {
    int temp = nums[left];
    nums[left] = nums[right];
    nums[right] = temp;
  }
}