// Approach : Using Reverse - Rotate to right k times
// Time : O(n) - reversed a total of 3 times
// Space : O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        // edge case
        if(nums == null || nums.length < 2) return;
        int n = nums.length;
        if(k>n){
            k=k%n;
        }
        reverse(nums,0,n-1);// whole array is reversed
        reverse(nums,0,k-1); // first part of array 0 to k-1
        reverse(nums,k,n-1); // second part of array k to n-1

    }
    private void reverse(int[] nums,int l ,int r){
        while(l<r){
            swap(nums,l,r);
            l++;
            r--;
        }
    }

    private void swap(int[] nums,int i ,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j] = temp;
    }
}

// Approach : Brute Force - Time Limit exceeded
// Time : O(nk)
// Space : O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length < 2) return;
        int n = nums.length;
        k = k %n;
        for(int i =0;i<k;i++){
            int popped = nums[nums.length-1];
            for(int j = 0;j<nums.length;j++){
                int temp = nums[j];
                nums[j]=popped;
                popped= temp;
            }
        }
    }
}

// Approach : Using Reverse - Rotate k times left (left rotation)
// Time : O(n) // reverse the elements three times
// Space : O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length < 2) return;
        int n = nums.length;
        if(k>n){
            k = k %n;
        }
        reverse(nums,0,n-1); // reverse the whole array
        reverse(nums,0,n-k-1); // first portion of array
        reverse(nums,n-k,n-1); // second portion of array
    }
    public void reverse(int[] nums,int l , int r){
        while(l<r){
            swap(nums,l,r);
            l++;
            r--;
        }

    }
    public void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}