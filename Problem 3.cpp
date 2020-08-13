//Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    void reverse(vector<int>& nums, int st, int end){
        while(st<=end){
            int temp = nums[st];
            nums[st] = nums[end];
            nums[end] = temp;
            st++;
            end --;
        }
        
    }
    
    //optimal method
    //O(n) time and O(1) space
    void rotate(vector<int>& nums, int k) {
        if(nums.size()<2) return;
        if(k>nums.size()) k = k%nums.size();
        //reverse the entire array
        reverse(nums, 0, nums.size()-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.size()-1);
        
    }
};