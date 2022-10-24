// Time Complexity :O(n)
// Space Complexity :)(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes

class Solution {
    public int trap(int[] height) {
        int result = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            if (height[start] <= height[end]) {
                int current = height[start];
                while (height[++start] < current) {
                    result += current - height[start];
                }
            } else {
                int current = height[end];
                while(height[--end] < current) {
                    result += current - height[end];
                }
            }
        }
        return result;
    }
}



// Time Complexity :O(n)
// Space Complexity :)(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

class Solution 
{
    public void rotate(int[] nums, int k) 
    {
        if(nums == null || nums.length == 0) 
        {
            return;
        }
        
        int n = nums.length;
        if(k >= n) {
            k = k % n;
        }
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    
    private void reverse(int[] nums, int left, int right){
        while(left <= right)
        {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    
    private void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
    }
}

// Time Complexity: O(nlogn)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

class Solution 
{
    public int hIndex(int[] citations) 
    {
        Arrays.sort(citations);
        
        int n = citations.length, i;
        for(i = 1; i <= n; ++i){
            if(citations[n-i] < i){
               break;
            }
        }
        return i-1;
    }
}