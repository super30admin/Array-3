/*
Time Complexity : O(logN) + O(N)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

 */
class Solution 
{
    public int hIndex(int[] citations) 
    {
            if (citations == null || citations.length == 0) {
                return 0;
            }

            Arrays.sort(citations);
        
            for (int i = 0; i < citations.length; i++) 
            {
                if (citations[i] >= citations.length - i) 
                {
                    return citations.length - i;
                }
            }
            return 0;
    }
}