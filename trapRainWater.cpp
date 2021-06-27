// Time Complexity :O(n) where n in the number elements in the vector
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int trap(vector<int>& height) {
        int left = 0;
        int right = height.size()-1;
        int rWall = 0;
        int lWall = 0;
        int trap = 0;
        while(left <= right){
            if(lWall <=rWall){
                if(lWall < height[left]) lWall = height[left];
                else trap+= 1 * (lWall - height[left]);
                left++;
            }
            else{
                if(rWall < height[right]) rWall = height[right];
                else trap+= 1 * (rWall-height[right]);
                right--;
            }
        }
        return trap;
    }
};