//Time complexity: O(n)
//Space complexity: O(1)

class Solution {
    public int trap(int[] height) {
        
        int RW = 0;
        int LW = 0;
        
        int L = 0;
        int R = height.length - 1;
        int amount = 0;
               
        while(L <= R)
        {
            if(LW < RW)
            {
                if(LW < height[L])
                {
                    LW = height[L];
                }
                else
                {
                    amount += (LW-height[L]);
                }
                L++;
                
            }
            else
            {
                if(RW < height[R])
                {
                    RW = height[R];
                }
                else
                {
                    amount += (RW-height[R]);
                }
                R--;
                
            }
        }
        return amount;
    }
}