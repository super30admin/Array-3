// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Use 4 pointers. For left and right wall; lw, rw respectively.
 * Two pointers l and r to iterate from start and end of input array.
 * If lw <= rw then water can be trapped between lw and l if l < lw, else update lw and increment l.
 * If rw > lw then water can be trapped between rw and r if r < lw, else update rw and decrement r.
 */

class Solution {
public:
    int trap(vector<int>& height) {
        if (height.size() == 0)
        {
            return 0;
        }
        
        // Actual heights.
        int lw = 0, rw = 0;
        
        // Index
        int l = 0, r = height.size() - 1;
        
        int result = 0;
        
        // Because l and r are index.
        while (l <= r)
        {
            if (lw <= rw)
            {
                if (lw > height[l])
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
                if (rw > height[r])
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