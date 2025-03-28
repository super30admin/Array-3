// time complexity - O(n)
//Space complexity - O(1)
public class Solution
{
    public int Trap(int[] height)
    {
        // with single pass
        int sum = 0;
        int leftMax = 0;
        int rightMax = 0;
        int i = 0;
        int j = height.Length - 1;
        while (i < j)
        {
            leftMax = Math.Max(leftMax, height[i]);
            rightMax = Math.Max(rightMax, height[j]);
            if (leftMax < rightMax)
            {
                sum += leftMax - height[i];
                i++;
            }
            else
            {
                sum += rightMax - height[j];
                j--;
            }
        }
        // With two pass
        // int max = 0;
        // int maxheightIdx=0;
        // for(int i = 0; i<height.Length;i++) // O(n)
        // {
        //     if(max<height[i])
        //     {
        //         max = height[i];
        //         maxheightIdx=i;
        //     }
        // }
        // int lw=0;
        // // O(n) for both for loops
        // for(int i = 0; i<maxheightIdx;i++) 
        // {
        //     lw = Math.Max(lw,height[i]);
        //     sum += Math.Min(max,lw)-height[i];
        // }
        // int rw=0;
        // for(int i = height.Length-1; i>maxheightIdx;i--)
        // {
        //     rw = Math.Max(rw,height[i]);
        //     sum += Math.Min(max,rw)-height[i];
        // }

        return sum;
    }
}