// Time Complexity : O(2n) ->O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
public class hIndex1 {
        public int hIndex(int[] citations) {
            int n = citations.length;
            int[] bs = new int[n+1];

            for(int i=0; i<n; i++)
            {
                if(citations[i]>n)
                {
                    bs[n]++;
                }
                else
                {
                    bs[citations[i]]++;
                }
            }
            int sum = 0;
            for(int i = n; i>=0; i--)
            {
                sum += bs[i];
                if(i <= sum)
                {
                    return i;
                }
            }

            return -1;
        }
    }
