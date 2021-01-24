//Time - O(n)
//Space - O(1)
class Solution {
public:
    int trap(vector<int>& height) {
        int l = 0,r = height.size()-1;
        int lmax = -1,rmax = -1, ans = 0;
        
        while(l<=r){
            if(height[l]<height[r]){
                if(height[l]>=lmax){
                    lmax = height[l];
                }else{
                    ans += (lmax-height[l]);
                }
                l++;
            }else{
                if(height[r]>=rmax){
                    rmax = height[r];
                }else{
                    ans += (rmax-height[r]);
                }
                r--;
            } 
        }
        
        return ans;
    }
};