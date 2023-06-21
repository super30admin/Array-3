## Problem1 Trap Rain Water (https://leetcode.com/problems/trapping-rain-water/)

// Time Complexity - 0(n)
// Space Complexity - 0(1)

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int lw = 0;
        int rw = 0;
        int l = 0;
        int r = n - 1;
        int total = 0;

        while (l <= r) {
            if (lw <= rw) {
                if (lw >= height[l]) {
                    total = total + (lw - height[l]);
                }
                else {
                    lw = height[l];
                }
                l++;
            }
            else {
                if (rw >= height[r]) {
                    total = total + (rw - height[r]);
                }
                else {
                    rw = height[r];
                }
                r--;
            }
        }
        return total; 
    }
}


## Problem2 H-Index (https://leetcode.com/problems/h-index/)

// Time Complexity - 0(n)
// Space Complexity - 0(n)

class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int[] dp = new int[n + 1];

        for (int i = 0; i <citations.length; i++) {
            int index = citations[i];
            if (index >= n) {
                dp[n]++;
            }
            else {
                dp[index]++;
            }
        }
        int rSum = 0;
        for (int i = n; i >= 0; i--) {
            rSum = rSum + dp[i];
            if (rSum >= i) {
                return i;
            }
        }
        return -1;
    }
}


## Problem3  Rotate Array by K Places(https://leetcode.com/problems/rotate-array/)

// Time Complexity - 0(nk)
// Space Complexity -  0(1)

class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        if (k > n) {
            k = k % n;
        }
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);       
    }
    private void reverse(int[] nums, int l, int r) {
        while (l <= r) {
            swap(nums, l , r);
            l++;
            r--;
        }
    }
    private void swap(int[]nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}

