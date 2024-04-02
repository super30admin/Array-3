// Time Complexity : O(nk)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : no, TLE
// Three line explanation of solution in plain english  : keep shifting the last element to the front k times

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k %= n;

        for(int i = 0 ; i < k; i++){
            int prev = nums[n-1];
            for(int j = 0 ; j < n ;j++){
                int temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }
    }
}

// Time Complexity : O(2n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : no, TLE
// Three line explanation of solution in plain english  : keep shifting the last element to the front k times

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k %= n;
        
        //Approach 1:

        // //reverse n elements, then first k elements, then rest of the elements
        reverse(nums,0,n-1);
        reverse(nums, 0 , k-1);
        reverse(nums, k , n-1);

        //Approach 2:

        
        // reverse(nums, 0 , n-k-1);
        // reverse(nums, n-k , n-1);
        // reverse(nums,0,n-1);
    }

    private void reverse(int[] nums, int l , int r){
        while( l < r){
            swap(nums,l,r);
            l++;
            r--;
        }
    }

    private void swap(int[] arr, int l, int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}