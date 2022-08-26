//Time Complexity: O(n); where n is the length of the height array.
//Space Complexity: 0(1)
//Code run successfully on LeetCode.

public class Problem1 {

    public int trap(int[] height) {
        
        if(height == null|| height.length == 0)
            return -1;
        
        int n = height.length;
        int lw =0, rw =0;
        int l =0, r= n-1;
        
        int result = 0;
        
        while( l <=r)
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
}
