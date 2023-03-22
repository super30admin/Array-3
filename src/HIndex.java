import java.util.Arrays;
//Time Complexity : O(N) 
//Space Complexity : O(1) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * We have to find the point at which there are h or more citations on the right
 * and remaning n-h with less than h citations. Iterate from last and check if
 * citations of that index > h which starts from 0.
 *
 */
class Solution {
	public int hIndex(int[] citations) {
		Arrays.sort(citations);
		int i = 0;
		while (i < citations.length && citations[citations.length - i - 1] > i)
			i++;
		return i;
	}
}