//Time Complexity: O(n)
//Space Complexity: No extra space used ~ O(1)

public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        //step1: reverse the entire array
        reverse(nums, 0, n - 1);
        //step2: reverse the array till kth location
        reverse(nums, 0, k - 1);
        //step3: reverse rest of the array(k -> n-1 array)
        reverse(nums, k, n - 1);
    }
    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            //swapping elements from left to right to reverse the array
            //using a temporary variable
            //increment left pointer and decrement right pointer
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}