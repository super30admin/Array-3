//TC : O(N)
//SC : O(1)
class Solution {
    public int trap(int[] height) {
        if(height==null || height.length==0) return 0;

        int left =0,lp=0,right=0,rp=height.length-1;
        int count =0;
        while(rp>=lp)
        {
            if(right>=left)
            {
                if(height[lp] > left)
                {
                    left = height[lp];
                }
                else
                {
                    count+=left-height[lp];
                }
                lp++;
            }
            else
            {
                if(height[rp]>right)
                {
                    right = height[rp];
                }
                else
                    count+=right-height[rp];

                rp--;
            }
        }
        return count;


    }
}