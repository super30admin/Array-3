// Time Complexity: O(n)
// Space Complexity: O(1)


class Solution1 {
    public int trap(int[] height) {
        int result = 0;
        int n = height.length;
        int left_max = 0;
        int right_max = 0;
        int left = 0;
        int right = n-1;
        while( left < right) {
            if( height[left] < height[right] ) {
                if( height[left] >= left_max ) {
                    left_max = height[left];
                } else {
                    result = result + (left_max-height[left]);
                }
                left++;
            } else {
                if( height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    result = result + (right_max-height[right]);
                }
                right--;
            }
        }
        return result;
    }
}