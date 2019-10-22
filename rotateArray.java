//Time Complexity: O(n)
//Space Complexity: O(1)
//Check if k is within the length of nums array
//call a revers function to swap the nums from 0 to nums.length-1
//Then to swap from 0 till k-1th position 
//Finally from kth position to nums.length-1
class Solution {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[] nums, int start, int end)
    {
        int temp = 0;
        while(start<end)
        {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}