// Time Complexity : O(n)
// Space Complexity : O(n)
// Method used : Counting Sort

class Solution {
    public int hIndex(int[] citations) {
        
        // If we use sort function the time would be nlogn but what if we apply counting sort. This is because we are quite
        // sure that we would be having n papers in worst case and our array needs to be that size.

        // Look IPAD for detailed explanation

        int n = citations.length;

        int[] result = new int[n + 1];

        for(int i = 0; i < n; i++)
        {
            result[Math.min(citations[i], n)]++;
        }

        int sum = result[n];
        int k = n;

        while(k > sum)
        {
            k--;
            sum += result[k];
        }

        return k;
    }
}