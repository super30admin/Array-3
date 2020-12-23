// Two pointer solution
// Time Complexity: O(n) n = size of height vector
// Space Complexity: O(1)
class Solution {
public:
    int trap(vector<int>& height) {
        int left = 0;
        int right = height.size()-1;
        int left_max = 0;
        int right_max = 0; 
        int res = 0;
        while(left < right) {
            if(height[left] < height[right]) {
                if(height[left] >= left_max) {
                    left_max = height[left];
                }
                else {
                    res += left_max - height[left];
                }
                left++;
            }
            else {
                if(height[right] >= right_max) {
                    right_max = height[right];
                }
                else {
                    res += right_max - height[right];
                }
                right--;
            }
        }
        return res;
    }
};
