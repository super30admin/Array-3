class Solution {
    //Time O(N)
    //Space O(1)
    public int trap(int[] height) {
        if(height == null || height.length == 0)
        {
            return 0;
        }
        int L_Max = 0 , R_Max = 0 , l = 0 , r = height.length-1 , result = 0;
        while(l <= r)
        {
            if(L_Max <= R_Max)
            {
                if(L_Max < height[l]) 
                {
                    L_Max = height[l];
                }
                else
                {
                    result += L_Max - height[l];
                }
                l++;
            }
            else
            {
                if(R_Max < height[r])
                {
                    R_Max = height[r];
                }
                else
                {
                    result += R_Max - height[r];
                }
                r--;
            }
        }
        return result;
    }
}