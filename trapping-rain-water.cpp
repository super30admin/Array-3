// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int trap(std::vector<int>& height) {
        int i = 0;
        int j = height.size() - 1;

        if (height.empty()) {
            return 0;
        }

        int leftmax = 0;
        int rightmax = 0;
        int count = 0;

        while (i < j) {
            leftmax = std::max(leftmax, height[i]);
            rightmax = std::max(rightmax, height[j]);

            if (leftmax < rightmax) {
                count += (leftmax - height[i]);
                i++;
            } else {
                count += (rightmax - height[j]);
                j--;
            }
        }

        return count;
    }
};
