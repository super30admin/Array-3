// Time Complexity: O(n)
// Space Complexity: O(1)
// Did the code run successfully? Yes

// Approach:
// 1. We will use the reverse function to reverse the entire array.
// 2. Then we will reverse the first k elements of the array.
// 3. Reverse the remaining n-k elements of the array.

class Solution {
    public:
        void rotate(vector<int>& nums, int k) {
            int n = nums.size();
            k = k % n;
            reverse(nums.begin(), nums.end());
            reverse(nums.begin(), nums.begin() + k);
            reverse(nums.begin() + k, nums.end());
    
        }
    };