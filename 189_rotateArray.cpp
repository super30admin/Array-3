// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if(nums.empty() || nums.size() == 0)
            return;
        int n = nums.size();
        if(k>n)
            k = k % n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    
    void reverse(vector<int>& nums, int l, int r){
        while(l<r){
            swap(nums, l, r);
            l++;
            r--;
        }
    }
    
    void swap(vector<int>& nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
};
