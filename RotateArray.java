// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

// If k is greater than n, set k = k % n
// Reverse the complete array. Then Reverse the first k elements
// Now reverse elements from index k to n - 1

class Solution {
    public void rotate(int[] nums, int k) {
        
        if(nums == null || nums.length == 0) return;
        
        int n = nums.length;
        
        if(k >= n) {
            k = k % n;
        }
        
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        
    }
    
    private void reverse(int[] nums, int i, int j) {
        
        while(i < j) {
            
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            
            i++;
            j--;
        }
    }
}