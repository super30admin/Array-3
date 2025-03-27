// Problem3 Rotate Array by K Places(https://leetcode.com/problems/rotate-array/)

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, first reverse whole array. Then reverse 1st k places then reverse k+1 to n places.
 */
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) return;
        k = k % n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    private void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}