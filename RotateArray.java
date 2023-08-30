// Time Complexity : O(2n)-> O(n);
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class RotateArray {
    public void rotate(int[] nums, int k) {
        //logic
        int n = nums.length;
        k = k % n;

        // right rotation
        reverse(nums, 0, n-1);  // reverse entire array
        reverse(nums, 0, k-1);      // reverse first k elements
        reverse(nums, k, n-1);    //reverse remaining elements


        /* right rotation
        reverse(nums, n-k, n-1); // reverse last k elements
        reverse(nums, 0, n-k-1);  // reverse n-k elements
        reverse(nums, 0, n-1);  // reverse entire array
        */

        //left rotation
        /*
        reverse(nums, 0, k-1);      // reverse first k elements
        reverse(nums, k, n-1);    //reverse remaining elements
        reverse(nums, 0, n-1);  // reverse entire array
        */


    }

    public void reverse(int[] nums, int l, int r)
    {
        while(l < r)
        {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    public void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
