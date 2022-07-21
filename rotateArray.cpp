// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Perform reverse operation 3 times.
 *  1. Reverse whole array.
 *  2. Reverse first k elements.
 *  3. Reverse remaining elements. 
 */

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        
        if (nums.size() == 0 || k == 0)
        {
            return;
        }
        
        int n = nums.size();
        k = k % n;
        
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    
    void reverse(vector<int>& nums, int l, int h)
    {
        while (l < h)
        {
            swap(nums[l], nums[h]);
            l++;
            h--;
        }
    }
};