//Time complexity: O(N)
//Space complexity: O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        if(k > nums.length) {
            k = k % nums.length;
        }
        int n = nums.length;
        //reverse all the elements
        reverse(nums, 0, n-1);
        //reverse the elements from 0 to k-1
        reverse(nums, 0, k-1);
        //reverse the elements from k to n-1
        reverse(nums, k, n-1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}