// TC: O(n)
// SC: O(n)


// We rotate parts of the array one by one and then rotate the entire array in the end. EVERYTHING INPLACE.
// First we can rotate 0 to n-k-1 elements
// Then we rotate n-k to n-1 elements 
// Finally rotate the entire array
// Reverse function is basically using two pointers, left and right which move by swapping two elements until left and right pointer meet


class Solution {
    public void rotate(int[] nums, int k) {
        if(nums ==null || nums.length==0) return;
        int n=nums.length;
        if(k>n){
            k=k%n;
        }
        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
    }
    
    public void reverse(int[] nums, int left, int right){
        while(left<=right){
            swap(nums,left,right);
            left++; right--;
        }
    }
    
    
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}