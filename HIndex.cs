//time complexity - O(n)
//space - O(1)
public class Solution
{
    public int HIndex(int[] citations)
    {
        int total = 0;
        int n = citations.Length;
        int[] temp = new int[n + 1];

        foreach (int num in citations)
        {
            if (num >= n)
            {
                temp[n]++;
            }
            else
            {
                temp[num]++;
            }
        }
        for (int i = n; i >= 0; i--)
        {
            total = total + temp[i];

            if (total >= i)
            {
                return i;
            }
        }
        return 0;
    }
}