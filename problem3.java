    /**
    Time Complexity : O(N)
    Explanation:
    Array is reversed three times and each reverse operation takes O(N).

    Space Complexity : O(1)
    Explanation:
    Rotation is done in-place without using extra space.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially forgot to handle cases where k is greater than array length.
    Fixed it using k % length.
    Also had confusion about the order of reversing but later understood
    the correct sequence:
    1. Reverse entire array
    2. Reverse first k elements
    3. Reverse remaining elements
    */
    class Solution {
        public void rotate(int[] nums, int k) {
    
            int l = nums.length;
    
            // Handle k greater than length
            if (k > l) {
                k = k % l;
            }
    
            // Step 1: Reverse whole array
            reverse(nums, 0, l - 1);
    
            // Step 2: Reverse first k elements
            reverse(nums, 0, k - 1);
    
            // Step 3: Reverse remaining elements
            reverse(nums, k, l - 1);
        }
    
        private int[] reverse(int[] nums, int l, int r) {
    
            while (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
            return nums;
        }
    }