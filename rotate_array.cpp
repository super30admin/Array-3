// Time Complexity : O(n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this -

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        
        int len = nums.size();
        
        int shift = k % len;
        
        int i, j;
        
        j = 0; 
        i = shift;
        
        vector<int> ret(len, 0);
        
        while(len - i < len)
        {
            ret[j] = nums[len - i];
            
            i--;
            j++;
        }
        
        i = 0;
        
        while(len - j > 0)
        {
            ret[j] = nums[i];
            i++;
            j++;
        }
        
        nums = ret;
    }
};