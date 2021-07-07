// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Maintain four variables, 2 as left and right pointers and other 2 for max height of wall on left and right
// 2. While left pointer is less than right, if right pointer is taller then move left pointer 
// 3. But check if left pointer is taller than left wall then update left wall else store water
// 4. Repeat same for right pointer in case check 2 fails

class Solution {
public:
    int trap(vector<int>& height) {
        int left_max = 0, right_max = 0, left=0, right=height.size()-1, ans=0;
        while(left<right){
            if(height[left]<=height[right]){
                if(height[left]>=left_max)
                    left_max = height[left];
                else
                    ans+= left_max-height[left];
                left++;
            }
            else{
                if(height[right]>=right_max)
                    right_max = height[right];
                else
                    ans+=right_max-height[right];
                right--;
            }
        }
        return ans;
    }
};