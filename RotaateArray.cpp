// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Reverse the whole array and reverse 2 sections in the array.

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if(nums.size()==0){
            return;
        }
        k = k % nums.size();
        reverse(nums,0,nums.size()-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.size()-1); 
    }
    
    void reverse(vector<int>& nums,int start,int end){
        while(start<=end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
};
