// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// First reverse the whole string, then reverse the first part till k-1, then reverse the second part which is k to n-1. don't forget to check the k > n if yes then k = k % n;
// Your code here along with comments explaining your approach
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) return;
        int n = nums.length;
        if(k > n) k = k % n;
        // revrese the whole string
        reverse(nums, 0, n-1);
        // reverse the first part
        reverse(nums, 0, k-1);
        // reverse the remaining part
        reverse(nums, k, n-1);
        return;
    }
    private void reverse(int []nums, int i, int j){
        while(i < j){
            swap(nums, i, j);
            i++; j--;
        }
    }
    private void swap(int []nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}