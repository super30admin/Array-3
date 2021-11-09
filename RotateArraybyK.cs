using System;
using System.Collections.Generic;
using System.Text;

namespace Array
{
    class RotateArraybyKLC
    {
        //TC: O(n)
        //SC: O(1)
        public void Rotate(int[] nums, int k)
        {
            if (nums == null || nums.Length == 0) return;
            int n = nums.Length;
            if (k > n) { k = k % n; }
            reverse(nums, 0, n - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, n - 1);
        }
        private void reverse(int[] nums, int l, int r)
        {
            while (l < r)
            {
                swap(nums, l, r);
                l++;
                r--;
            }
        }
        private void swap(int[] nums, int l, int r)
        {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
    }
}
