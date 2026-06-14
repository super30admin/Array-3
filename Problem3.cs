// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
If k is greater than size, replace k = k % size where size is the size of the nums array. Reverse the subarrays of the first size - k elements and the next k elements. Then reverse the entire array.
*/

public class Solution {
    public void Rotate(int[] nums, int k) {
        int size = nums.Length;
        
        if(k>size)
        {
            k = k % size;
        }

        Reverse(nums, 0, size - k-1);
        Reverse(nums, size - k, size - 1);
        Reverse(nums, 0, size - 1);
    }

    public void Reverse(int[] nums, int start, int end)
    {
        while(start < end)
        {
            Swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void Swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}