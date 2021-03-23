//Time complexity-O(n)
//Space complexity-O(1)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=(k%n);
        reverse(nums,0,n-k);//at k the array is reversed
        reverse(nums,n-k,n);//remaning elements are also reversed
        reverse(nums,0,n);//final array is reversed 
    }
    
    public void reverse(int[] nums, int start, int end){//logic to reverse the array from start to end
        end-=1;
        while(start<=end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
    
    
}