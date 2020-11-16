//time complexity:O(n)
//space complexity:O(1)
//executed on leetcode: yes
//approach:using 2 pointers
//any issues faced? no

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int n=nums.size();
        k=k%n;
        rot(nums,0,n-1);
        rot(nums,0,k-1);
        rot(nums,k,n-1);
    }
    void rot(vector<int>& nums, int l, int r)
    {
        while(l<r)
        {
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
    }
};