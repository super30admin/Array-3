// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int trap(vector<int>& height) {
        if(height.size()==0){
            return 0;
        }
        
        int result = 0;
        int n = height.size();
        int l=0, r = n-1;
        int lmax = 0, rmax = 0;
        while(l<=r){
            if(height[l]<height[r]){
                if(height[l] >= lmax){
                    lmax = height[l];
                }
                else{
                    result = result + lmax-height[l];
                }
                l++;
            }
            else{
                if(height[r]>=rmax){
                    rmax = height[r];
                }
                else{
                    result = result + rmax-height[r];
                }
                r--;
            }
        }
        return result;
    }
};
