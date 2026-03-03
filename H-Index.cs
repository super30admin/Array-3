// Approach:

// Count how many papers have each citation using a bucket array capped at n.
// Iterate from high to low, summing counts until the cumulative sum ≥ current index.
// The first index that satisfies this is the H-Index.

// Complexities:
// Time: O(n) 
// Space: O(n) 
public class Solution
{
    public int HIndex(int[] citations)
    {
        int n = citations.Length;
        int[] bucket = new int[n + 1];
        for (int i = 0; i < n; i++)
        {
            if (citations[i] >= n)
            {
                bucket[n]++;
            }
            else
            {
                bucket[citations[i]]++;
            }
        }
        int sum = 0;
        for (int i = n; i >= 0; i--)
        {
            sum += bucket[i];
            if (sum >= i)
            {
                return i;
            }
        }
        return 0;
    }
}