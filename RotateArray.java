package Array3;

/*S30 FAANG Problem #119 {Easy} - https://www.youtube.com/watch?v=hP9SdQV2HR0

 * Given an array and a number k that's smaller than the length of the array, rotate the array to the right k elements in-place.
For eg: Rotating [1, 2, 3, 6, 9, 7, 5, 8, 10] right by k=3 places will give output [5, 8, 10, 1, 2, 3, 6, 9, 7]
Source Link: https://leetcode.com/problems/rotate-array
-------------------------------------------------------------------------------------------------------
Time complexity : O(N) 
space complexity: O(Max of days) 
Approach:
Did this code run successfully in leet code : yes
problems faces : no*/

public class RotateArray {

    public void rotate(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k == 0)
            return;

        if (k > nums.length) {
            k = k % nums.length; // if the k is bigger than array length , first n rotations doesnt have any effect on the array positions
        }

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    private void reverse(int[] nums, int i, int j) {

        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

}
