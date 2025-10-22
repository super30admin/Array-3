/*
189. Rotate Array
Ran on leetcode: Yes
TC: O(n)
SC: O(1)
Reverse last k elements, reverse first n - k elements and then reverse all 
*/
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // k can be greater than size of array

        reverse(nums, n - k, n - 1); // reverse last k elements
        reverse(nums, 0, n - k - 1); // reverse first n - k elements
        reverse(nums, 0, n - 1); // Reverse all the elements
    }

    private void reverse(int[] nums, int start, int end){ // reverse
        while(start < end){ // use two pointers and swap elements from outside in
            swap(nums, start, end); 
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int el1, int el2){ // swap elements using temp variables
        int temp = nums[el1];
        nums[el1] = nums[el2];
        nums[el2] = temp;
    }
}