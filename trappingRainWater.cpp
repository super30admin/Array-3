//time complexity:O(n)
//space complexity:O(1)
//executed on leetcode: yes
//approach:using 2 pointers
//any issues faced? no

class Solution {
public:
    int trap(vector<int>& height) {
        int l=0;
        int r=height.size()-1;
        int lmax=0;
        int rmax=0;
        int ar=0;
        while(l<r)
        {
            if(height[l]<height[r])
            {
                if(height[l]>=lmax)
                    lmax=height[l];
                else
                    ar+=(lmax-height[l]);
                l++;
            }
            else
            {
                if(height[r]>=rmax)
                    rmax=height[r];
                else
                    ar+=(rmax-height[r]);
                r--;
            }
        }
        return ar;
    }
};