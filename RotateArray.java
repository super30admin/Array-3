//Time Complexity: O(n)
//Space Complexity: O(1)

/*
 * we reverse the whole array once and then reverse it from the 
 * start to k-1 value and for the remaining value.
 */


class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length == 1) return;
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);        
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++; end--;
        }   
    }
}