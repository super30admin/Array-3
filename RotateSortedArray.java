/*
 * TC: O(n)
 * SC: O(1)
 */
public class RotateSortedArray {
    public void rotate(int[] nums, int k) {
        int l = nums.length;
        k = k % l;                 //take a modulus to avoid multiple rotations when k >= l
        if (k == 0) return;
        reverse(nums, 0, l - 1); //reverse the entire array                     [e d c b a]
        reverse(nums, 0, k - 1); //reverse the first k elements     (k = 2)     [d e c b a]
        reverse(nums, k, l - 1); //reverse the last l - k elements  (l - k = 3) [d e a b c]
    }

    public void reverse(int[] arr, int beg, int end) {
        while(beg < end) {
            swap(arr, beg++, end--);
        }
    }

    private void swap(int[] arr, int beg, int end) {
        int tmp = arr[beg];
        arr[beg] = arr[end];
        arr[end] = tmp;
    }
}
