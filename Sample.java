// # Array-3

// ## Problem1 Trap Rain Water (https://leetcode.com/problems/trapping-rain-water/)

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int result = 0;
        int max = 0;
        int maxIdx = 0;
        for(int i=0; i<n; i++){
            if(max < height[i]){
                max = height[i];
                maxIdx = i;
            }
        }
        int lw = 0;
        int lp = 0;
        while(lp < maxIdx){
            if(lw <= height[lp]){
                lw = height[lp];
            }else{
                result += (lw - height[lp]);
            }
            lp++;
        }

        int rw = 0;
        int rp = n-1;
        while(rp > maxIdx){
            if(rw <= height[rp]){
                rw = height[rp];
            }else{
                result += (rw - height[rp]);
            }
            rp--;
        }
        return result;
    }
}

// ## Problem2 H-Index (https://leetcode.com/problems/h-index/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int [] buckets = new int[n+1];
        for(int i=0; i<n ; i++){
            if(citations[i] >= n){
                buckets[n]++;
            }else{
                buckets[citations[i]]++;
            }
        }
        int sum = 0;
        for(int i=n; i>=0; i--){
            sum += buckets[i];
            if(sum >= i){
                return i;
            }
        }
        return -1;
    }
}

// ## Problem3  Rotate Array by K Places(https://leetcode.com/problems/rotate-array/)
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) return;
        int n =nums.length;
        if(k>n){
            k = k%n;
        }
        reverse(nums, 0, n-k-1);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);
    }
    private void reverse(int [] nums, int left, int right){
        while(left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}