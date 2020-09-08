//time complexity : O(n) where n is the length of the array
//space complexity: O(1)
//executed on leetcode: yes
class Solution {
    public int trap(int[] height) {
        if(height.length<2) return 0; // there is only one building, so we cant trap water
        int lw = 0; int rw = 0; int l = 0;
        int n = height.length;
        int r = n-1;
        int result = 0;
        //we are taking imaginary left wall and right wall. 
        while(l<=r)
        {
            if(lw<=rw) //process left side;water will be trapped based on left wall since its height is less than or equal to the right wall
            {
                if(lw>height[l]) //we can trap water
                {
                    result += lw - height[l];
                }
                else //we cant trap water
                {
                    lw = height[l];
                }
                l++;
            }
            else //process right side;water will be trapped based on right wall since its height is less
            {
                if(rw>height[r]) //we can trap water
                {
                    result+=rw-height[r];
                }
                else //we cant trap water
                {
                    rw = height[r];
                }
                r--;
            }
        }
        return result;
    }
}