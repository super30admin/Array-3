/*
Time complexity: O(n)
Space complexity: O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/

class Solution 
    {
    public:
        void rotate(int nums[], int n, int k) 
        {
            k = k%n;
            reverse(nums, nums + n - k);
            reverse(nums + n - k, nums + n);
            reverse(nums, nums + n);
        }
};