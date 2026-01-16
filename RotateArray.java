// Approach 3: Reverse the whole array, reverse from 0 to k - 1 and reverse from k, n - 1.
// TC: O(N)
// SC: O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int n = nums.length;
        reverse(nums, 0, n - 1); // 7, 6, 5, 4, 3, 2, 1
        reverse(nums, 0, k - 1); // 5, 6, 7, 4, 3, 2, 1
        reverse(nums, k, n - 1); // 5, 6, 7, 1, 2, 3, 4
    }

    private void reverse(int[] nums, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            swap(nums, startIndex, endIndex);
            startIndex ++;
            endIndex --;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// Approach 2: One pass
// TC: O(N)
// SC: O(N)
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int[] tempNums = new int[nums.length];
        int tempIndex = 0;
        // copy last k elements from nums
        for (int i = k; i > 0; i --) {
            tempNums[tempIndex ++] = nums[nums.length - i];
        }
        // copy first N - k elements from nums
        for (int i = 0; i < nums.length - k; i ++) {
            tempNums[tempIndex ++] = nums[i];
        }
        // copy elements from tempNums to nums
        for (int i = 0; i < nums.length; i ++) {
            nums[i] = tempNums[i];
        }
    }
}

// Approach 1: Brute force (Time Limited Exceeded)
// TC: O(Nk)
// SC: O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        // rotate the array k times
        while (k -- != 0) {
            int lastNum = nums[nums.length - 1];
            // Copy the elements
            for (int j = nums.length - 2; j >= 0; j --) {
                nums[j + 1] = nums[j];
            }
            nums[0] = lastNum;
        }
    }
}