// TC => O(n)
// SC => O(n)

public class Solution
{
    public int HIndex(int[] citations)
    {
        if (citations == null || citations.Length == 0)
        {
            return 0;
        }

        int n = citations.Length;
        int[] hindex = new int[n + 1];
        for (int i = 0; i < n; i++)
        {
            if (citations[i] >= n)
            {
                hindex[n]++;
                continue;
            }
            hindex[citations[i]]++;
        }
        int total = 0;
        for (int i = n; i >= 0; i--)
        {
            total += hindex[i];
            if (total >= i)
            {
                return i;
            }
        }
        return 0;
    }
}