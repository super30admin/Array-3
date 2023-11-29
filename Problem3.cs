public class RotateArrayKTimes
	{
        // Time Complexity : O(n)
        // Space Complexity : O(1) - in place
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        public void Rotate1(int[] nums, int k)
        {
            if (nums == null || nums.Length == 0) return;
            int n = nums.Length;
            if(k > n)
            {
                k = k % n;
            }

            Reverse(nums, 0, n - 1);
            Reverse(nums, 0, k - 1);
            Reverse(nums, k, n - 1);
 
        }

        public void Reverse(int[] nums, int l, int r)
        {
            while(l < r)
            {
                Swap(nums, l, r);
                l++;
                r--;
            }
        }

        public void Swap(int[] arr, int i, int j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
}
