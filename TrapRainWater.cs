//Approach

// Use two pointers from left and right with max height trackers (lw and rw).
// Move the pointer with the smaller max, accumulating trapped water based on difference between max and current height.
// Repeat until pointers meet.

// Complexities:
// Time: O(n) 
// Space: O(1) 

public class Solution
{
    public int Trap(int[] height)
    {
        int n = height.Length;
        int l = 0, lw = 0, r = n - 1, rw = 0; int result = 0;
        while (l <= r)
        {
            if (lw < rw)
            {
                if (height[l] > lw)
                {
                    lw = height[l];
                }
                else
                {
                    result += lw - height[l];
                }
                l++;
            }
            else
            {
                if (height[r] > rw)
                {
                    rw = height[r];
                }
                else
                {
                    result += rw - height[r];
                }
                r--;
            }
        }
        return result;
    }
}