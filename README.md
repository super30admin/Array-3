# Array-3

## Problem1 Trap Rain Water (https://leetcode.com/problems/trapping-rain-water/)

Explain approach in 3 lines: We will use two pointers l and r to traverse the height array from both ends maintaining leftwall and rightwall to store the maximum heights we got from far on left and far on the right. Then we will accumulate water by comparing current height with respective wall heights and we will move the pointers inwards. We will continue this process until the two pointers meet and we will return the total water captured.

Time Complexity: O(n) as we are iterating through height array using two pointers

Space Complexity: O(1) as we are not using any auxillary space

Approached Code: 

class Solution {
    public int trap(int[] height) {
        
        int n = height.length;

        // Taking maximum element as a wall Solution

        // int max = height[0];
        // int maxIdx = 0;

        // for(int i = 1; i < n; i++) {
        //     if(height[i] > max) {
        //         max = height[i];
        //         maxIdx = i;
        //     }
        // }

        // int result = 0;
        // int l = 0;

        // for(int i = 1; i < maxIdx; i++) {
        //     if(height[i] < height[l]) {
        //         result = result + (height[l] - height[i]);
        //     } else {
        //         l = i;
        //     }
        // }

        // int r = n-1;

        // for(int i = n-2; i > maxIdx; i--) {
        //     if(height[i] < height[r]) {
        //         result = result + (height[r] - height[i]);
        //     } else {
        //         r = i;
        //     }
        // }



        // taking left wall and right wall solution

        int leftWall = 0;
        int l = 0;

        int rightWall = 0;
        int r = n-1;

        int result = 0;

        while(l <= r) {
            if(leftWall <= rightWall) {

                if(leftWall > height[l]) {
                    result = result + (leftWall - height[l]);
                } else {
                    leftWall = height[l];
                }

                l++;

            } else {

                if(rightWall > height[r]) {
                    result = result + (rightWall - height[r]);
                } else {
                    rightWall = height[r];
                }

                r--;

            }
        }

        return result;

    }
}



## Problem2 H-Index (https://leetcode.com/problems/h-index/)

Explain approach in 3 lines: First we will count the number of papers with each citation count using auxillary array. Then we will traverse through the auxillary array in the reverse to find the highest citation count i where there are at least i papers with i or more citations. Then we will return this i as H-index. We can sort the array and then perform the similary operations but sorting takes nlong time.

Time Complexity: O(n) as we are iterating over rhe citations array and then auxillary array where n is length of the citations array.

Space Complexity: O(n) as we are using the auxillary array to store number of citations greater than the index number.

Approached Code: 

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;

        // Arrays.sort(citations);

        // for(int i = 0; i < n; i++) {
        //     int temp = n - i;

        //     if(temp <= citations[i]) {
        //         return temp;
        //     }
        // }


        int[] arr = new int[n+1];

        for(int i = 0; i < n; i++) {
            if(citations[i] >= n) {
                arr[n]++;
            } else {
                arr[citations[i]]++;
            }
        }

        int temp = 0;

        for(int i = n; i >= 0; i--) {
            temp = temp + arr[i];

            if(temp >= i) {
                return i;
            }
        }

        return 0;
    }
}



## Problem3  Rotate Array by K Places(https://leetcode.com/problems/rotate-array/)

Explain approach in 3 lines: The main approach here is first we will reverse the whole array. Once we have reversed array then we will reverse first k elements and then we will reverse all other elements in an array. Suppose array is of length n then we will reverse 0 to k-1 elements subarray first and then we will reverse the k to n-1 elements subarray.

Time Complexity: O(n) where n is length of array as we will be going over array to reverse it.

Space Complexity: O(1) as we are not using any extra space in this algorithm.

Approached Code: 

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k = k % n;

        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);

    }

    private void reverse(int[] nums, int l, int r) {
        while(l < r) {
            int temp = nums[l]; 
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}


