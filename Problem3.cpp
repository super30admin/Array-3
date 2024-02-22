class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        vector<int>s(nums.size());

        for(int i = 0;i<nums.size() ; i++)
    {
        s[(i+k)%nums.size()] = nums[i];
    }
    nums = s;
        
    }
};