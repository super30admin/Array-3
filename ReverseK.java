// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach :
/*
 * Approach 1- 
 * 1 - Reverse the entire array
 * 2 - Reverse the first k elements
 * 3 - Reverse the next k to the last element
 */

public class ReverseK {
    public void rotate(int[] nums, int k) {
        if(nums.length == 0 || nums == null)
        {
            return;
        }
        k = k%nums.length;
        
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k - 1);
        reverse(nums,k,nums.length - 1);
    }
    
    public void reverse(int[] nums, int i, int j)
    {
        while(i < j)
        {
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    
    public void swap(int[] nums, int l,int r)
    {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
