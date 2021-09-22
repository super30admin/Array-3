// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
public:
    int trap(vector<int>& height) {
        if(height.empty() || height.size() == 0)
            return 0;
        int n = height.size();
        int lw=0, rw=0;
        int l=0, r=n-1;
        int ans=0;
        while(l<=r){
            if(lw<=rw){
                if(height[l] < lw)
                    ans += 1*(lw - height[l]);
                else
                    lw = height[l];
                l++;
            }
            else{
                if(height[r] < rw)
                    ans += 1*(rw - height[r]);
                else
                    rw = height[r];
                r--;
            }
        }
        return ans;
    }
};

class Solution {
public:
    int trap(vector<int>& height) {
        if(height.empty() || height.size() == 0)
            return 0;
        int n = height.size();
        int lw=0, rw=0;
        int l=0, r=n-1;
        int ans=0;
        while(l<=r){
            if(lw<=rw){
                lw = max(lw, height[l]);
                ans += 1*(lw - height[l]);
                l++;
            }
            else{
                rw = max(rw, height[r]);
                ans += 1*(rw - height[r]);
                r--;
            }
        }
        return ans;
    }
};
