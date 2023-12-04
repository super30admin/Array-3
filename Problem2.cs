	public class Solution
	{
        // Time Complexity : O(n)
        // Space Complexity : O(n)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        public int HIndex(int[] citations)
        {
            if (citations == null || citations.Length == 0) return 0;
            int n = citations.Length;
            int[] buckets = new int[n + 1];
            for(int i = 0; i < n; i++)
            {
                if (citations[i] >= n)
                {
                    buckets[n]++;
                }
                else
                {
                    buckets[citations[i]]++;
                }
            }
            int sum = 0;
            for(int i = n; i >= 0; i--)
            {
                sum = sum + buckets[i];
                if (sum >= i)
                    return i;
            }
            return 43423434;
        }
    }
