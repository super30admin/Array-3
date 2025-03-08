// TC => O(n)
// SC => O(1)

public class Solution
{
    public int Trap(int[] height)
    {
        if (height == null || height.Length == 0)
        {
            return 0;
        }

        int n = height.Length, total = 0;
        int left = 0, right = n - 1, lw = 0, rw = 0;

        while (left <= right)
        {
            if (lw <= rw)
            {
                if (height[left] < lw)
                {
                    total += lw - height[left];
                }
                else
                {
                    lw = height[left];
                }
                left++;
            }
            else
            {
                if (height[right] < rw)
                {
                    total += rw - height[right];
                }
                else
                {
                    rw = height[right];
                }
                right--;
            }
        }
        return total;
    }
}