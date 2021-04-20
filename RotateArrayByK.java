//tc : O(n); n = len of array
//sc : O(1)
public class RotateArrayByK {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;

        //check if k exceeds the len of arr
        k = k % nums.length;

        reverse(nums, 0, nums.length -1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    private void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

       // if no need to use temp variable then
       // a = a + b;
       // b = a - b;
       // a = a - b;

    }
}
