// TC: O(n)
// SC: O(1)

// Approach: Take mod of k with size of array as anything more than length
// is extra repititons. Reverse the whole array and then reverse the first k
// and last n - k separately.

class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}