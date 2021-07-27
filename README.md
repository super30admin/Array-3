# Array-3

## Problem1 Trap Rain Water (https://leetcode.com/problems/trapping-rain-water/)

//Time Complexity = O(N)
//Space Complexity = O(1)
class Solution {
    public int trap(int[] height) {
        if(height == null) return 0;
        int lw = 0; int l = 0; 
        int rw = 0; int r = height.length - 1;
        int result = 0; 
        
        while(l <= r){
            if(lw <= rw){
                if(lw > height[l]){
                    result = result + (lw - height[l]);
                }else{
                    lw = height[l];
                }
                l++;
            }
            else{
                if(rw > height[r]){
                    result = result + (rw - height[r]);
                }else{
                    rw = height[r];
                }
                r--; 
            } 
        }
        return result;
    }
}

## Problem2 H-Index (https://leetcode.com/problems/h-index/)

//Time Complexity = O(n)
//Space Complexity = O(n)

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length; 
        int[] arr = new int[n+1]; 
        
        for(int i = 0; i < n; i++){
            if(citations[i] >= n){
                arr[n] = arr[n] + 1; 
            }else{
                arr[citations[i]] += 1; 
            }
        }
        int sum = 0;
        for(int i = n; i >= 0; i--){
           sum = sum + arr[i]; 
           if(sum >= i) return i; 
        }
        
        return -1;
    }
}

## Problem3  Rotate Array by K Places(https://leetcode.com/problems/rotate-array/)

//Time Complexity = O(n)
//Space Complexity = O(1)
class Solution{
    public void rotate(int[] nums, int k) {
        if(nums == null) return;
        int n = nums.length;
        if(k >= n) k = k % n; 
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k , n - 1);
    }
    
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums,start,end); 
            start++;
            end--; 
        }
    }
    
    private void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end]; 
        nums[end] = temp; 
    }
}