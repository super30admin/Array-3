//Time Complexity: O(n)
//Space Complexity: O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        //Validate the input array -  [1, 2, 3, 4, 5, 6, 7]
        if (nums == null || nums.length <= 1)
            return;

        int n = nums.length;
        k = k % n;
        if (k == 0)
            return; // nothing to do

        //Reverse the entire array - [7, 6, 5, 4, 3, 2, 1]
        reverse(0, n - 1, nums);

        //Reverse the first part of array until k elements - [5, 6, 7, 4, 3, 2, 1]
        reverse(0, k - 1, nums);

        //Reverse the rest of the array
        reverse(k, n - 1, nums);
    }

    private void reverse(int i, int j, int[] arr) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
            i++;
        }
    }
}