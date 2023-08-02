import java.util.Scanner;

public class RotateArrayRightReverses {

        // RIGHT ROTATE - REVERSES - TIME O(N) AND SPACE O(1)

        public void rotate(int[] nums, int k) {

            if(nums == null)       return;

            int n = nums.length;

            if(k > n) {

                // remainder indicates effective number of rotations required
                k %= n;
            }

            // reverse whole array first, then reverse first k elements and then reverse the rest
            reverse(nums, 0, n-1);
            reverse(nums, 0, k-1);
            reverse(nums, k, n-1);

        /* alternative right rotation - reverse until the last k elements first, then reverse the last k, and finally reverse the whole array
        reverse(nums, 0, n-k-1);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);*/

            /* for left rotation
             reverse(nums, 0, k-1);
             reverse(nums, k, n-1);
             reverse(nums, 0, n-1); */
        }

        // reverse function
        private void reverse(int[] arr, int left, int right) {    // O(N)

            while(left <= right) {

                // reverse edges pair-wise
                swap(arr, left, right);

                // move inward
                left++; right--;
            }
        }

        // swap function
        private void swap(int[] arr, int i, int j) {

            int temp = arr[i];

            arr[i] = arr[j];

            arr[j] = temp;
        }

    public static void main(String[] args) {

        RotateArrayRightReverses obj = new RotateArrayRightReverses();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Right rotation factor: ");
        int k = scanner.nextInt();

        System.out.println("Array length: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];

        System.out.println("Array: ");
        for(int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Rotated array: ");

        obj.rotate(nums, k);

        for(int num: nums) {
            System.out.print(num + " ");
        }
    }
    
}


/*
TIME COMPLEXITY = O(N)

reversal method takes O(2N) time

SPACE COMPLEXITY = O(1)

no extra space
*/