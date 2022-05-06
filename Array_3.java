# Array-3

## Problem1 Trap Rain Water (https://leetcode.com/problems/trapping-rain-water/)
//Time complexity : O(n^2)
//Space complexity : O(1)
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int result = 0;
        int h = height.length;
        int l = 0;  int r = h-1;
        int lw = 0; int rw = 0;
        while(l <= r) {
            if(lw <= rw) {
                if(height[l] < lw)
                    result += lw - height[l];
                else
                    lw = height[l];
                l++;
            }
            else{
                if(height[r] < rw)
                    result += rw - height[r];
                else
                    rw = height[r];
                r--;
            }
        }
        return result;
    }
}

## Problem2 H-Index (https://leetcode.com/problems/h-index/)
//Time complexity : O(n)
//Space complexity : O(n)
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int[] buckets = new int[n+1];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            if(citations[i] < n)
                buckets[citations[i]]++;
            else
                buckets[n]++;
        }
        for(int i = n; i >= 0; i--) {
            sum += buckets[i];
            if(sum >= i)
                return i;
        }
        return 0;
    }
}

## Problem3  Rotate Array by K Places(https://leetcode.com/problems/rotate-array/)
//Time complexity : O(n)
//Space complexity : O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(nums == null || nums.length < 2 || k == 0 || k%n == 0) return;
        if(k > n)
            k = k % n;
        reverse(nums, 0, n-1-k);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);
    }
    private void reverse(int[] nums, int l, int r) {
        while(l < r) {
            swap(nums, l, r);
            l++;  r--;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp;
        temp  = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

