// time complexity:O(n)
// space complexity: O(1)
class Solution {
    public void rotate(int[] nums, int k) {

        k = k % nums.length;
        // reverse complete arrya
        reverseArray(nums, 0, nums.length - 1);
        // reverse left part of array excluding kth element
        reverseArray(nums, 0, k - 1);
        // reverse right part of array starting with kth element
        reverseArray(nums, k, nums.length - 1);

    }

    public void reverseArray(int[] a, int l, int r) {
        while (l <= r) {
            int t = a[l];
            a[l] = a[r];
            a[r] = t;
            l++;
            r--;

        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        s.rotate(nums, k);
        for (int i : nums) {
            System.out.println(i);
        }
    }

}
