// TC: O(n)
// SC: O(1)

public class RotateArray {
    public void reverseArray(int arr[], int i, int j) {
        while (i < j) {
            if (arr[i] != arr[j]) {
                arr[i] = arr[i] + arr[j];
                arr[j] = arr[i] - arr[j];
                arr[i] = arr[i] - arr[j];
            }
            i++;
            j--;
        }
    }

    public void rotate(int[] nums, int k) {
        int size = nums.length;
        k = k % size;
        if (k > 0) {
            reverseArray(nums, 0, size - 1);
            reverseArray(nums, 0, k - 1);
            reverseArray(nums, k, size - 1);
        }
    }
}
