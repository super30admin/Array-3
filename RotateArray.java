// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Reversing all, then, 0-k-1 and k-n-1
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length <2 || k==0) return;
        int n = nums.length;
        if(k>n){
            k=k%n;
        }
        
        reverse(nums, 0, n-1);
        reverse(nums, 0,k-1);
        reverse(nums, k, n-1);
    }
    
    private void reverse(int a[], int l, int r){
        while(l<r){
            swap(a, l, r);
            l++;
            r--;
                
        }
    }
    
    private void swap(int a[], int l, int r){
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }
    
    // 1 2 3 4 5  Original
    // 5 4 3 2 1  reverse all
    // 2 3 4 5 1  reverse 0 - k-1
    // 2 3 4 5 1  reverse k - n-1
}


