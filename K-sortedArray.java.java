// Time Complexity : O(n) n no.of elements in the height array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
Reversed the whole array.
reverse the first n-k elements and then reverse the next k elements


class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        if(nums==null){
            return;
        }
        if(k>n){
            k=k%n;
        }
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    private void reverse(int[] nums, int s,int e){
        while(s<e){
            swap(nums,s,e);
            s++;e--;
        }
    }
    private void swap(int[] nums, int i,int j){
        if(i!=j){
            nums[i] = nums[i] + nums[j];
            nums[j] = nums[i] - nums[j];
            nums[i] = nums[i] - nums[j];
        }
        
    }
}