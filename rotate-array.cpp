// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

#include <vector> 

using namespace std;

class Solution {
public:
    void rotate(std::vector<int>& nums, int k) {
        if (k == 0) {
            return;
        }

        if (nums.size() == 1) {
            return;
        }

        k %= nums.size();

        reverse(nums, 0, nums.size() - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.size() - 1);
    }

private:
    void reverse(std::vector<int>& nums, int low, int high) {
        while (low <= high) {
            std::swap(nums[low], nums[high]);
            low++;
            high--;
        }
    }
};
