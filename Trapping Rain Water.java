// Time Complexity : O(n)
// Space Complexity : O(1)
// Method used : Two pointers

class Solution {
    public int trap(int[] height) {
        
        int length = height.length;
        int left_max, right_max, count, left_index, right_index;
        left_max = right_max = count = left_index = 0;
        right_index = length - 1;

        while(left_index < right_index)
        {
            if(height[left_index] <= height[right_index])
            {
                left_max = Math.max(left_max, height[left_index]);

                count += left_max - height[left_index];
                ++left_index;
            }
            else
            {
                right_max = Math.max(right_max, height[right_index]);

                count += right_max - height[right_index];
                --right_index;
            }
        }

        return count;
    }
}