//Time complexity : O(n)
//Space compexity : O(1)

//Approach :
            // Keep track of left wall and right wall along with left and right
            // Calculate if left wall and left can trap any water
            // Calculate if right wal and right can trap any water
            // Whichever wall is lesser should be considered and moved 

class Solution {
public:
    int trap(vector<int>& height) {
        if(height.size() == 0)
            return 0;
        
        int rw = 0, r = height.size() - 1;
        int lw = 0, l = 0;
        int result = 0;
        while(l <= r)
        {
            if(lw <= rw)
            {
                if(lw > height[l])
                {
                    result += lw - height[l];
                }
                else
                {
                    lw = height[l];
                }
                l++;
            }
            else
            {
                if(rw > height[r])
                {
                    result += rw - height[r];
                }
                else
                {
                    rw = height[r];
                }
                r--;
            }
        }
        
        return result;
    }
};