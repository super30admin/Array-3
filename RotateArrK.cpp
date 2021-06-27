// Time Complexity :O(n) where n in the number elements in the vector
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int sz = nums.size();
        k=k%sz;
        reverse(nums.begin(),nums.end());
        reverse(nums.begin() + k,nums.end());
        reverse(nums.begin(),nums.begin() + k);
    }
};