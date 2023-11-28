// Time Complexity : O(N)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k>n){
            k=k%n;
        }
        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
    }
    private void reverse(int[] arr, int start, int end){
        while(start<end){
            swap(arr,start,end);
            start++;
            end--;
        }
       
    }
    private void swap(int[]arr,int l, int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}