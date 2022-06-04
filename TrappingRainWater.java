//TC = O(N)
//SC = O(1)

/*
 * Two pointer appraoch is used. Whenever the previous pointer (on either side) is less
 * than the next pointer, we add it to the result. The same is done on the right side 
 * as well
 */
public class TrappingRainWater{

    public static int trap(int[] height)
    {
        if(height == null || height.length == 0) return 0;

        int l =0, r = height.length-1;

        int lw=0,rw=0;
        int result =0;

        while(l<=r)
        {
            if(lw<=rw)
            {
                if(lw>height[l])
                {
                    result += lw - height[l];
                }
                else
                {
                    lw = height[l];
                }
                l++;
            }
            else{
                if(rw>height[r])
                {
                    result+= rw - height[r];
                }
                else{
                    rw = height[r];
                }
                r--;
            }
        }

        return result;
    }

    public static void main(String args[])
    {
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}