// Optimized Approach
// tc O(N)
//sc O(N)
class Solution {

    public int trap(int[] height) {
        int n = height.length, ans = 0;

        int left[] = new int[n];
        left[0] = height[0];
        for (int i = 1; i < n; ++i)
            left[i] = Math.max(left[i - 1], height[i]);

        int right[] = new int[n];
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i)
            right[i] = Math.max(right[i + 1], height[i]);

        for (int i = 0; i < n; i++)
            ans += Math.min(left[i], right[i]) - height[i];

        return ans;
    }
}

// BruteForce approach
/*
 * 1. we will run a for loop and for every index we will run two other nest for loop to find the leftmax wall and
 * rightmax wall for that index to hold water.
 * 2. area = area + Math.min(leftwall, rightwall) - height[i];
 * 3. for every index, we will reset lwall and right wall to get new answer.
 tc - O(n^2), sc -O(1)
 */


class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;

        int n = height.length;
        int left =0, right =0;
        int area =0;

        for(int i=0; i<n; i++)
        {
            left =0; right =0;
            //look for left wall
            for(int j =i; j>=0; j--)
            {
                left = Math.max(left, height[j]);
            }
            //look for right wall
            for(int k = i; k<n; k++ )
            {
                right = Math.max(right, height[k]);
            }

            area = area+ Math.min(left, right) - height[i];
        }
        return area;
    }
}
