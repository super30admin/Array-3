
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
	// 1) Reverse array in place for n-k and 0 to k
	// 2) Then reverse whole array

public void Rotate(int[] nums, int k) {
        
        if(nums == null || nums.Length == 0)
            return;
        
        int n = nums.Length;
        
        if(k > n)
            k = k % n;
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-k-1);
        reverse(nums, 0, n-1);
        
        //OR
        // reverse(nums, 0, n-1);
        // reverse(nums, 0, k-1);
        // reverse(nums, k, n-1);
    }
    
    private void reverse(int[] nums, int l, int r)
    {
        while(l <= r)
        {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            
            l++;
            r--;
        }
    }
}