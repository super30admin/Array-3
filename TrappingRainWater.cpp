// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int trap(vector<int>& height) {
        int lw=0,rw=0;
        int l=0,r=height.size()-1;
        int res=0;
        while(l<=r){
            if(lw<=rw){
                if(lw>height[l]){
                    res = res + (lw-height[l]);
                }else{
                    lw = height[l];
                }l++;
            }
            else{
                if(rw>height[r]){
                    res = res + (rw-height[r]);
                }else{
                    rw = height[r];
                }r--;   
            }  
        }
        return res;
        }
        
};
