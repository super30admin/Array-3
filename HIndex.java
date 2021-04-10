package Array-3;

// Time Complexity : O(n)
// Space Complexity : O(n)

public class HIndex {
    class Solution {
        public int hIndex(int[] citations) {
            int n = citations.length;
            int [] count = new int[n+1];
            
            for(int i=0;i<citations.length;i++)
            {
                if(citations[i]>=n)
                {
                    count[n]++;
                }else{
                    count[citations[i]]++;
                }
                
            }
            int countSum = 0;
            for(int i=n;i>=0;i--)
            {
                countSum+=count[i];
                if(countSum>=i)
                {
                  return i;   
                }
            }
            
            return 0;
        }
    }
    
}
