
42. Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.


TC O(n)
SC O(1)


class Solution {
public:
    int trap(vector<int>& height) {

        int n = height.size();
        int lw = 0; //left wall
        int rw = 0; // right wall
        int l =0; //left index
        int r = n-1; // right index
        int result = 0;

        while (l <= r) {
            if (lw <= rw) {
                if (lw > height[l]) {
                    result = result + (lw - height[l]);
                } else {
                    lw = height[l];
                }
                l++;                     
            } else {
                if (rw > height[r]) {
                    result = result + (rw - height[r]);
                } else {
                    rw = height[r];
                }
                r--;                
            }
        }
        return result;        
    }
};






