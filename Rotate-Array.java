## Problem3  Rotate Array by K Places(https://leetcode.com/problems/rotate-array/)

//In this question we have to rotate a array by k places from right
//Approach 1 : Bruteforce
In this we will iterate through an array k times and take last element in temp variable and then shift the elements. Do this k times
Time Complexity : O(nk)
Space Complexity : O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return;
        }
        k=k%nums.length;
        if(k==0){
            return;
        }
        int n=nums.length;
        for(int i=0;i<k;i++){
            int temp=nums[n-1];
            for(int j=n;j>1;j--){
                nums[j-1]=nums[j-2];
            }
            nums[0]=temp;
            System.out.println(Arrays.toString(nums));
        }
    }
}

//Approach 2
In this approach I am taking an extra space of int array type and copying last k elements into it
then I am moving starting n-k elements to the end and then copying back the elements which we added in array

Time Complexity : O(n)
Space Complexity : O(k)

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return;
        }
        k=k%nums.length;
        if(k==0){
            return;
        }
        int n=nums.length;
        int[] elements = new int[k];
        for(int i=0;i<k;i++){
            elements[i]=nums[n-i-1];
        }
        for(int i=1;i<=n-k;i++){
            nums[n-i]=nums[n-k-i];
        }
        int el=elements.length;
        for(int i=0;i<k;i++){
            nums[i]=elements[el - i-1];
        }
    }
}

//approach - 3
In this approach we are reversing an complete array first, then we are reversing 0 to k-1 elements and then k to n-1 elements
Time Complexity = O(n)
Space Complexity = O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return;
        }
        k=k%nums.length;
        if(k==0){
            return;
        }
        int n=nums.length;
        nums=swap(nums,0,n-1);
        nums=swap(nums,0,k-1);
        nums=swap(nums,k,n-1);
    }
    private int[] swap(int[] nums, int left, int right){
        while(left<right){
            int temp = nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
        return nums;
    }
}