/*
Brute Force Approach:
Rotate all the elements of the array in k steps by rotating the elements by 1 unit in each step.
Time Complexity: O(n*k)
Space Complexity: O(1)

Reverse approach:
1. When we rotate the array k times, k elements from the back of the array would come to the front and rest of the element from the front would shift backwards
Time Complexity: O(n)
Space Complexity: O(1)
*/

public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        //I would reverse all the elements of the array
        reverse(nums, 0, nums.length - 1); // 7 6 5 4 3 2 1
        //reversing k elements 
        reverse(nums, 0, k - 1); // 5 6 7 4 3 2 1
        //revering last n-k elements
        reverse(nums, k, nums.length - 1); // 5 6 7 1 2 3 4 
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    private void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
