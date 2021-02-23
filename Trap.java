// Time Complexity : The time complexity is O(n) where n is the length of array
// Space Complexity : The space complexity if O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int trap(int[] height) {

        int n = height.length;

        if(n == 0){
            return 0;
        }

        int res = 0;

        int left = 0;
        int right = n-1;

        int lw = 0;
        int rw = 0;

        while(left <= right){

            // Process the left wall
            if(lw <= rw){
                // water can be trapped if the left wall is greater than current left pointer
                if(lw > height[left]){
                    res += (lw - height[left]);
                }
                else{
                    lw = height[left];
                }
                left++;
            }
            // process the right wall
            else{
                // water can be trapped if the right wall is greater than current right pointer
                if(rw > height[right]){
                    res += (rw - height[right]);
                }
                else{
                    rw = height[right];
                }
                right--;
            }
        }

        return res;

    }
}