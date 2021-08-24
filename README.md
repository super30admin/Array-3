# Array-3

## Problem1 Trap Rain Water (https://leetcode.com/problems/trapping-rain-water/)

//Time Complexity = O(N)
//Space Complexity = O(1)

class Solution {
public int trap(int[] height) {
if(height == null || height.length <= 2) {
return 0;
}

        int lw = 0;
        int l = 0;
        int rw = 0;
        int r = height.length-1;
        int result = 0;

        while(l <= r) {
            if(lw <= rw) {
                if(height[l] < lw) {
                    result += lw - height[l];
                } else {
                    lw = height[l];
                }
                l++;
            }  else {
                if(height[r] < rw) {
                    result += rw - height[r];
                } else {
                    rw = height[r];
                }
                r--;
            }
        }
        return result;
    }

}

## Problem2 H-Index (https://leetcode.com/problems/h-index/)

//Time Complexity = O(N)
//Space Complexity = O(N)

class Solution {
public int hIndex(int[] citations) {
if(citations == null || citations.length == 0) {
return 0;
}
int n = citations.length;
int[] buckets = new int[n + 1];

        for(int i = 0; i < n ; i++) {
            if(citations[i] > n) {
                buckets[n]++;
            } else {
                buckets[citations[i]]++;
            }
        }

        int papers = 0;
        for(int i = n; i >= 0; i--) {
            papers += buckets[i];
            if(papers >= i) {
                return i;
            }
        }
        return 0;
    }

}

## Problem3 Rotate Array by K Places(https://leetcode.com/problems/rotate-array/)

//Time Complexity = O(N)
//Space Complexity = O(1)

class Solution {
public void rotate(int[] nums, int k) {
if(nums == null || nums.length == 0) {
return;
}
int n = nums.length;
k = k % n;
reverse(nums, 0, n-1);
reverse(nums, 0,k-1);
reverse(nums, k,n-1);

    }

    private void reverse(int[] nums, int low, int high) {
        while(low < high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }

}
