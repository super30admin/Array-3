/*time complexity O(n)
space complexity O(1)
approach: reverse the array and now reverse first k elements and next n-k elements */


class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        if(k>=n){
            k=k%n;
        }
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    private void reverse(int[] nums,int l, int r){
        while(l<r){
            swap(nums,l,r);
            l++;r--;
        }
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}