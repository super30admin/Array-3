class Solution {
	//Approach: 1. We have an additional extra space where we start placing the elements with k added to index and finally replace the original array with values from new one
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0 )
            return;
        if( k > nums.length)
            k = k % nums.length;
        int n = nums.length;
        int[] result = new int[n];
        for(int i=0; i < n;i++)
        {
            result[(i+k)%n] = nums[i];
        }
        for(int i=0; i < n;i++)
        {
            nums[i] = result[i];
        }
    }
    
}

//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode :
//Any problem you faced while coding this :

class Rotate_Array {
	//Approach: 1. Here we reverse the whole array once and then reverse the first k elements and then the remaining elements of array
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0 )
            return;
        if( k > nums.length)
            k = k % nums.length;
        int n = nums.length;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    private void reverse(int[] nums, int start, int end)
    {
        while(start < end)
        {
            int temp  = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode :
//Any problem you faced while coding this :