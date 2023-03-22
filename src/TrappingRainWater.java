//Time Complexity : O(N) 
//Space Complexity : O(1) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Take two pointers l and r. Take maxLeft and maxRight which points to either
 * ends of the array. While l < r, check which is smaller height at l or r, then
 * get the max of that current index with maxLeft or maxRight respectively and
 * find the difference between the max and current index and add it to the final
 * ans. return ans.
 *
 */
class Solution {
	public int trap(int[] height) {
		int n = height.length;
		int l = 0, r = n - 1;
		int ans = 0;
		int maxLeft = height[0], maxRight = height[n - 1];
		while (l < r) {
			if (height[l] <= height[r]) {
				maxLeft = Math.max(maxLeft, height[l]);
				ans += (maxLeft - height[l]);
				l++;
			} else {
				maxRight = Math.max(maxRight, height[r]);
				ans += (maxRight - height[r]);
				r--;
			}
		}
		return ans;
	}
}
