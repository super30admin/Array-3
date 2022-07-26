// approch 1
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2
// Time Complexity : O(nk)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 3
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.Arrays;

class Main {

    // approch 1 using extra array
    public static void rotate1(int[] nums, int k) {
        // null case
        if (nums == null || nums.length == 0)
            return;
        int n = nums.length;
        // temp array for rotating
        int[] temp = new int[n];
        // first pass
        // here I will add element in array in two partition
        // start with 0th index to the kth index after that remaming element from the
        // kth index
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }
        // second pass copy temp into nums
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }

    // approch 2 rotate element one by one (TLE)
    public static void rotate2(int[] nums, int k) {
        // null case
        if (nums == null || nums.length == 0)
            return;
        int n = nums.length;
        k = k % n;
        // here I will rotate element by one by one k times
        for (int i = 0; i < k; i++) {
            // store last element in temp;
            int temp = nums[n - 1];
            // rotate right
            for (int j = n - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            // here I will make last element to first
            nums[0] = temp;
        }
    }

    // approch 3 using reverse array
    public static void rotate3(int[] nums, int k) {
        // null case
        if (nums == null || nums.length == 0)
            return;
        int n = nums.length;
        k = k % n;
        // reverse whole array
        reverse(nums, 0, n - 1);
        // reverse 0 -> k-1
        reverse(nums, 0, k - 1);
        // reverse k -> n
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i <= j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        rotate1(nums, k);
        System.out.println(Arrays.toString(nums));
        nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        rotate2(nums, k);
        System.out.println(Arrays.toString(nums));
        nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        rotate3(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}