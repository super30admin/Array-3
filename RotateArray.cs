using System;
using System.Collections.Generic;
using System.Text;

namespace Array
{
    public class RotateArray
    {
        /*
         * T.C. : O(N) where n is number of array
         * S.C. : O(1)
         */
        public void Rotate(int[] nums, int k)
        {
            if (nums == null || nums.Length == 0 || k == 0)
                return;

            int n = nums.Length;
            if (k > n)
                k = k % n;

            //1st Method

            //reverse array starting from k element to last element
            //reverse(nums, n-k, n-1);
            // reverse array starting from 0 to kth element
            //reverse(nums, 0, n-k-1);
            // reverse all element of array
            //reverse(nums, 0, n-1);

            //2nd Method
            // reverse all element of array
            reverse(nums, 0, n - 1);
            // reverse array starting from 0 to kth element
            reverse(nums, 0, k - 1);
            //reverse array starting from k element to last element
            reverse(nums, k, n - 1);
        }

        private void reverse(int[] nums, int l, int r)
        {
            while (l <= r)
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
