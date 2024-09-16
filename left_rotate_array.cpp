//Time Complexity=O(n)
//Space Complexity=O(1)
//Ran successfully on leetcode

class Solution {
public:
    /*Here we do a right rotation by reversing the first k elements and then n-k elements. If we have to rotate left, then we will reverse n-k and then k elements.*/
    void rotate(vector<int>& nums, int k) {
        if(nums.empty())
            return;
        int n=nums.size()-1;
        if(k>n)
            k=k%nums.size();
        reverse(nums,0,n);
        reverse(nums,0,k-1);
        reverse(nums,k,n);
    }
    void reverse(vector<int>&nums,int l,int r)
    {
        while(l<r)
        {
            swap(nums[l],nums[r]);
            l++;
            r--;
        }
    }
};