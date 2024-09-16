//Time Complexity=O(n)
//Space Complexity=O(1)
//Ran successfully on leetcode

class Solution {
public:
    int trap(vector<int>& height) {
        if(height.empty())
            return 0;
        int l=0,r=height.size()-1;
        int lw=0,rw=0,amount=0;;
        while(l<=r)
        {
            if(lw<=rw)
            {
                if(height[l]<lw)
                    amount=amount+lw-height[l];         
                else
                    lw=height[l];
                l++;                    
            }
            else
            {
                if(height[r]<rw)
                    amount=amount+rw-height[r];
                else
                    rw=height[r];
                r--;
            }
        }
        return amount;
    }
};