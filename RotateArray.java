//https://leetcode.com/problems/rotate-array/
/*
Time: 
Space: 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class RotateArray {
    public void rotate(int[] nums, int k) // nums = [1,2,3,4,5,6,7], k = 3
    {
        k %= nums.length; // k=3
        reverse(nums, 0, nums.length - 1); // [7,6,5,4,3,2,1]
        reverse(nums, 0, k - 1); // [5,6,7,4,3,2,1]
        reverse(nums, k, nums.length - 1);// [5,6,7,1,2,3,4]
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
