// Time Complexity: O(n)
// Space Complexity: O(1)
public class RotateArray {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return;
        int n = nums.length;
        // consider the scenario when k > n then only swa remaining no of times
        if(k > n)
        {
            k = k % n;
        }
        // reverse entier array
        reverse(nums, 0, n-1);
        // reverse first k elements
        reverse(nums, 0 , k-1);
        // reverese last k elements
        reverse(nums, k, n- 1);
    }


    private void reverse(int nums [], int l , int r)
    {
        while(l < r)
        {
            swap(nums, l , r);
            l++;
            r--;
        }
    }

    private void swap(int nums [], int l, int r)
    {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
} 